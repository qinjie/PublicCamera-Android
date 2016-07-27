package edu.np.ece.publiccamera;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.np.ece.publiccamera.adapter.ProjectListAdapter;
import edu.np.ece.publiccamera.api.ApiConstant;
import edu.np.ece.publiccamera.api.ProjectApi;
import edu.np.ece.publiccamera.model.Project;
import edu.np.ece.publiccamera.model.ProjectList;
import edu.np.ece.publiccamera.util.InternetDetector;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    Context context;

    TextView tvStatus;
    Button btRefresh;

    ListView listView;
    ProjectListAdapter listAdapter;
    ArrayList<Project> arrayList;

    Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this.getBaseContext();
        tvStatus = (TextView) this.findViewById(R.id.tvStatus);
        btRefresh = (Button) this.findViewById(R.id.btRefresh);
        btRefresh.setOnClickListener(listenerRefresh);

        listView = (ListView) this.findViewById(R.id.lvProject);
        arrayList = new ArrayList<Project>();
        listAdapter = new ProjectListAdapter(this, R.layout.list_item_project, arrayList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);

        getProjects();
    }

    private void getProjects() {

        if (!checkInternetConnection()) {
            return;
        }

        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        ProjectApi api = retrofit.create(ProjectApi.class);
        Call<ProjectList> call = api.list();

        call.enqueue(new Callback<ProjectList>() {
            @Override
            public void onResponse(Call<ProjectList> call, Response<ProjectList> response) {
                //Dismissing the loading progressbar
                loading.dismiss();

                ProjectList data = response.body();
                Log.i(TAG, "Success. Status code = " + response.code());
                Log.d(TAG, "Project count =" + data.getProjects().size());
                arrayList.clear();
                arrayList.addAll(data.getProjects());
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProjectList> call, Throwable t) {
                //Dismissing the loading progressbar
                loading.dismiss();

                tvStatus.setText("Error: " + t.getMessage());
                tvStatus.setVisibility(View.VISIBLE);
            }

        });

    }

    private boolean checkInternetConnection() {
        InternetDetector detector = new InternetDetector(context);
        boolean hasInternet = detector.isNetworkAvailable();
        if (hasInternet) {
            tvStatus.setVisibility(View.GONE);
            btRefresh.setVisibility(View.GONE);
        } else {
            tvStatus.setText("No internet connection.");
            tvStatus.setVisibility(View.VISIBLE);
            btRefresh.setVisibility(View.VISIBLE);
        }

        return hasInternet;
    }

    private View.OnClickListener listenerRefresh = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getProjects();
        }
    };

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListView lv = (ListView) adapterView;
        Project item = arrayList.get(i);

        Intent intent = new Intent(context, FloorListActivity.class);
        intent.putExtra("PROJECT_ID", item.getId());
        intent.putExtra("PROJECT_LABEL", item.getLabel());
        startActivity(intent);
    }
}
