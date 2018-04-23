package com.example.uitest.TablayoutAddViewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.uitest.R;

/**
 * Created by chocozhao on 2018/4/1.
 */

public class DuanziFragment extends Fragment {

    public static DuanziFragment newInstance() {
        DuanziFragment fragment = new DuanziFragment();
        Bundle args = new Bundle();
//        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_material_test, container, false);
        TextView textView = view.findViewById(R.id.mail);
        return view;
    }

}
