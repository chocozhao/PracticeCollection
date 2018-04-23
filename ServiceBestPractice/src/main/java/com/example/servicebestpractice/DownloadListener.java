package com.example.servicebestpractice;

/**
 * Created by 赵泳霖 on 2017/11/28.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
