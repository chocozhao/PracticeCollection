package com.example.uitest.RxJavaTest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.uitest.R;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chocozhao on 2018/4/10.
 * Rxjava结合Retrofit实现轮询
 *
 *
 *   1、添加依赖
     2、创建 接收服务器返回数据 的类
     3、创建 用于描述网络请求 的接口（区别于传统Retrofit形式）
     4、创建 Retrofit 实例
     5、创建 网络请求接口实例 并 配置网络请求参数（区别于传统Retrofit形式）
     6、发送网络请求（区别于传统Retrofit形式）
     7、发送网络请求
     8、对返回的数据进行处理
 */

public class RxJavafixRxjava extends AppCompatActivity {

    private static final String TAG = "Rxjava";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_bean);

//        步骤1：采用interval（）延迟发送
        Observable.interval(2, 1, TimeUnit.SECONDS)
                //步骤2：每次发送数字前发送1次网络请求（doOnNext（）在执行Next事件前调用）即每隔1秒产生1个数字前，就发送1次网络请求，从而实现轮询需求
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Log.d(TAG, "第"+aLong+"次轮询");

                    //步骤3:通过Retrofit发送网络请求
                        // a. 创建Retrofit对象
                        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl("http://fy.iciba.com/")//设置 网络请求 Url
                                .addConverterFactory(GsonConverterFactory.create())//设置使用Gson解析(记得加入依赖)
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava(记得加入依赖)
                                .build();

                        //b.创建 网络请求接口 的实例
                        RGetRequest_Interface rGetRequest_interface = retrofit.create(RGetRequest_Interface.class);

                        // c. 采用Observable<...>形式 对 网络请求 进行封装
                        Observable<RTranslation> observable = rGetRequest_interface.getCall();

                        // d. 通过线程切换发送网络请求
                        observable.subscribeOn(Schedulers.io())//切换到IO线程进行网络请求
                                .observeOn(AndroidSchedulers.mainThread())//切换到主线程处理请求结果
                                .subscribe(new Observer<RTranslation>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(RTranslation value) {
                                            value.show();//e.接受服务器返回的数据
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        Log.d(TAG, "请求失败");
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                });
                    }
                }).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long value) {

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }
}
