package com.example.uitest.TablayoutAddViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by chocozhao on 2018/4/1.
 */

public class MeiziFragment  extends Fragment{

    public static MeiziFragment newInstance() {
        MeiziFragment fragment = new MeiziFragment();
        Bundle args = new Bundle();
//        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

}
