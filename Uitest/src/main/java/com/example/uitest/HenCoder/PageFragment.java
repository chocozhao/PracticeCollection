package com.example.uitest.HenCoder;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;

import com.example.uitest.R;

/**
 * @author chocozhao
 * @version version 1.0.0
 * @date 2018/4/23 17:15.
 * @email zhao1027313530@gmail.com
 * @instructions 说明
 * @features 功能
 * @descirbe 描述
 */
public class PageFragment extends Fragment {

    @LayoutRes int sampleLayoutRes;
    @LayoutRes int practiceLayoutRes;

    public static PageFragment newInstance(@LayoutRes int sampleLayoutResm, @LayoutRes int practiceLayoutRes) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("sampleLayoutRes",sampleLayoutResm);
        args.putInt("practiceLayoutRes",practiceLayoutRes);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hencoder, container, false);

        ViewStub sampleStub = view.findViewById(R.id.sampleStub);
        sampleStub.setLayoutResource(sampleLayoutRes);
        sampleStub.inflate();

        ViewStub practiceStub = view.findViewById(R.id.practiceStub);
        practiceStub.setLayoutResource(practiceLayoutRes);
        practiceStub.inflate();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Bundle args = getArguments();
        if(args != null) {
            sampleLayoutRes = args.getInt("sampleLayoutRes");
            practiceLayoutRes = args.getInt("practiceLayoutRes ");
        }
    }



}
