package firstcode.TryActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import firstcode.ActivityCollector;
import firstcode.TryActivity.BaseActivity;

/**
 * Created by 赵泳霖 on 2017/8/6.
 */

public class ThirdActivity extends BaseActivity {
    private Button btn_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity", "Task id is"+getTaskId());
        setContentView(R.layout.third_activity);

        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/
                ActivityCollector.finishAll();
            }
        });
    }
}
