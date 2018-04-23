package com.example.uitest.HandlerTest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.MessageQueue;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.uitest.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HandlerTestActivity extends Activity {

    private ProgressBar pb_handler1_loading;
    private EditText et_handler1_result;
    //    1. 创建Handler成员变量对象, 并重写其handleMessage()
    //2. 在分/主线程创建Message对象
    //3. 使用handler对象发送Message
    //4. 在handleMessage()中处理消息
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            String result = (String) msg.obj;
            et_handler1_result.setText(result);
            pb_handler1_loading.setVisibility(View.INVISIBLE);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        pb_handler1_loading = (ProgressBar) findViewById(R.id.pb_handler1_loading);
        et_handler1_result = (EditText) findViewById(R.id.et_handler1_result);
    }

    /*
     1. 主线程, 显示提示视图(ProgressDialog/ProgressBar)
     2. 分线程, 联网请求, 并得到响应数据
     3. 主线程, 显示数据/隐藏提示视图
	 */
    public void getSubmit1(View view) {
//        1. 主线程, 显示提示视图(ProgressDialog/ProgressBar)
        pb_handler1_loading.setVisibility(View.VISIBLE);
//        2. 分线程, 联网请求, 并得到响应数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                try {
                    final String result = requestToString(path);

                    //3. 主线程, 显示数据/隐藏提示视图
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            et_handler1_result.setText(result);
                            pb_handler1_loading.setVisibility(View.INVISIBLE);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void getSubmit2(View view) {
        //        1. 主线程, 显示提示视图(ProgressDialog/ProgressBar)
        pb_handler1_loading.setVisibility(View.VISIBLE);
        //        2. 分线程, 联网请求, 并得到响应数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://api.m.mtime.cn/PageSubArea/TrailerList.api";
                try {
                    final String result = requestToString(path);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //3). 主线程, 显示数据
                            // 在分/主线程创建Message对象
                            Message message = Message.obtain();
                            message.what = 1;
                            message.obj = result;
                            //使用handler对象发送Message
                            handler.sendMessage(message);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /**
     * 请求服务器端, 得到返回的结果字符串
     *
     * @param path :http://api.m.mtime.cn/PageSubArea/TrailerList.api
     * @return
     * @throws Exception
     */
    private String requestToString(String path) throws Exception {
        //获取链接
        URL url = new URL(path);
        //连接对象
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        //连接时间和读取时间
        httpURLConnection.setConnectTimeout(6000);
        httpURLConnection.setReadTimeout(6000);
        //连接
        httpURLConnection.connect();
        //获取服务器的内容
        InputStream inputStream = httpURLConnection.getInputStream();
        //从服务器读取
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        //关流
        inputStream.close();
        byteArrayOutputStream.close();
        //将读取的数据转换为字符串
        String result = httpURLConnection.toString();
        //结束连接
        httpURLConnection.disconnect();
        //返回获取并转换为字符串的结果
        return result;
    }
}
