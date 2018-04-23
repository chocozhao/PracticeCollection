package firstcode.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Created by 赵泳霖 on 2017/8/10.
 */
/*
* 使用静态Fragment（静态加载）
* 1、定义Fragment的子类，并加载一个布局文件
* 2、在布局文件中通过<fragment>指定指定自定义Fragment
* 3、Activity必须继承于FragmentActivity
* 每个Fragment本质上都会生成一个FragmentLayout，它加载的布局其子布局
* */
public class FragmentTest extends FragmentActivity implements View.OnClickListener {
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
//        RightFragment rightFragment = new RightFragment();
        relaceFragment(new RightFragment());
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                relaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    /**
     * 动态加载
     * @param fragment
     */
    private void relaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();//获得FragmentManager
        FragmentTransaction transaction = fragmentManager.beginTransaction();//得到FragmentTransaction
        transaction.add(R.id.right_fragment, fragment);//添加
//        transaction.replace(R.id.right_fragment, fragment);//替换
        transaction.addToBackStack(null);//返回上一层，不会直接退出程序
        transaction.commit();//对添加的对象提交
    }
}
