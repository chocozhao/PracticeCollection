package com.example.uitest.TablayoutAddViewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

/**
 * Created by chocozhao on 2018/4/3.
 */

public class SuperViewPager extends ViewPager {


    private ViewPageHelper helper;

    public SuperViewPager(Context context) {
        super(context);
    }

    public SuperViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        helper=new ViewPageHelper(this);

    }

    @Override
    public void setCurrentItem(int item) {
        setCurrentItem(item,true);
    }

    @Override
    public void setCurrentItem(int item, boolean smoothScroll) {
        MScroller scroller=helper.getScroller();
        if(Math.abs(getCurrentItem()-item)>1){
            scroller.setNoDuration(true);
            super.setCurrentItem(item, smoothScroll);
            scroller.setNoDuration(false);
        }else{
            scroller.setNoDuration(false);
            super.setCurrentItem(item, smoothScroll);
        }
    }
}
