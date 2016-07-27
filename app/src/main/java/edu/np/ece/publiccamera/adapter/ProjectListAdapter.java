package edu.np.ece.publiccamera.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.np.ece.publiccamera.R;
import edu.np.ece.publiccamera.model.Project;

/**
 * Created by zqi2 on 20/5/2016.
 */
public class ProjectListAdapter extends ArrayAdapter<Project> {
    private static final String TAG = ProjectListAdapter.class.getSimpleName();

    private Context context;
    private int resource;
    private ArrayList<Project> list;
    LayoutInflater inflater;

    public ProjectListAdapter(Context context, int resource, ArrayList<Project> list) {
        super(context, resource, list);
        this.context = context;
        this.resource = resource;
        this.list = list;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            // inflate a view only if no more view to be recycled
            convertView = inflater.inflate(resource, parent, false);

            // keep track of the sub-views using the holder
            viewHolder = new ViewHolder();
            viewHolder.tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
            viewHolder.tvRemark = (TextView) convertView.findViewById(R.id.tvInfo);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Project project = list.get(position);
        viewHolder.tvLabel.setText(project.getLabel());
        viewHolder.tvRemark.setText(project.getRemark());

        return convertView;

    }

    class ViewHolder {
        protected TextView tvLabel;
        protected TextView tvRemark;
    }

}
