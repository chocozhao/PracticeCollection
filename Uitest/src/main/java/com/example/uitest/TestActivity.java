package com.example.uitest;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestActivity extends Activity {

    private EditText et_network_url;
    private EditText et_network_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        et_network_url = (EditText) findViewById(R.id.et_network_url);
        et_network_result = (EditText) findViewById(R.id.et_network_result);

    }

    public void testConnectionGet(View v) {
        //1. 显示ProgressDialog
        final ProgressDialog dialog = ProgressDialog.show(this, null, "正在请求中...");
        //2. 启动分线程
        new Thread(){
            //3. 在分线程, 发送请求, 得到响应数据
            @Override
            public void run() {
                try {
                    //1). 得到path, 并带上参数name=Tom1&age=11
                    String path = et_network_url.getText().toString()+"?name=Tom1&age=11";
                    //2). 创建URL对象
                    URL url = new URL(path);
                    //3). 打开连接, 得到HttpURLConnection对象
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //4). 设置请求方式,连接超时, 读取数据超时
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(6000);
                    //5). 连接服务器
                    connection.connect();
                    //6). 发请求, 得到响应数据
                    //得到响应码, 必须是200才读取
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200) {
                        //得到InputStream, 并读取成String
                        InputStream is = connection.getInputStream();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int len = -1;
                        while((len=is.read(buffer))!=-1) {
                            baos.write(buffer, 0, len);
                        }
                        final String result = baos.toString();

                        baos.close();
                        is.close();

                        //4. 在主线程, 显示得到的结果, 移除dialog
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                et_network_result.setText(result);
                                dialog.dismiss();
                            }
                        });
                    }
                    //7). 断开连接
                    connection.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                    //如果出了异常要移除dialog
                    dialog.dismiss();
                }
            }
        }.start();
    }

}
