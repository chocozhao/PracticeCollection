package activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 赵泳霖 on 2017/8/4.
 */

public class OKHttpActivity extends Activity implements View.OnClickListener {

    public static final String URL = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    private static final int GET = 1;
    private static final int POST = 2;
    private Button btn_get;
    private Button btn_psot;
    private TextView tv_result;
    private OkHttpClient client = new OkHttpClient();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case GET:
                    //获取数据
                    tv_result.setText((String) msg.obj);
                    break;
                case POST:
                    //获取数据
                    tv_result.setText((String) msg.obj);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_psot = (Button) findViewById(R.id.btn_post);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_get.setOnClickListener(this);
        btn_psot.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(OKHttpActivity.this, "Ing", Toast.LENGTH_SHORT).show();
        switch (v.getId()) {
            case R.id.btn_get://使用原生的okhttp请求网络数据，get和post
                // tv_result.setText("");
                // getDataFromGet();//点击事件
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String s = get(URL);
                            Log.d("Ai", s);
                            Message msg = Message.obtain();
                            msg.what = GET;
                            msg.obj = s;
                            handler.sendMessage(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            case R.id.btn_post://使用原生的okhttp请求网络数据，get和post
                // tv_result.setText("");
                // getDataFromGet();//点击事件
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String s = post(URL,"");
                            Log.d("Ai", s);
                            Message msg = Message.obtain();
                            msg.what = GET;
                            msg.obj = s;
                            handler.sendMessage(msg);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;

          /*      break;
            case R.id.btn_post:
                getDataFromPost();
                break;*/
        }
    }

    /*
    * get请求数据
    * */
    private void getDataFromGet() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String resutl = null;
                try {
                    String result = post(URL, "");
                    Log.e("TAG", result);
                    Message msg = Message.obtain();
                    msg.what = POST;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /*
     * post请求数据
    * */
    private void getDataFromPost() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String resutl = null;
                try {
                    String result = post(URL, "");
                    Log.e("TAG", result);
                    Message msg = Message.obtain();
                    msg.what = POST;
                    msg.obj = result;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /*
    * get请求
    * */
    private String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        String a = response.body().string();
        Log.d("resu", response.body().toString());
        return a;
    }

    /*
    * post请求
    * */
    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Log.d("请求","成功");
        return response.body().string();
    }
}