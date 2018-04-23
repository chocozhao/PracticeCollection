package com.example.androidthreadtest;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Date;

/**
 * Created by 赵泳霖 on 2017/11/28.
 */

public class TwoMyService extends Service {


    private MyThread thread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        thread.start();
        return new ServiceBinder();
    }

    //销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService", "销毁");
        thread.setStop();
    }

    //创建
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyService", "创建");
        thread = new MyThread();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        thread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 与服务进行通讯的方法：更改系统时间输出的格式
     *
     * @param format
     */

    public void changFormat(String format) {
        if (thread != null) {
            thread.setFormat(format);
        }
    }

    /**
     * 子线程类：每隔一秒钟输出系统的时间
     */
    public class MyThread extends Thread {
        private boolean stop = false;

        public void setStop() {
            stop = true;
        }

        private String format = "yyyy-MM-dd HH:mm:ss";

        private void setFormat(String format) {
            this.format = format;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            super.run();
            while (!stop) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(format);
                Log.e("MyService", dateFormat.format(new Date()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /**
     * 当前服务的代理类
     */
    public class ServiceBinder extends Binder {
        public void changFormatBinder(String format) {
            changFormat(format);
        }
    }
}



