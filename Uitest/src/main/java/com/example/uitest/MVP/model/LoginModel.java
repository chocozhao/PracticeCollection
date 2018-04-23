package com.example.uitest.MVP.model;

import android.os.Handler;

import com.example.uitest.MVP.Bean.User;
import com.example.uitest.MVP.presenter.ILoginPresenter;



/**
 * Created by chocozhao on 2018/3/22.
 */

public class LoginModel implements ILoginMedel{
    private ILoginPresenter mLoginPresenter;
    private Handler mhandler = new Handler();
    public LoginModel(ILoginPresenter loginPresenter) {
        mLoginPresenter = loginPresenter;
    }


    @Override
    public void login(final String username, final String password) {
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if ("chocozhao".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    mLoginPresenter.loginSuccess();
                } else {
                    mLoginPresenter.loginFailed();
                }
            }
        }, 3000);
    }
}
