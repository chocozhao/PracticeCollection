package com.example.contactstest;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by 赵泳霖 on 2017/10/20.
 */

public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0;//访问表1中的所有数据
    public static final int TABLE1_ITEM = 1;//访问表1中的所有数据
    public static final int TABLE2_DIR = 2;//访问表2中的所有数据
    public static final int TABLE2_ITEM = 3;//访问表2中的所有数据

    private static UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.app.provider", "table", TABLE1_DIR);
        uriMatcher.addURI("com.example.app.provider", "table1/#", TABLE1_ITEM);
        uriMatcher.addURI("com.example.app.provider", "table2", TABLE2_DIR);
        uriMatcher.addURI("com.example.app.provider", "table2/#", TABLE2_ITEM);
    }

    //初始化内容、数据库的创建和升级
    @Override
    public boolean onCreate() {
        return false;
    }

    /**
     * 查询
     *
     * @param uri
     * @param projection    确定查询哪些列
     * @param selection     确定查询哪些行
     * @param selectionArgs 确定查询哪些行
     * @param sortOrder     对结果进行排序
     * @return 查询结果放在Cursor对象中返回
     */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                //查询table1表中的所有数据
                break;
            case TABLE1_ITEM:
                //查询table1表中的单条数据
                break;
            case TABLE2_DIR:
                //查询table2表中的所有数据
                break;
            case TABLE2_ITEM:
                //查询table2表中的单条数据
                break;
        }


        return null;
    }

    //根据传入的URI返回响应的MIME类型
    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table2";
            default:
                break;
        }
        return null;
    }

    /**
     * 添加数据
     *
     * @param uri    uri参数确定添加到表中
     * @param values 待添加的数据保存到values参数中
     * @return 返回新记录的URI
     */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    /**
     * 删除数据
     *
     * @param uri           删除哪一张表的数据
     * @param selection     删除哪些行的数据
     * @param selectionArgs 删除哪些行的数据
     * @return
     */
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * 更新数据
     *
     * @param uri           更新哪一张表的数据
     * @param values        保存新的数据
     * @param selection     约束更新哪些行
     * @param selectionArgs 约束更新哪些行
     * @return
     */
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
