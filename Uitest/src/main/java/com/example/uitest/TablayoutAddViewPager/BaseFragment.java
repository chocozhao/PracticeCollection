package com.example.uitest.TablayoutAddViewPager;


import com.flyco.tablayout.listener.CustomTabEntity;

/**
 * Created by chocozhao on 2018/4/2.
 */

public class BaseFragment  implements CustomTabEntity{
    private int selectedIcon;
    private int unselectedIcon;
    private String title;


    public BaseFragment(String title){
        this.title = title;
    }

    public BaseFragment(String title, int selectedIcon, int unselectedIcon) {
        this.title = title;
        this.selectedIcon = selectedIcon;
        this.unselectedIcon = unselectedIcon;
    }
    @Override
    public String getTabTitle() {
        return title;
    }

    @Override
    public int getTabSelectedIcon() {
        return selectedIcon;
    }

    @Override
    public int getTabUnselectedIcon() {
        return unselectedIcon;
    }
}
