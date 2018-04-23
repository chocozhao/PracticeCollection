package com.example.uitest.MVP.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.uitest.MVP.LoginSuccessActivity;
import com.example.uitest.MVP.presenter.LoginPresenter;
import com.example.uitest.R;

/**
 * Created by chocozhao on 2018/3/30.
 */

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {


    private EditText id_et_username;
    private EditText id_et_password;
    private Button id_btn_login;
    private Button id_btn_clear;
   private ProgressBar id_pb_loading;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        id_et_username = findViewById(R.id.id_et_username);
        id_et_password = findViewById(R.id.id_et_password);
        id_btn_login = findViewById(R.id.id_btn_login);
        id_btn_clear = findViewById(R.id.id_btn_clear);
        id_pb_loading = findViewById(R.id.id_pb_loading);
        mLoginPresenter = new LoginPresenter(this);

        initView();

    }

    private void initView() {
        id_btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.loginToServer();
            }
        });
        id_btn_clear.setOnClickListener(this);
        id_et_username.setOnClickListener(this);
        id_et_password.setOnClickListener(this);
    }

    @Override
    public String getUserName() {
        String userName = id_et_username.getText().toString();
        if(!TextUtils.isEmpty(userName)) {
            return userName;
        }
        return null;
    }

    @Override
    public String getPassword() {
        String userPassword = id_et_password.getText().toString();
        if(!TextUtils.isEmpty(userPassword)) {
            return userPassword;
        }
        return null;
    }

    @Override
    public void showLoading(boolean isShow) {
        if (isShow) {
            id_pb_loading.setVisibility(View.VISIBLE);
        } else {
            id_pb_loading.setVisibility(View.GONE);
        }
    }

    @Override
    public void showLoginSuccessView() {
        Intent intent = new Intent(this, LoginSuccessActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoginFailedView() {
        Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {

    }
}
