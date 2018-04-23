package com.example.datastorage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SpActivity extends Activity {
    private EditText edit_id;
    private EditText edit_pwd;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        init();
    }

    public void init() {
        edit_id = (EditText) findViewById(R.id.edit_id);
        edit_pwd = (EditText)findViewById(R.id.edit_pwd);
        //得到sp对象
        sharedPreferences = getSharedPreferences("mySp", Context.MODE_PRIVATE);
    }


    public void save(View v) {
        //得到Editor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //得到key和 value
        String key = edit_id.getText().toString();
        String value = edit_pwd.getText().toString();

        editor.putString(key, value).commit();

        Toast.makeText(SpActivity.this, "保存成功", Toast.LENGTH_SHORT).show();

    }

    public void read(View v) {
        String key = edit_id.getText().toString();
        String value = sharedPreferences.getString(key, null);

        if (value == null) {
            Toast.makeText(SpActivity.this, "密码为null", Toast.LENGTH_SHORT).show();
        } else {
            edit_pwd.setText(value);
        }
    }

}