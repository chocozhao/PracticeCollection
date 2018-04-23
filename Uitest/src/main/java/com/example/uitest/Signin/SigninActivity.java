package com.example.uitest.Signin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.uitest.R;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Button btn_register = (Button) findViewById(R.id.btn_register);
        ImageButton btn_back = (ImageButton) findViewById(R.id.but_back);
        //返回按钮变灰色
        btn_back.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageButton upStepBtn = (ImageButton) v;//v是事件源对象
                if (event.getAction() == MotionEvent.ACTION_DOWN) {//按钮被按下——————利用event触发
                    upStepBtn.setBackgroundResource(R.drawable.iv_back_selected);
                    finish();
                }
                return false;
            }
        });
        //注册按钮变橙色
        btn_register.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Button upStepBtn = (Button) v;
                if (event.getAction() == MotionEvent.ACTION_DOWN) {//按钮被按下
                    upStepBtn.setBackgroundResource(R.drawable.register_icon_normal);
                    finish();
                }
                return false;
            }
        });
    }
}
