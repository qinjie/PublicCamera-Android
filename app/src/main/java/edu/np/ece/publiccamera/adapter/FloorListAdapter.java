package edu.np.ece.publiccamera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import edu.np.ece.publiccamera.R;
import edu.np.ece.publiccamera.model.Floor;
import edu.np.ece.publiccamera.model.FloorData;

/**
 * Created by zqi2 on 20/5/2016.
 */
public class FloorListAdapter extends ArrayAdapter<Floor> {
    private static final String TAG = FloorListAdapter.class.getSimpleName();
    Context context;
    int resourceId;
    ArrayList<Floor> list;
    LayoutInflater inflater;

    public FloorListAdapter(Context context, int resource, ArrayList<Floor> list) {
        super(context, resource, list);
        this.context = context;
        this.resourceId = resource;
        this.list = list;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_floor, parent, false);
            holder = new ViewHolder();
            holder.tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
            holder.tvInfo = (TextView) convertView.findViewById(R.id.tvInfo);
            holder.tvCreated = (TextView) convertView.findViewById(R.id.tvCreated);
            holder.tvCrowdIndex = (TextView) convertView.findViewById(R.id.tvCrowdIndex);
            holder.progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Floor obj = list.get(position);
        holder.tvLabel.setText(obj.getLabel());
        holder.tvInfo.setText(obj.getNodeCount() + " cameras");
        FloorData crowd = obj.getLatestCrowdIndex();
        if (crowd != null) {
            holder.tvCrowdIndex.setText(String.valueOf(crowd.getValue()));
            holder.tvCreated.setText(crowd.getCreated());
            holder.progressBar.setProgress(crowd.getValue());
        }
        return convertView;
    }

    class ViewHolder {
        TextView tvLabel;
        TextView tvInfo;
        TextView tvCreated;
        TextView tvCrowdIndex;
        ProgressBar progressBar;
    }

}
