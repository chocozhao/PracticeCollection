package com.example.androidthreadtest;

import android.app.Service;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Date;

/**
 * Created by 赵泳霖 on 2017/11/28.
 */

public class MyService extends Service {


    private MyThread thread;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MyService", "销毁");
        thread.setStop();
    }

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

    public class MyThread extends Thread {
        private boolean stop = false;

        public void setStop() {
            stop = true;
        }


        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            super.run();
            while (!stop) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Log.e("MyService", dateFormat.format(new Date()));

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}

