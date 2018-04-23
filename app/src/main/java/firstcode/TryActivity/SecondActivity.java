package firstcode.TryActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Created by 赵泳霖 on 2017/8/6.
 */

public class SecondActivity extends BaseActivity {
    private Button btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Log.d("SecondActivity", "Task id is"+getTaskId());
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);*/
               SecondActivity.actionStart(SecondActivity.this,"data1","data2");
            }
        });
    }
    public  static void actionStart(Context context,String data1,String data2){
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("SecondActivity","onDestroy");
    }
}
