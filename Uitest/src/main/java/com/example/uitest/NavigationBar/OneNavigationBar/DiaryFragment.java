package com.example.uitest.NavigationBar.OneNavigationBar;


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

public class DiaryFragment extends Fragment {

    public static DiaryFragment newInstance(String param1) {
        DiaryFragment fragment = new DiaryFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nav_hearer, container, false);
        Bundle bundle = getArguments();
        String agrs1 = bundle.getString("agr1");
        TextView textView = view.findViewById(R.id.mail);
        textView.setText(agrs1);
        return view;
    }
}
