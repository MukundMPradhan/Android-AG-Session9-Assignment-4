package acadgild.assignment.session9_assignment_4.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import acadgild.assignment.session9_assignment_4.R;
import acadgild.assignment.session9_assignment_4.model.User;

/**
 * Created by mukund on 20/5/16.
 */
public class CustomAdapter extends BaseAdapter {

    ArrayList<User> userArrayList;
    Context mContext;
    LayoutInflater layoutInflater;

    public CustomAdapter(Context mContext, ArrayList<User> userArrayList) {
        this.mContext = mContext;
        this.userArrayList = userArrayList;
        layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return userArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_format, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.tvName);
        TextView phone = (TextView) convertView.findViewById(R.id.tvPhone);
        TextView dob = (TextView) convertView.findViewById(R.id.tvDOB);

        User newUser = userArrayList.get(position);

        name.setText(newUser.getName());
        phone.setText(newUser.getPhone());
        dob.setText(newUser.getDob());

        return convertView;
    }
}
