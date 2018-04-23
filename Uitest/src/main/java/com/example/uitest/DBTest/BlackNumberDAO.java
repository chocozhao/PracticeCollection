package com.example.uitest.DBTest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * BlackNumberDAO操作类
 * Created by chocozhao on 2018/3/20.
 */

public class BlackNumberDAO {

    private DBHelper dbHelper;

    public BlackNumberDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    /**
     * 添加一条数据
     */
    public void add(BlackNumber blackNumber) {
        //连接数据库
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        //执行insert insert into black_number (number) values(xxx)
        ContentValues values = new ContentValues();
        values.put("number", blackNumber.getNumber());
        long id = sqLiteDatabase.insert("black_number", null, values);
        //设置Id
        blackNumber.setId((int) id);
        //关闭
        sqLiteDatabase.close();
    }

    /**
     * 删除一条数据
     */
    public void deleteById(int id) {
        //1. 得到连接
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        //2. 执行delete delete from black_number where _id=id
        int deleteCount = sqLiteDatabase.delete("black_number", "_id=?", new String[]{""});
        //3. 关闭
        sqLiteDatabase.close();
    }

    /**
     * 更新一条数据
     */
    public void update(BlackNumber blackNumber) {
        //1. 得到连接
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        //2. 执行update update black_number set number=xxx where _id=id
        ContentValues values = new ContentValues();
        values.put("number", blackNumber.getNumber());
        int updateCount = sqLiteDatabase.update("black_number", values, "_id=" + blackNumber.getId(), null);
        //3. 关闭
        sqLiteDatabase.close();
    }

    /**
     * 查询所有记录封装成List<BLackNumber>
     */
    public List<BlackNumber> getAll() {

        List<BlackNumber> list = new ArrayList<>();
        //1. 得到连接
        SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        //2. 执行query select * from black_number
        Cursor cursor = sqLiteDatabase.query("black_number", null, null, null, null, null, "_id desc");
        //3. 从cursor中取出所有数据并封装到List中
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String number = cursor.getString(1);
            list.add(new BlackNumber(id, number));
        }
        //4. 关闭
        cursor.close();
        sqLiteDatabase.close();
        return list;
    }
}
