package com.example.uitest.RetrofitTest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.uitest.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chocozhao on 2018/4/9.
 */

public class GetRequest extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_test);
        request();

    }

    private void request() {
        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fy.iciba.com/")
                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析
                .build();
        //创建网络请求接口的实例
        GetRequest_Interface getRequest_interface = retrofit.create(GetRequest_Interface.class);
        //对发送请求进行封装
        Call<Translation> call = getRequest_interface.getCall();
        /**
         * 发送网络请求(异步)
         *       请求成功时回调
         *          处理返回的数据结果
         *       请求失败时回调
         */
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                response.body().show();
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                System.out.println("连接失败");
            }
        });

    }
}
