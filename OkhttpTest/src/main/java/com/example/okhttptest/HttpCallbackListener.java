package com.example.okhttptest;

/**
 * Created by 赵泳霖 on 2017/11/13.
 */

public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
