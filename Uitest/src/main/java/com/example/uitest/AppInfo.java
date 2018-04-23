package com.example.uitest;

import android.graphics.drawable.Drawable;

/**
 * Created by chocozhao on 2018/3/19.
 */

public class AppInfo {
    private String packageName;
    private Drawable icon;
    private String appName;

    public AppInfo(String packageName, Drawable icon, String appName) {
        this.packageName = packageName;
        this.icon = icon;
        this.appName = appName;
    }

    public AppInfo() {
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
