package edu.np.ece.publiccamera;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.np.ece.publiccamera.adapter.FloorListAdapter;
import edu.np.ece.publiccamera.api.ApiConstant;
import edu.np.ece.publiccamera.api.FloorApi;
import edu.np.ece.publiccamera.model.Floor;
import edu.np.ece.publiccamera.model.FloorList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FloorListActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private static final String TAG = FloorListActivity.class.getSimpleName();
    Context context;

    TextView tvStatus;
    Button btRefresh;

    ListView listView;
    FloorListAdapter listAdapter;
    ArrayList<Floor> arrayList;

    Retrofit retrofit = null;

    Integer projectId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_list);
        context = this.getBaseContext();

        if (getActionBar() != null) {
            getActionBar().setHomeButtonEnabled(true);
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent i = this.getIntent();
        if (i != null) {
            if (i.hasExtra("PROJECT_ID"))
                projectId = i.getIntExtra("PROJECT_ID", 0);
            if (i.hasExtra("PROJECT_LABEL")) {
                String projectLabel = i.getStringExtra("PROJECT_LABEL");
                this.setTitle(projectLabel);
            }
        }

        tvStatus = (TextView) this.findViewById(R.id.tvStatus);
        listView = (ListView) this.findViewById(R.id.lvFloor);
        arrayList = new ArrayList<Floor>();
        listAdapter = new FloorListAdapter(this, R.layout.list_item_floor, arrayList);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(this);
        getFloors();
    }

    private void getFloors() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        FloorApi api = retrofit.create(FloorApi.class);
        Call<FloorList> call;
        if (projectId != null) {
            Log.i(TAG, "Search floor by project ID " + projectId);
            call = api.searchByProject(projectId);
        } else {
            Log.i(TAG, "List floor");
            call = api.list();
        }

        call.enqueue(new Callback<FloorList>() {
            @Override
            public void onResponse(Call<FloorList> call, Response<FloorList> response) {
                //Dismissing the loading progressbar
                loading.dismiss();

                FloorList data = response.body();
                Log.i(TAG, "Response: " + response.raw().toString());
                Log.i(TAG, "Response.message: " + response.message());
                Log.i(TAG, "Success. Status code = " + response.code());
                if (response.code() != 200)
                    return;

                if (data != null && data.getFloors() != null)
                    Log.d(TAG, "Floor count = " + data.getFloors().size());
                arrayList.clear();
                arrayList.addAll(data.getFloors());
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<FloorList> call, Throwable t) {
                //Dismissing the loading progressbar
                loading.dismiss();

                tvStatus.setText("Error: " + t.getMessage());
                tvStatus.setVisibility(View.VISIBLE);
            }

        });

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ListView lv = (ListView) adapterView;
        Floor item = arrayList.get(i);

        Intent intent = new Intent(context, FloorActivity.class);
        intent.putExtra("PROJECT_ID", projectId);
        intent.putExtra("FLOOR_ID", item.getId());
        intent.putExtra("FLOOR_LABEL", item.getLabel());

        if (item.getLatestCrowdIndex() != null)
            intent.putExtra("CROWD_INDEX", item.getLatestCrowdIndex().getValue());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_floor_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            case android.R.id.
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
