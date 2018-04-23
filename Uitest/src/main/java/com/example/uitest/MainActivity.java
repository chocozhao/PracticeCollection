package com.example.uitest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.uitest.BaiDuLocation.BDLocationActivity;
import com.example.uitest.DBTest.DBTestActivity;
import com.example.uitest.EventBusTest.EventBusActivity;
import com.example.uitest.HandlerTest.HandlerTestActivity;
import com.example.uitest.HenCoder.HenCoderActivity;
import com.example.uitest.Litepaltest.LitepalTestActivity;
import com.example.uitest.MVP.view.LoginActivity;
import com.example.uitest.Material_Design.MaterialTestActivity;
import com.example.uitest.NavigationBar.OneNavigationBar.ButtonNavigationBarActivity;
import com.example.uitest.NavigationBar.TwoNavigationBar.TwoNavigationBarActivity;
import com.example.uitest.Networktest.NetworkTestActivity;
import com.example.uitest.OkhttpUtils.OkhttpActivity;
import com.example.uitest.PlayAudiotest.PlayAudioActivity;
import com.example.uitest.RetrofitTest.GetRequest;
import com.example.uitest.RetrofitTest.PostRequest;
import com.example.uitest.RetrofitTest.RetrofitTestActivity;
import com.example.uitest.RxJavaTest.RxJavaChange;
import com.example.uitest.RxJavaTest.RxJavafixRxjava;
import com.example.uitest.RxJavaTest.RxjavaBeanActivity;
import com.example.uitest.Signin.SigninActivity;
import com.example.uitest.TablayoutAddViewPager.TabaddViewActivity;
import com.example.uitest.Notificationtest.NotificationTest;
import com.example.uitest.VolleyTest.VolleyActivity;
import com.example.uitest.playvideotest.PlayVideActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView listView;
    private List<ItemName> mainlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initItemName();//初始化数据
        MainAdapter mainAdapter = new MainAdapter(MainActivity.this, R.layout.itemname_item, mainlist);
        listView = findViewById(R.id.listView);
        listView.setAdapter(mainAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, demos[position].demoClass);
                startActivity(intent);
            }
        });
    }



    //把每个activity转成class
    private static class DemoInfo {
        private final Class<? extends android.app.Activity> demoClass;

        public DemoInfo(Class<? extends android.app.Activity> demoClass) {
            this.demoClass = demoClass;
        }


    }

    //把每个activity转成xxx.class
    private static final DemoInfo[] demos = {
            new DemoInfo(ComponentActivity.class),
            new DemoInfo(AlertDialogActivity.class),
            new DemoInfo(ListViewActivity.class),
            new DemoInfo(GridViewActivity.class),
            new DemoInfo(DBTestActivity.class),
            new DemoInfo(TestActivity.class),
            new DemoInfo(HandlerTestActivity.class),
            new DemoInfo(LoginActivity.class),
            new DemoInfo(BDLocationActivity.class),
            new DemoInfo(MaterialTestActivity.class),
            new DemoInfo(OkhttpActivity.class),
            new DemoInfo(ButtonNavigationBarActivity.class),
            new DemoInfo(TwoNavigationBarActivity.class),
            new DemoInfo(TabaddViewActivity.class),
            new DemoInfo(EventBusActivity.class),
            new DemoInfo(NotificationTest.class),
            new DemoInfo(NetworkTestActivity.class),
            new DemoInfo(LitepalTestActivity.class),
            new DemoInfo(SigninActivity.class),
            new DemoInfo(PlayAudioActivity.class),
            new DemoInfo(PlayVideActivity.class),
            new DemoInfo(GetRequest.class),
            new DemoInfo(PostRequest.class),
            new DemoInfo(RxjavaBeanActivity.class),
            new DemoInfo(RxJavafixRxjava.class),
            new DemoInfo(RxJavaChange.class),
            new DemoInfo(VolleyActivity.class),
            new DemoInfo(HenCoderActivity.class),
    };
    private void initItemName() {
        mainlist.add(new ItemName("ComponentActivity"));
        mainlist.add(new ItemName("AlertDialogActivity"));
        mainlist.add(new ItemName("ListViewActivity"));
        mainlist.add(new ItemName("GridViewActivity"));
        mainlist.add(new ItemName("DBTestActivity"));
        mainlist.add(new ItemName("TestActivity"));
        mainlist.add(new ItemName("HandleTestActivity"));
        mainlist.add(new ItemName("MVPTest"));
        mainlist.add(new ItemName("DBLocation"));
        mainlist.add(new ItemName("MaterialTestActivity"));
        mainlist.add(new ItemName("OkhttpActivity"));
        mainlist.add(new ItemName("ButtonNavigationBarActivity"));
        mainlist.add(new ItemName("TwoNavigationBarActivity"));
        mainlist.add(new ItemName("TabaddViewActivity"));
        mainlist.add(new ItemName("EventBusActivity"));
        mainlist.add(new ItemName("NotificationTest"));
        mainlist.add(new ItemName("NetworkTestActivity"));
        mainlist.add(new ItemName("LitepalTestActivity"));
        mainlist.add(new ItemName("SigninActivity"));
        mainlist.add(new ItemName("PlayAudioActivity"));
        mainlist.add(new ItemName("PlayVideActivity"));
        mainlist.add(new ItemName("RetrofitGetRequest"));
        mainlist.add(new ItemName("RetrofitPostRequest"));
        mainlist.add(new ItemName("RxjavaBeanActivity"));
        mainlist.add(new ItemName("RxJavafixRxjava"));
        mainlist.add(new ItemName("RxJavaChange"));
        mainlist.add(new ItemName("VolleyActivity"));
        mainlist.add(new ItemName("HenCoderActivity"));

    }

}
