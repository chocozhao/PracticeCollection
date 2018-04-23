package com.example.uitest.NavigationBar.OneNavigationBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;

/**
 * Created by chocozhao on 2018/4/1.
 */

public class MeiziFragment  extends Fragment{

    public static MeiziFragment newInstance(String param1) {
        MeiziFragment fragment = new MeiziFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

}
