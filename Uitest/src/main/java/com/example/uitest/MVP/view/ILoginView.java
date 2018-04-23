package com.example.uitest.MVP.view;

/**
 * Created by chocozhao on 2018/3/22.
 */

public interface ILoginView {

    String getUserName();

    String getPassword();

    void showLoading(boolean isShow);

    void showLoginSuccessView();

    void showLoginFailedView();
}
