package com.example.uitest.Litepaltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.uitest.R;


import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class LitepalTestActivity extends AppCompatActivity {
    private Button createDatabase;
    private Button addData;
    private Button updataData;
    private Button deleteData;
    private Button queryData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_litepaltest);

        createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();//创建数据库
            }
        });
        //添加数据库
        addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("me");
                book.setAuthor("you");
                book.setPages(280);
                book.setPress("Unknow");
                book.setPrice(24.23);
                book.save();

            }
        });
        //更新数据
        updataData = (Button) findViewById(R.id.update_data);
        updataData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(25.88);
                book.setPress("my");
                book.updateAll("name = ? and author = ?", "me", "you");
            }
        });
        //删除数据
        deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class, "price = ? and pages = ?", "25.23","250");
            }
        });
        //查询数据
        queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*List<Book> books = DataSupport.findAll(Book.class);
                for (Book book : books) {
                    Log.d("LitepalTestActivity", "book name is " +book.getName());
                    Log.d("LitepalTestActivity", "book author is " +book.getAuthor());
                    Log.d("LitepalTestActivity", "book pages is " +book.getPages());
                    Log.d("LitepalTestActivity", "book price is " +book.getPrice());
                    Log.d("LitepalTestActivity", "book press is " +book.getPress());
                }
                Book one = DataSupport.find(Book.class, 19);
                Log.d("LitepalTestActivity", "book ID is " +one.getPrice());
                Book firstbook = DataSupport.findFirst(Book.class);
                Log.d("LitepalTestActivity", "book firstbook is " +firstbook.getPages());
                Book lastbook = DataSupport.findLast(Book.class);
                Log.d("LitepalTestActivity", "book lastbook is " +lastbook.getPrice());*/
                List<Book> books1 = DataSupport.select("name", "author", "pages")
                        .where("pages > ?", "250")
                        .order("pages desc")
                        .limit(4)
                        .offset(1).find(Book.class);
                    Log.d("LitepalTestActivity", "book bookss is " +books1);






               // List<Book> books1 = DataSupport.select("name", "author").find(Book.class);
               // Log.d("LitepalTestActivity", "Book name is " + books1.getClass());
                /*List<Book> books = DataSupport.where("pages > ?", "250").find(Book.class);
                Log.d("MainAtivity", "Book is "+books);*/
            }
        });
    }
}
