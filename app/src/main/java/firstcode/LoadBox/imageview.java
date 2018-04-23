package firstcode.LoadBox;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.myapplication.R;

/**
 * Created by 赵泳霖 on 2017/8/6.
 */

public class imageview extends Activity implements View.OnClickListener {
    private Button btn_4;
    private EditText edittext;
    private ProgressBar progress_bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview);

        btn_4 = (Button) findViewById(R.id.btn_4);
        edittext = (EditText) findViewById(R.id.edittext);
        progress_bar = (ProgressBar) findViewById(R.id.progress_bar);

        btn_4.setOnClickListener(this);
        edittext.setOnClickListener(this);
        progress_bar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_4:
                /*圆形进度条*/
            /*    if (progress_bar.getVisibility() == View.GONE) {
                    progress_bar.setVisibility(View.VISIBLE);
                } else {
                    progress_bar.setVisibility(View.GONE);
                }*/
                //直线进度条
                /*int progress = progress_bar.getProgress();
                progress = progress + 10;
                progress_bar.setProgress(progress);*/
                //提示对话框
              /*  AlertDialog.Builder dialog = new AlertDialog.Builder(imageview.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important");
                dialog.setCancelable(false);
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();*/
                //加载框
                /*ProgressDialog progressDialog = new ProgressDialog(imageview.this);
                progressDialog.setTitle("This is progressDialg");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();*/

                break;

            default:
                break;
        }
    }

}
