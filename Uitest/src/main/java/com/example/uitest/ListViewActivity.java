package com.example.uitest;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity implements AdapterView.OnItemLongClickListener {

    private ListView listView;
    private List<AppInfo> data;
    private AppAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.lv_main);

        data = getAllAppInfos();
        adapter = new AppAdapter();

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String appName = data.get(i).getAppName();
                Toast.makeText(ListViewActivity.this, appName, Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(this );
    }
        /*
	 * 得到手机中所有应用信息的列表
	 * AppInfo
	 *  Drawable icon  图片对象
	 *  String appName
	 *  String packageName
	 */
        protected List<AppInfo> getAllAppInfos() {

            List<AppInfo> list = new ArrayList<AppInfo>();
            // 得到应用的packgeManager
            PackageManager packageManager = getPackageManager();
            // 创建一个主界面的intent
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            // 得到包含应用信息的列表
            List<ResolveInfo> ResolveInfos = packageManager.queryIntentActivities(
                    intent, 0);
            // 遍历
            for (ResolveInfo ri : ResolveInfos) {
                // 得到包名
                String packageName = ri.activityInfo.packageName;
                // 得到图标
                Drawable icon = ri.loadIcon(packageManager);
                // 得到应用名称
                String appName = ri.loadLabel(packageManager).toString();
                // 封装应用信息对象
                AppInfo appInfo = new AppInfo(packageName,icon, appName);
                // 添加到list
                list.add(appInfo);
            }
            return list;
        }


        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                                       int position, long id) {
            //删除当前行
            //删除当前行的数据
            data.remove(position);
            //更新列表
            //lv_main.setAdapter(adapter);//显示列表, 不会使用缓存的item的视图对象
            adapter.notifyDataSetChanged();//通知更新列表, 使用所有缓存的item的视图对象

            return true;
        }


    class AppAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
//            AppInfo appInfo = (AppInfo) getItem(i);
//            View view;
//           ViewHelper viewHelper;
//            if (convertView == null) {
//                view = View.inflate(ListViewActivity.this, R.layout.activity_list_view, null);
//
//                viewHelper = new ViewHelper();
//                viewHelper.iv_item_icon = view.findViewById(R.id.iv_item_icon);
//                viewHelper.tv_item_name = view.findViewById(R.id.tv_item_name);
//
//                view.setTag(viewHelper);
//            } else {
//                view = convertView;
//                viewHelper = (ViewHelper) view.getTag();
//            }
//
//            viewHelper.tv_item_name.setText(appInfo.getAppName());
//            viewHelper.iv_item_icon.setImageDrawable(appInfo.getIcon());
//            return view;
//        }
//
//        class ViewHelper {
//            TextView tv_item_name;
//            ImageView iv_item_icon;
//        }
            //1. 如果convertView是null, 加载item的布局文件
            if (convertView == null) {
                Log.e("TAG", "getView() load layout");
                convertView = View.inflate(ListViewActivity.this, R.layout.activity_item_listview, null);
            }
            //2. 得到当前行数据对象
            AppInfo appInfo = data.get(position);
            //3. 得到当前行需要更新的子View对象
            ImageView imageView = (ImageView) convertView.findViewById(R.id.iv_item_icon);
            TextView textView = (TextView) convertView.findViewById(R.id.tv_item_name);
            //4. 给视图设置数据
            imageView.setImageDrawable(appInfo.getIcon());
            textView.setText(appInfo.getAppName());

            //返回convertView
            return convertView;
        }
    }
}
