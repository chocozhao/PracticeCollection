package firstcode.LoadBox;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.R;

/**
 * Created by 赵泳霖 on 2017/8/7.
 */

public class TitleLayout extends LinearLayout {
    private Button title_back;
    private Button title_edit;
    private EditText title_title;
    public TitleLayout(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.titlebar, this);

        title_back = (Button) findViewById(R.id.title_back);
        title_edit = (Button) findViewById(R.id.title_edit);
        title_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        title_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Welcome",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
