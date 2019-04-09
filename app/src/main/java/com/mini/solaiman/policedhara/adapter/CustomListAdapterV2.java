package com.mini.solaiman.policedhara.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mini.solaiman.policedhara.R;
import com.mini.solaiman.policedhara.model.Item;

import java.util.ArrayList;


public class CustomListAdapterV2 extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;
    private Typeface type;

    public CustomListAdapterV2(Context context, ArrayList<Item> items) {
        //this.type = Typeface.createFromAsset(context.getAssets(),"fonts/BenSenHandwriting.ttf");
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
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_parttwo_listview, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item currentItem = (Item) getItem(position);
        viewHolder.itemName.setText(currentItem.getItemName());
        return convertView;
    }

    //ViewHolder inner class
    private class ViewHolder {
        TextView itemName;
        public ViewHolder(View view) {
            itemName = (TextView) view.findViewById(R.id.partBtnx);
            itemName.setTypeface(type);
        }
    }
}
