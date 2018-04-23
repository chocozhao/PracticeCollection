package com.example.okhttptest;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.okhttptest.domain.DataBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;

import java.util.List;

import okhttp3.Call;

/**
 * Created by 赵泳霖 on 2017/11/16.
 */

public class OkhttpListAdapter extends BaseAdapter {

    ViewHolder viewHolder;
    private final Context context;
    private final List<DataBean.ItemData> datas;

    public OkhttpListAdapter(Context context, List<DataBean.ItemData> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_okhttp_list_image, null);
            viewHolder = new ViewHolder();
            viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
            viewHolder.tv_naem = (TextView) convertView.findViewById(R.id.tv_name);
            viewHolder.tv_desc = (TextView) convertView.findViewById(R.id.tv_desc);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //根据位置得到数据
        DataBean.ItemData itemData = datas.get(position);
        viewHolder.tv_naem.setText(itemData.getMovieName());
        viewHolder.tv_desc.setText(itemData.getVideoTitle());

        //在列表中使用okhttp-utils请求图片

        OkHttpUtils
                .get()//
                .url(itemData.getCoverImg())//
                .tag(this)//
                .build()//
                .connTimeOut(20000)
                .readTimeOut(20000)
                .writeTimeOut(20000)
                .execute(new BitmapCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        //  tv_result.setText("onError:" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Bitmap bitmap, int id) {
                        Log.e("TAG", "onRespon se：complete");
                        viewHolder.iv_icon.setImageBitmap(bitmap);
                    }
                });
        return convertView;
    }

    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_naem;
        TextView tv_desc;

    }
}
