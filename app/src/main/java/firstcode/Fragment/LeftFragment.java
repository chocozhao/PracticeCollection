package firstcode.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Created by 赵泳霖 on 2017/8/10.
 */

public class LeftFragment extends Fragment {
    private Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //将布局加载进去利用inflate方法
        View view = inflater.inflate(R.layout.left_fragment, container, false);
        view.setBackgroundColor(Color.RED);
        return view;
    }
}
