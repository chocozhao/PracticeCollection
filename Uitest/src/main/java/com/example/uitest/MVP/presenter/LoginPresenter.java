package com.example.uitest.MVP.presenter;

import android.text.TextUtils;

import com.example.uitest.MVP.model.ILoginMedel;
import com.example.uitest.MVP.view.ILoginView;

/**
 * Created by chocozhao on 2018/3/22.
 */

public class LoginPresenter implements ILoginPresenter{

    private ILoginView mLoginView;
    private ILoginMedel mLoginMedel;
    public LoginPresenter(ILoginView iLoginView){
        mLoginView = iLoginView;
//        this.mLoginMedel = new LoginMedel();
    }



    @Override
    public void loginToServer() {
        String username = mLoginView.getUserName();
        String password = mLoginView.getPassword();
        if(!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            mLoginView.showLoading(true);
            mLoginMedel.login(username, password);
        }
    }

    @Override
    public void loginSuccess() {
            mLoginView.showLoading(false);
            mLoginView.showLoginSuccessView();
    }

    @Override
    public void loginFailed() {
            mLoginView.showLoading(false);
            mLoginView.showLoginFailedView();
    }
}
