package edu.np.ece.publiccamera.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.np.ece.publiccamera.R;
import edu.np.ece.publiccamera.model.Node;
import edu.np.ece.publiccamera.model.NodeFile;

/**
 * Created by zqi2 on 20/5/2016.
 */
public class NodeListAdapter extends ArrayAdapter<Node> {
    private static final String TAG = NodeListAdapter.class.getSimpleName();
    Context context;
    int resourceId;
    ArrayList<Node> list;
    LayoutInflater inflater;

    public NodeListAdapter(Context context, int resource, ArrayList<Node> list) {
        super(context, resource, list);
        this.context = context;
        this.resourceId = resource;
        this.list = list;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ProgressDialog loading = ProgressDialog.show(context, "Fetching Data", "Please wait...", false, false);

        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_node, parent, false);
            holder = new ViewHolder();
            holder.tvLabel = (TextView) convertView.findViewById(R.id.tvTitle);
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.tvCreated = (TextView) convertView.findViewById(R.id.tvCreated);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Node obj = list.get(position);
        holder.tvLabel.setText(obj.getLabel());
//        NodeData nd = obj.getLatestCrowdIndex();
//        if (nd != null) {
//            Log.i(TAG, "Crowd Index: " + nd.getValue());
//            holder.tvCreated.setText(nd.getCreated());
//        } else {
//            Log.w(TAG, "Latest Crowd Index is null.");
//        }
        NodeFile nf = obj.getLatestNodeFile();
        if (nf != null) {
            Log.i(TAG, "Noe File URL: " + nf.getFileUrl());
            Picasso.with(context).load(nf.getFileUrl()).into(holder.imageView);
        } else {
            Log.w(TAG, "Latest Node File is null");
        }

        loading.dismiss();
        return convertView;
    }

    class ViewHolder {
        TextView tvLabel;
        ImageView imageView;
        TextView tvCreated;
    }

}
