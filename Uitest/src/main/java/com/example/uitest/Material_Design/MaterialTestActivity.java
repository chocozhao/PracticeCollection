package com.example.uitest.Material_Design;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.uitest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MaterialTestActivity extends AppCompatActivity {

    private Toolbar toolsbar;
    private DrawerLayout mDrawerLayout;
    private NavigationView navigationView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Handler mHandler = new Handler();
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter adapter;
    private Fruit[] fruits = {new Fruit("这是辣妹", R.drawable.ic_lamei),
            new Fruit("紫薇", R.drawable.ic_lamei_two),
            new Fruit("啪啪", R.drawable.ic_lamei_three),
            new Fruit("嘿嘿", R.drawable.ic_lamei_four),
            new Fruit("嘿嘿", R.drawable.nav_header)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_material_test);

        initFruits();//初始化数据
        toolsbar = findViewById(R.id.toolsbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);//布局方式
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.floating);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "数据显示", Snackbar.LENGTH_SHORT).setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MaterialTestActivity.this, "数据撤回", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });
        setSupportActionBar(toolsbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);//导航按钮显示
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);//设置导航按钮
        }

        navigationView.setCheckedItem(R.id.nav_call);//默认选中
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();//关闭滑动菜单
                return true;
            }
        });
    }

    private void refreshFruits() {

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                initFruits();
                adapter.notifyDataSetChanged();//刷新界面
                swipeRefreshLayout.setRefreshing(false);//隐藏刷新进度条
            }
        }, 2000);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        initFruits();
//                adapter.notifyDataSetChanged();//刷新界面
//                swipeRefreshLayout.setRefreshing(false);//隐藏刷新进度条
//                    }
//                });
//            }
//        }).start();
    }

    private void initFruits() {
        fruitList.clear();
        for (int i = 1; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(MaterialTestActivity.this, "Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(MaterialTestActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(MaterialTestActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);//导入点击事件
                break;
            default:
                break;
        }
        return true;
    }
}
