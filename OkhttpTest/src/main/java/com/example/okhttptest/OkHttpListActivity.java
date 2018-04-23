package com.example.okhttptest;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.okhttptest.domain.DataBean;
import com.example.okhttptest.utils.CacheUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Request;

import static android.content.ContentValues.TAG;

/**
 * Created by 赵泳霖 on 2017/11/15.
 */
public class OkHttpListActivity extends Activity {

    private ListView listView;
    private ProgressBar progressBar;
    private TextView tv_nodata;
    private OkhttpListAdapter adapter;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttplist);

        intiView();
        getDataFromNet();

    }

    private void getDataFromNet() {
//        String url = "http://www.zhiyun-tech.com/App/Rider-M/changelog-zh.txt";
//        String url = "http://www.391k.com/api/xapi.ashx/info.json?key=bd_hyrzjjfb4modhj&size=10&page=1";
        url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        //得到缓存的数据
        String saveJson = CacheUtils.getString(this, url);
        if (!TextUtils.isEmpty(saveJson)) {
            processData(saveJson);
        }
        OkHttpUtils
                .post()
                .url(url)
                .id(100)
                .build()
                .execute(new OkHttpListActivity.MyStringCallback());
    }

    private void intiView() {
        tv_nodata = (TextView) findViewById(R.id.tv_nodata);
        listView = (ListView) findViewById(R.id.listview);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    public class MyStringCallback extends StringCallback {
        @Override
        public void onBefore(Request request, int id) {
            setTitle("loading...");
        }

        @Override
        public void onAfter(int id) {
            setTitle("Sample-okHttp");
        }

        @Override
        public void onError(Call call, Exception e, int id) {
            e.printStackTrace();
            tv_nodata.setVisibility(View.VISIBLE);
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e(TAG, "onResponse：complete");
            tv_nodata.setVisibility(View.GONE);
            switch (id) {
                case 100:
                    Toast.makeText(OkHttpListActivity.this, "http", Toast.LENGTH_SHORT).show();
                    break;
                case 101:
                    Toast.makeText(OkHttpListActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            //解析数据和显示数据
            if (response != null) {

                CacheUtils.putString(OkHttpListActivity.this, url, response);
                processData(response);
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e(TAG, "inProgress:" + progress);
//            mProgressBar.setProgress((int) (100 * progress));
        }
    }

    private void processData(String json) {

        //解析数据
        DataBean dataBean = parsedJson(json);
        List<DataBean.ItemData> datas = dataBean.getTrailers();

        if (datas != null && datas.size() > 0) {
            //有数据

            tv_nodata.setVisibility(View.GONE);
            //显示适配器
            adapter = new OkhttpListAdapter(OkHttpListActivity.this, datas);
            listView.setAdapter(adapter);
        } else {
            //m没有数据
            tv_nodata.setVisibility(View.VISIBLE);
        }

        progressBar.setVisibility(View.GONE);


    }

    /**
     * 解析json数据
     *
     * @param response
     * @return
     */
    private DataBean parsedJson(String response) {
        DataBean dataBean = new DataBean();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.optJSONArray("trailers");
            if (jsonArray != null && jsonArray.length() > 0) {
                List<DataBean.ItemData> trailers = new ArrayList<>();
                dataBean.setTrailers(trailers);
                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject jsonObjectItem = (JSONObject) jsonArray.get(i);

                    if (jsonObjectItem != null) {

                        DataBean.ItemData mediaItem = new DataBean.ItemData();

                        String movieName = jsonObjectItem.optString("movieName");//name
                        mediaItem.setMovieName(movieName);

                        String videoTitle = jsonObjectItem.optString("videoTitle");//desc
                        mediaItem.setVideoTitle(videoTitle);

                        String imageUrl = jsonObjectItem.optString("coverImg");//imageUrl
                        mediaItem.setCoverImg(imageUrl);

                        String hightUrl = jsonObjectItem.optString("hightUrl");//data
                        mediaItem.setHightUrl(hightUrl);

                        //把数据添加到集合
                        trailers.add(mediaItem);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataBean;
    }
}

