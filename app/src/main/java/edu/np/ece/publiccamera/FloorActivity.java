package edu.np.ece.publiccamera;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import edu.np.ece.publiccamera.adapter.NodeListAdapter;
import edu.np.ece.publiccamera.api.ApiConstant;
import edu.np.ece.publiccamera.api.NodeApi;
import edu.np.ece.publiccamera.model.Node;
import edu.np.ece.publiccamera.model.NodeList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FloorActivity extends AppCompatActivity {
    private static final String TAG = FloorActivity.class.getSimpleName();
    Context context;

    Retrofit retrofit = null;
    Integer projectId = null;
    Integer floorId = null;
    int crowdIndex = 0;

    ProgressBar progressBar;

    TextView tvStatus;
    ListView listView;
    NodeListAdapter listAdapter;
    ArrayList<Node> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor);
        context = this.getBaseContext();

        if (getActionBar() != null) {
            getActionBar().setHomeButtonEnabled(true);
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        Intent i = this.getIntent();
        if (i != null) {
            projectId = i.getIntExtra("PROJECT_ID", 0);
            floorId = i.getIntExtra("FLOOR_ID", 0);
            crowdIndex = i.getIntExtra("CROWD_INDEX", 0);
            String floorLabel = i.getStringExtra("FLOOR_LABEL");
            if (floorLabel != null)
                this.setTitle(floorLabel);
        }

        progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        tvStatus = (TextView) this.findViewById(R.id.tvStatus);
        listView = (ListView) this.findViewById(R.id.listView);
        arrayList = new ArrayList<Node>();
        listAdapter = new NodeListAdapter(this, R.layout.list_item_node, arrayList);
        listView.setAdapter(listAdapter);

        progressBar.setProgress(crowdIndex);
        getNodes();
    }

    private void getNodes() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiConstant.API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        NodeApi api = retrofit.create(NodeApi.class);
        Call<NodeList> call;
        if (projectId != null) {
            Log.i(TAG, "Search nodes by floor ID " + floorId);
            call = api.searchByFloor(floorId);
        } else {
            Log.i(TAG, "List nodes");
            call = api.list();
        }

        call.enqueue(new Callback<NodeList>() {
            @Override
            public void onResponse(Call<NodeList> call, Response<NodeList> response) {
                //Dismissing the loading progressbar
                loading.dismiss();

                NodeList data = response.body();
                Log.i(TAG, "Response: " + response.raw().toString());
                Log.i(TAG, "Response.message: " + response.message());
                Log.i(TAG, "Success. Status code = " + response.code());
                if (response.code() != 200)
                    return;

                if (data != null && data.getNodes() != null)
                    Log.d(TAG, "Floor count = " + data.getNodes().size());
                arrayList.clear();
                arrayList.addAll(data.getNodes());
                listAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<NodeList> call, Throwable t) {
                //Dismissing the loading progressbar
                loading.dismiss();

                tvStatus.setText("Error: " + t.getMessage());
                tvStatus.setVisibility(View.VISIBLE);
            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
