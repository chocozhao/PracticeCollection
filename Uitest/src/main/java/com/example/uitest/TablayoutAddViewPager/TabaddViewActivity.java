package com.example.uitest.TablayoutAddViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.uitest.R;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class TabaddViewActivity extends AppCompatActivity {
   private CommonTabLayout mTabLayout;
    private List<Fragment> mFragments;
    private ViewPager mViewPager;
    private LayoutInflater inflater;
    private List<View> viewList = new ArrayList<>();
    //Tab 文字
    private final String[] TAB_TITLES = new String[]{"日记","段子","妹子"};
    //Tab 图片
    private final int[] TAB_SELECTED_IMGS = new int[]{R.drawable.diary_selected,R.drawable.duanzi_selected,R.drawable.meizi_selected};
    private final int[] TAB_UNSELECTED_IMGS = new int[]{R.drawable.diary_unselected,R.drawable.duanzi_unselected,R.drawable.meizi_unselected};
    //Fragment数组
//    private final Fragment[] TAB_FRAGMENTS = new Fragment[]{new DiaryFragment(),new DuanziFragment(),new MeiziFragment()};


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, TabaddViewActivity.class);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabadd_view);
//        EventBus.getDefault().register(this);
//        initViews();
        initView();
        initTabLayout();
        initViewPager();

    }

    private void initView() {
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.mTabLayout);
    }

    //底部栏
    private void initTabLayout() {
        ArrayList<CustomTabEntity> tabEntities = new ArrayList<>();
        for (int i = 0; i < TAB_TITLES.length; i++) {
            tabEntities.add(new BaseFragment(TAB_TITLES[i], TAB_SELECTED_IMGS[i], TAB_UNSELECTED_IMGS[i]));
        }

        mTabLayout.setTabData(tabEntities);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mViewPager.setOffscreenPageLimit(4);//方法用于设置ViewPager的后台加载页面个数。
        mViewPager.setCurrentItem(1,false );//设置当前选择的页面。
    }

    //fragment显示
    private void initViewPager() {
        mFragments = new ArrayList<>();
        mFragments.add(DiaryFragment.newInstance());
        mFragments.add(DuanziFragment.newInstance());
        mFragments.add(MeiziFragment.newInstance());
        MyFragmentAdapter adapter = new MyFragmentAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(adapter);


//        inflater = LayoutInflater.from(this);
//        View view1 = inflater.inflate(R.layout.nav_hearer, null);
//        View view2 = inflater.inflate(R.layout.activity_material_test, null);
//        View view3 = inflater.inflate(R.layout.layout_tab, null);
//
//        viewList.add(view1);
//        viewList.add(view2);
//        viewList.add(view3);
//
//        MyFragmentAdapter adapter = new MyFragmentAdapter(viewList);
//        mViewPager.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // TODO: 在主页面按返回键时弹出对话框，提示用户是否退出程序
    }

//    private void initViews() {
//        mTabLayout = findViewById(R.id.tablayoout);
//        setTabs(mTabLayout, this.getLayoutInflater(), TAB_TITLES, TAB_IMGS);
//
//        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
//        mViewPager = findViewById(R.id.viewPager);
//        mViewPager.setAdapter(myViewPagerAdapter);
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
//    }

//    private void setTabs(TabLayout mTabLayout, LayoutInflater layoutInflater, int[] tab_titles, int[] tab_imgs) {
//        for (int i = 0; i < tab_imgs.length; i++) {
//            TabLayout.Tab tabLayout = mTabLayout.newTab();
//            View view = layoutInflater.inflate(R.layout.activity_tab_custom, null);
//            tabLayout.setCustomView(view);
//
//            TextView tv_title = view.findViewById(R.id.tv_title);
//            tv_title.setText(tab_titles[i]);
//            ImageView imgTab = view.findViewById(R.id.imager_tab);
//            imgTab.setImageResource(tab_imgs[i]);
//
//            mTabLayout.addTab(tabLayout);
//        }
//    }

//    /**
//     * @description: ViewPager 适配器
//     */
//    private class MyViewPagerAdapter extends FragmentPagerAdapter {
//
//        public MyViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public android.support.v4.app.Fragment getItem(int position) {
//            return TAB_FRAGMENTS[position];
//        }
//
//        @Override
//        public int getCount() {
//            return TAB_TITLES.length;
//        }
//    }
}
