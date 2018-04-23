package com.example.okhttptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String address = "https://www.baidu.com/";
//                String response = HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
//                    @Override
//                    public void onFinish(String response) {
//                        //这里根据返回内容执行具体的逻辑
//                        String responseData = response.t
//                    }
//
//                    @Override
//                    public void onError(Exception e) {
//                        //这里对异常情况进行处理
//
//                    }
//                });
            }
        });
    }
}
