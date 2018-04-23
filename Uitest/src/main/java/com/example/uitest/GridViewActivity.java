package com.example.uitest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewActivity extends Activity {
    private GridView gv_GridView;
    private GridViewAdapter gridViewAdapter;
    String[] names = new String[] { "手机防盗", "通讯卫士", "软件管理", "流量管理", "进程管理",
            "手机杀毒", "缓存清理", "高级工具", "设置中心" };

    int[] icons = new int[] { R.drawable.widget01, R.drawable.widget02,
            R.drawable.widget03, R.drawable.widget04, R.drawable.widget05,
            R.drawable.widget06, R.drawable.widget07, R.drawable.widget08,
            R.drawable.widget09 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        gv_GridView = findViewById(R.id.gv_GridView);

        gridViewAdapter = new GridViewAdapter(this,names,icons);
        gv_GridView.setAdapter(gridViewAdapter);

        gv_GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //得到当前点击的名称
                String name = names[position];
                //提示
                Toast.makeText(GridViewActivity.this, name, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
