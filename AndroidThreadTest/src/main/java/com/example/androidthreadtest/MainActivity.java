package com.example.androidthreadtest;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;
    private TwoMyService.ServiceBinder serviceBinder;
    public static final int UPDATE_TEXT = 1;
    private MyServiceConnection msc = new MyServiceConnection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        text = (TextView) findViewById(R.id.textView);
        Button changeText = (Button) findViewById(R.id.change_text);

        Button btn_start = (Button) findViewById(R.id.btn_start);
        Button btn_stop = (Button) findViewById(R.id.btn_stop);

        Button btn_bind = (Button) findViewById(R.id.btn_bind);
        Button btn_unbind = (Button) findViewById(R.id.btn_unbind);

        Button btn_change = (Button) findViewById(R.id.btn_change);

        changeText.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_stop.setOnClickListener(this);
        btn_bind.setOnClickListener(this);
        btn_unbind.setOnClickListener(this);
        btn_change.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                case R.id.change_text:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
//                        text.setText("Nice to meet you");
                            Message message = new Message();
                            message.what = UPDATE_TEXT;
                            handle.sendMessage(message);//将Message对象发送出去
                        }
                    }).start();
                    break;
            case R.id.btn_start:
                //开启服务
                Intent intent = new Intent(MainActivity.this, MyService.class);
                startService(intent);
                break;
            case R.id.btn_stop:
                //关闭服务
                Intent intent1 = new Intent(MainActivity.this, MyService.class);
                stopService(intent1);
                break;
            case R.id.btn_bind:
                //绑定服务
                Intent intent2 = new Intent(MainActivity.this, TwoMyService.class);
                bindService(intent2, msc, Context.BIND_AUTO_CREATE);

                break;
            case R.id.btn_unbind:
                //解绑服务
                Intent intent3 = new Intent(MainActivity.this, TwoMyService.class);
                unbindService(msc);
                break;
            case R.id.btn_change:
                //更改时间
                //获取已经启动的服务的代理对象
                serviceBinder.changFormatBinder("HH:mm:ss");

            default:
                break;
        }
    }

    private class MyServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //服务绑定成功的时候执行
            serviceBinder = (TwoMyService.ServiceBinder) service;

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //服务进程被杀死或崩溃的时候执行


        }
    }




    private Handler handle = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    //这里可以进行UI操作
                    text.setText("nice to meet you");
                    break;
                default:
                    break;
            }
        }
    };


}

