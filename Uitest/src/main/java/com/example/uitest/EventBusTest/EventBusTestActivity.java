package com.example.uitest.EventBusTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.uitest.R;

import de.greenrobot.event.EventBus;

public class EventBusTestActivity extends AppCompatActivity {

    private Button btn_EventBusTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_test);

        btn_EventBusTest = findViewById(R.id.btn_EventBusTest);
        btn_EventBusTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("快递"));
            }
        });
    }
}
