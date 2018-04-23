package com.example.uitest.TablayoutAddViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by chocozhao on 2018/4/2.
 */

public class MyFragmentAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mFragments;
//    private List<View> viewList;

        public MyFragmentAdapter(FragmentManager fragmentManager, List<Fragment> mFragments) {
        super(fragmentManager);
        this.mFragments = mFragments;
    }
//    public MyFragmentAdapter(List<View> viewList) {
//        this.viewList  = viewList;
//    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

//    @Override
//    public boolean isViewFromObject(View view, Object object) {
//        return view == object;
//    }

//    //销毁一个页卡(即ViewPager的一个item)
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(viewList.get(position));
//    }

//     //对应页卡添加上数据
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//
//        container.addView(viewList.get(position));//千万别忘记添加到container
//       return viewList.get(position);
//     }
}
