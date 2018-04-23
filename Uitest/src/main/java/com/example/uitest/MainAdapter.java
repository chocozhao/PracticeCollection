package com.example.uitest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chocozhao on 2018/3/18.
 */

public class MainAdapter extends ArrayAdapter<ItemName> {
    private int resourceId;

    public MainAdapter(@NonNull Context context, int textViewResourceId, List<ItemName> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemName itemName = getItem(position);

        View view;
        ViewHelper viewHelper;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

             viewHelper = new ViewHelper();
            viewHelper.itemname_name = view.findViewById(R.id.itemname_name);

            view.setTag(viewHelper);//存储到View中
        }else {
            view = convertView;
            viewHelper = (ViewHelper) view.getTag();//从View中读取出来
        }
        viewHelper.itemname_name.setText(itemName.getName());
        return view;
    }
    //将控件实例进行缓存
    class ViewHelper{
        TextView itemname_name;
    }
}

