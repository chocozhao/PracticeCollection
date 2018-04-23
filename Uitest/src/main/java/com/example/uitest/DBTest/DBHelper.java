package com.example.uitest.DBTest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 数据库帮助类
 * Created by chocozhao on 2018/3/20.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "MyDB.db", null, 1);
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("TAG", "DBHelper onCreate()");
        sqLiteDatabase.execSQL("create table black_number(_id integer primary key autoincrement, number varchar)");

    }

    //更新数据库
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
