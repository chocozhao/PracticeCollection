package com.example.uitest.EventBusTest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uitest.R;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

public class EventBusActivity extends AppCompatActivity {

    private Button btn_EventBus;
    private TextView tv_EventBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        EventBus.getDefault().register(this);

        btn_EventBus = findViewById(R.id.btn_EventBus);
        tv_EventBus = findViewById(R.id.tv_EventBus);
        btn_EventBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent().setClass(getApplicationContext(), EventBusTestActivity.class);
                startActivity(intent);
            }
        });
    }

    @Subscribe
    public void get(MessageEvent messageEvent) {
        String str = "收到了"+messageEvent.getMsg();
        tv_EventBus.setText(str);
        Toast.makeText(EventBusActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
