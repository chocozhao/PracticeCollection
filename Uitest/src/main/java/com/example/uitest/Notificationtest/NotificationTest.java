package com.example.uitest.Notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.example.uitest.R;

import java.io.File;

public class NotificationTest extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationtest);

        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_notice:
                Intent intent = new Intent(NotificationTest.this, NotificationActivity.class);//立刻执行某个动作
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationTest.this, 0, intent, 0);//适合的时机执行某个动作
            NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = new NotificationCompat.Builder(this)
                        //.setContentTitle("这是标题")//通知标题
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("，这是显示全部内容的文本框。，这是显示全部内容的文本框。，这是显示全部内容的文本框。" +
                                "，这是显示全部内容的文本框。，这是显示全部内容的文本框。，这是显示全部内容的文本框。" +
                                "，这是显示全部内容的文本框。，这是显示全部内容的文本框。"))//显示全部内容
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.big_img)))//显示图片
                        .setPriority(NotificationCompat.PRIORITY_MAX)//信息置顶————PRIORITY_DEFAULT(默认程度),PRIORITY_MIN(最低程度),PRIORITY_HIGH(较高程度),PRIORITY_MAX(最高程度)
                        .setContentText("这是内容文本")//通知内容
                        .setWhen(System.currentTimeMillis())//通知创建的时间，以毫秒计算
                        .setSmallIcon(R.mipmap.ic_launcher)//小图标
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.big_img))//大图标
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)//点击后自动消失
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))//音频
                        .setVibrate(new long[]{0,1000,1000,1000})//震动————震动1秒，静止1秒，震动1秒
                        .setLights(Color.GREEN,1000,1000)//灯光闪烁————闪1秒，静止1秒
                        .setDefaults(NotificationCompat.DEFAULT_ALL)//默认效果
                        .build();
                manager.notify(1,notification);
                break;
            default:
                break;
        }
    }
}
