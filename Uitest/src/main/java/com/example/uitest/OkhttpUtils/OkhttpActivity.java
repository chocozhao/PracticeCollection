package com.example.uitest.OkhttpUtils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uitest.MVP.Bean.User;
import com.example.uitest.R;
import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;

public class OkhttpActivity extends AppCompatActivity implements View.OnClickListener {

    private Button OkhttpUtils_get;
    private TextView TextView;
    private Button OkhttpUtils_post;

    public class MyStringCallback extends StringCallback {
        private static final String TAG = "OkhttpActivity";

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
            TextView.setText("onError:" + e.getMessage());
        }

        @Override
        public void onResponse(String response, int id) {
            Log.e(TAG, "onResponse：complete");
            TextView.setText("onResponse:" + response);

            switch (id) {
                case 100:
                    break;
                case 101:
                    Toast.makeText(OkhttpActivity.this, "https", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }

        @Override
        public void inProgress(float progress, long total, int id) {
            Log.e(TAG, "inProgress:" + progress);
//            mProgressBar.setProgress((int) (100 * progress));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);

        OkhttpUtils_get = findViewById(R.id.OkhttpUtils_get);
        OkhttpUtils_post = findViewById(R.id.OkhttpUtils_post);
        TextView = findViewById(R.id.TextView);

        OkhttpUtils_get.setOnClickListener(this);
        OkhttpUtils_post.setOnClickListener(this);
    }

    public void getDataGet() {
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils.get()
                .url(url)
                .addParams("Username", "chocozhao")
                .addParams("password", "123")
                .build()
                .execute(new MyStringCallback());

    }

    public void getDataPost() {

        String url = "http://www.csdn.net/";
        OkHttpUtils
                .post()
                .url(url)
                .addParams("username", "hyman")
                .addParams("password", "123")
                .build()
                .execute(new MyStringCallback());
    }

    public void PostJSON() {
        String url = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
        OkHttpUtils
                .postString()
                .url(url)
                .content(new Gson().toJson(new User("zhy", "123")))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new MyStringCallback());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.OkhttpUtils_get:
                getDataGet();
                break;
            case R.id.OkhttpUtils_post:
                getDataPost();
                break;
//            case R.id.OkhttpUtils_post:
//                PostJSON();
//                break;
            default:
                break;
        }
    }
}
