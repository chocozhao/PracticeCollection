package firstcode.TryActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.R;

import firstcode.LoadBox.imageview;

/**
 * Created by 赵泳霖 on 2017/8/6.
 */

public class FirstActivity extends BaseActivity {
    private Button btn_Click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity", "Task id is"+getTaskId());
        setContentView(R.layout.first_activity);

        btn_Click = (Button) findViewById(R.id.btn_Click);
        btn_Click.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                Toast.makeText(FirstActivity.this, "You clicker Button",Toast.LENGTH_SHORT).show();
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, imageview.class);
                intent.putExtra("extra_data",data);
               // intent.setData(Uri.parse("http://www.baidu.com"));//隐形Intent
                startActivity(intent);
            }
        });
    }


}
