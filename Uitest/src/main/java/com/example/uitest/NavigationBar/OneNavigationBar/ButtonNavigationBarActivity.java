package com.example.uitest.NavigationBar.OneNavigationBar;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.uitest.R;

public class ButtonNavigationBarActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private DiaryFragment mDiaryFragment;
    private DuanziFragment mDuanziFragment;
    private MeiziFragment mMeiziFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_navigation_bar);

        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.diary_selected,"日记").setActiveColor(R.color.colorgreen))
                .addItem(new BottomNavigationItem(R.drawable.duanzi_selected, "段子").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.meizi_selected, "妹子").setActiveColor(R.color.colorAccent))
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .initialise();

        bottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        mDiaryFragment = DiaryFragment.newInstance("日记");
//        transaction.replace(R.id.tb, mDiaryFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
//        FragmentManager fm = this.getFragmentManager();
//        //开启事务
//        FragmentTransaction transaction = fm.beginTransaction();
//        switch (position) {
//            case 0:
//                if (mDiaryFragment == null) {
//                    mDiaryFragment = DiaryFragment.newInstance("位置");
//                }
//                transaction.replace(R.id.tb, mDiaryFragment);
//                break;
//            case 1:
//                if (mDuanziFragment == null) {
//                    mDuanziFragment = DuanziFragment.newInstance("发现");
//                }
//                transaction.replace(R.id.tb, mDuanziFragment);
//                break;
//            case 2:
//                if (mMeiziFragment == null) {
//                    mMeiziFragment = MeiziFragment.newInstance("爱好");
//                }
//                transaction.replace(R.id.tb, mMeiziFragment);
//                break;
//            default:
//                break;
//
//        }
//        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }


    @Override
    public void onTabReselected(int position) {

    }
}
