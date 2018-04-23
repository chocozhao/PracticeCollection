package com.example.uitest.NavigationBar.TwoNavigationBar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.uitest.NavigationBar.OneNavigationBar.DiaryFragment;
import com.example.uitest.NavigationBar.OneNavigationBar.DuanziFragment;
import com.example.uitest.NavigationBar.OneNavigationBar.MeiziFragment;
import com.example.uitest.R;

import java.util.ArrayList;

public class TwoNavigationBarActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private DiaryFragment mDiaryFragment;
    private DuanziFragment mDuanziFragment;
    private MeiziFragment mMeiziFragment;

    private ArrayList<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_navigation_bar);


        initView();
    }

    private void initView() {
        BottomNavigationBar bottomNavigationBar =  findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.diary_selected, "日记").setActiveColor(R.color.colorgreen))
                .addItem(new BottomNavigationItem(R.drawable.duanzi_selected, "段子").setActiveColor(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.meizi_selected, "妹子").setActiveColor(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.diary_unselected, "我的").setActiveColor(R.color.colorpurple))
                .setFirstSelectedPosition(0)
                .setMode(BottomNavigationBar.MODE_SHIFTING)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .initialise();

        fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    //设置默认fragment
    private void setDefaultFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        mDiaryFragment = DiaryFragment.newInstance("日记");
        transaction.replace(R.id.tb, mDiaryFragment);
        transaction.commit();
    }




    private ArrayList<Fragment> getFragments() {
        fragments = new ArrayList<>();
        fragments.add(DiaryFragment.newInstance("Home"));
        fragments.add(DuanziFragment.newInstance("Books"));
        fragments.add(MeiziFragment.newInstance("Music"));
        fragments.add(MeiziFragment.newInstance("Music"));
        return fragments;
    }

    @Override
    public void onTabSelected(int position) {

//        FragmentManager fm = this.getFragmentManager();
//        //开启事务
//        FragmentTransaction transaction = fm.beginTransaction();
////        hideFragment(transaction);
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
//            case 3:
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
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                if (fragment.isAdded()) {
                    ft.replace(R.id.tb, fragment);
                } else {
                    ft.add(R.id.tb, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

//    //隐藏当前fragment
//    private void hideFragment(FragmentTransaction transaction) {
//        if (mDiaryFragment != null){
//            transaction.hide(mDiaryFragment);
//        }
//        if (mDuanziFragment != null){
//            transaction.hide(mDuanziFragment);
//        }
//        if (mMeiziFragment != null){
//            transaction.hide(mMeiziFragment);
//        }
//        if (mMeiziFragment != null){
//            transaction.hide(mMeiziFragment);
//        }
//    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }


}
