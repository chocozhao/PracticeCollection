package com.example.uitest.VolleyTest;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * @author chocozhao
 * @version version 1.0.0
 * @date 2018/4/13 20:57.
 * @email zhao1027313530@gmail.com
 * @instructions 说明  olley 进行网络请求的封装类
 * @features 功能 Get请求  post请求  ImageRequest封装  ImageLoader的封装
 * @descirbe 描述
 */
public class VolleyHelper {

    /**
     * 用于发送get请求的封装方法
     *
     * @param context  activity实例
     * @param url      请求地址
     * @param callback 网络回调接口
     */
    public static void sendHttpGet(Context context,
                                   String url,
                                   final VolleyResponseCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                callback.onSuccess(s);
            }
        }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.onError(volleyError);
            }
        });
        requestQueue.add(stringRequest);
    }


    /**
     * 用于网络请求POST
     *
     * @param context       activity实例
     * @param url           请求地址
     * @param listener      监听
     * @param errorListener 错误监听
     * @param map           POST请求内容
     * @param callback      网络回调接口
     */
    public static void sendHttpPost(Context context,
                                    String url,
                                    Response.Listener listener,
                                    Response.ErrorListener errorListener,
                                    final Map<String, String> map,
                                    final VolleyResponseCallback callback) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, listener, errorListener) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };

        requestQueue.add(stringRequest);
    }

    /**
     * 用于网络请求图片
     *
     * @param context  activity实例
     * @param url      请求地址
     * @param callback 网络回调接口
     */
    public static void sendHttpImageRequest(Context context,
                                            String url,
                                            final VolleyResponseCallback callback) {

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                callback.onResponse(bitmap);
            }
        }
                , 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                callback.onErrorResponse(volleyError);
            }
        });
        requestQueue.add(imageRequest);
    }



    public static  void sendHttpImageLoader(Context context,
                                            String url,
                                            final VolleyResponseCallback callback){
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {

                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });


    }
}
