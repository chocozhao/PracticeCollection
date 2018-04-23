package com.example.sharepreferencestest;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.save_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //利用sharepreferences存储数据：put
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data",
                        MODE_PRIVATE).edit();//指定文件名data并得到editor对象
                editor.putString("name", "Tom");
                editor.putInt("age", 28);
                editor.putBoolean("married", false);
                editor.apply();//提交
            }
        });
        button2 = (Button) findViewById(R.id.restor_data);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            //利用sharepreferences读取数据：get
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
                String name = preferences.getString("name", "");
                int age = preferences.getInt("age", 0);
                boolean married = preferences.getBoolean("married", false);
                Log.d("MainAcivity", "name is " + name);
                Log.d("MainAcivity", "age is " + age);
                Log.d("MainAcivity", "married is " + married);
            }
        });
    }
}