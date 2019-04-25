package com.mini.solaiman.policedhara.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mini.solaiman.policedhara.R;
import com.mini.solaiman.policedhara.model.Item;

import java.util.ArrayList;

public class CustomListAdapterSingle extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;
    int checker = 1;

    public CustomListAdapterSingle(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size(); //returns total item in the list
    }

    @Override
    public Object getItem(int position) {
        return items.get(position); //returns the item at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_part_listview_single, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item currentItem = (Item) getItem(position);
        viewHolder.itemName.setText(currentItem.getItemName());
//        if(position==0){
//            if(checker==1) {
//                viewHolder.itemName.setTextColor(Color.parseColor("#439700"));
//                checker = 0 ;
//            }
//        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 4;
        params.setMargins(2,2,2,2);
        //viewHolder.itemDescription.setText(currentItem.getItemDescription());

        return convertView;
    }

    //ViewHolder inner class
    private class ViewHolder {
        TextView itemName;
        ImageView image;
        LinearLayout layout;
        //TextView itemDescription;

        public ViewHolder(View view) {
            itemName = (TextView) view.findViewById(R.id.partBtn);
            image = view.findViewById(R.id.imageSingle);
            layout = view.findViewById(R.id.layout);
            //itemDescription = (TextView) view.findViewById(R.id.desc);
        }
    }
}
