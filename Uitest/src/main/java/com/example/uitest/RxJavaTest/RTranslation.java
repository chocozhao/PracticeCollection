package com.example.uitest.RxJavaTest;

import android.util.Log;

/**
 * Created by chocozhao on 2018/4/9.
 *
 * 接收服务器返回数据 的类
 */

public class RTranslation {
    private int status;//请求成功时则取1；
    private content content;//内容信息
    private static class content{
        private String from;//原文内容类型
        private String to;//译文内容类型
        private String vendor;//来源平台
        private String out;//译文内容
        private int err_no;//请求成功时取0
    }

    //定义 输出返回数据 的方法
    public void show() {
        Log.d("RxJava", content.out );
    }
}
