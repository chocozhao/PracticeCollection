package com.example.uitest.HandlerTest;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uitest.R;

public class HandlerDemoActivity extends Activity implements View.OnClickListener {

    private static final int WHAT_DECREASE = 1;
    private static final int WHAT_INCREASE = 2;
    private TextView tv_demo_number;
    private Button btn_demo_increase;
    private Button btn_demo_decrease;
    private Button btn_demo_pause;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //得到当前显示的数值
            int number = Integer.parseInt(tv_demo_number.getText().toString());
            switch (msg.what) {
                case  WHAT_DECREASE:
                    if(number == 20) {
                        Toast.makeText(HandlerDemoActivity.this, "已经是最大值", Toast.LENGTH_SHORT).show();
                        return;
                    }
                        number++;
                        tv_demo_number.setText(number+"");
                    break;
                case  WHAT_INCREASE:
                    if(number == 0) {
                        Toast.makeText(HandlerDemoActivity.this, "已经是最小值", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    number++;
                    tv_demo_number.setText(number+"");

                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handlerdemo);
        init();
    }

    private void init() {
        tv_demo_number = findViewById(R.id.tv_demo_number);
        btn_demo_increase = findViewById(R.id.btn_demo_increase);
        btn_demo_decrease = findViewById(R.id.btn_demo_decrease);
        btn_demo_pause = findViewById(R.id.btn_demo_pause);

        btn_demo_increase.setOnClickListener(this);
        btn_demo_decrease.setOnClickListener(this);
        btn_demo_pause.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btn_demo_decrease) {


            handler.sendEmptyMessage(WHAT_DECREASE);
        }else if(view == btn_demo_increase) {


            handler.sendEmptyMessage(WHAT_INCREASE);
        }else if(view == btn_demo_pause) {
            //限制Button的可操作性


        }

    }
}
