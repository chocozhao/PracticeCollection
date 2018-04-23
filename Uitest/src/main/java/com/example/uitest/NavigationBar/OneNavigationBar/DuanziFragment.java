package com.example.uitest.NavigationBar.OneNavigationBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by chocozhao on 2018/4/1.
 */

public class DuanziFragment extends Fragment {

    public static DuanziFragment newInstance(String param1) {
        DuanziFragment fragment = new DuanziFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

}
