package firstcode.BroadcastTest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

/**
 * Created by 赵泳霖 on 2017/9/5.
 */

public class MyBroadcastReceiverTest extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        button = (Button) findViewById(R.id.Send_Broadcast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("firstcode.BroadcastTest.MY_BROADCAST");
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
