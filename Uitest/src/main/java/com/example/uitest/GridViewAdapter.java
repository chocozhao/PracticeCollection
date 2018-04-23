package com.example.uitest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chocozhao on 2018/3/19.
 */

public class GridViewAdapter extends BaseAdapter {
    private String[] names;
    private int[] icons;
    private Context context;
    public GridViewAdapter(Context context, String[] names, int[] icons) {
        this.context = context;
        this.names = names;
        this.icons = icons;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView , ViewGroup viewGroup) {
        
        if(convertView == null) {
            convertView  = View.inflate(context, R.layout.activity_item_gridview, null);
        }

        ImageView gv_item_icon = convertView .findViewById(R.id.gv_item_icon);
        TextView gv_item_name = convertView.findViewById(R.id.gv_item_name);
        gv_item_icon.setImageResource(icons[position]);
        gv_item_name.setText(names[position]);
        return convertView;
    }
}
