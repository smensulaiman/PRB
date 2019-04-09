package com.mini.solaiman.policedhara.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mini.solaiman.policedhara.R;


public class CustomIndexAdapter extends BaseAdapter {

    private Context context;
    private String[] names;

    public CustomIndexAdapter(Context context,String [] names){
        this.context = context;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_index, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String name = names[i];
        viewHolder.index.setText(name);

        return convertView;
    }

    private class ViewHolder {
        TextView index;
        //TextView itemDescription;

        public ViewHolder(View view) {
            index = (TextView)view.findViewById(R.id.index);
            //itemDescription = (TextView) view.findViewById(R.id.desc);
        }
    }
}
