package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import firstcode.BroadcastTest.LocalBroadcast;
import json.activity.NativeJsonPraseActivity;
import recyclerview.RecyclerViewActivity;

public class MainActivity extends Activity {
    private Button btn;
    private Button textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        btn = (Button) findViewById(R.id.btn);
        textView = (Button) findViewById(R.id.text_view);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
//                startActivity(intent);
//            }
//        });

    }


}
