package com.example.uitest.VolleyTest;

import android.graphics.Bitmap;

import com.android.volley.VolleyError;

/**
 * 网络请求的回调
 * Created by chocozhao on 2018/4/13.
 */

public interface VolleyResponseCallback {
    void onSuccess(String response);

    void onError(VolleyError error);

    void onResponse(Bitmap response);

    void onErrorResponse(VolleyError error);

//    void onMap(Map<String, String> map);


}
