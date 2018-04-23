package com.example.uitest;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by chocozhao on 2018/3/18.
 */

public class AlertDialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }

    //显示一般AlertDialog
    public void showAD(View view) {
        new AlertDialog.Builder(this)
                .setTitle("删除数据")
                .setMessage("你要删除么？")
                .setPositiveButton("删除", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, null, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    //显示当选列表AlertDialog
    public void showBD(View view) {
        final String[] items = {"美女", "美少女", "美美少女"};
        new AlertDialog.Builder(this)
                .setTitle("请选择你的PC")
                .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogActivity.this, items[i], Toast.LENGTH_SHORT).show();

                        dialogInterface.dismiss();//移除dialog
                    }
                })
                .show();
    }

    // 显示自定义AlertDialog
    public void showCD(View view) {
        //加载布局文件
        View view1 = View.inflate(this, R.layout.activity_dialog_view, null);

        final EditText name = view1.findViewById(R.id.userName);
        final EditText pwd = view1.findViewById(R.id.userpwd);

        new AlertDialog.Builder(this)
                .setView(view1)
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String username = name.getText().toString();
                        String userpwd = pwd.getText().toString();

                        Toast.makeText(AlertDialogActivity.this, username + ":" + userpwd, Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    //显示圆形进度ProgressDialog
    public void showPD(View view) {
        final ProgressDialog progressDialog = ProgressDialog.show(this, "数据加载", "数据加载中....");

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                progressDialog.dismiss();//移除dialog

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(AlertDialogActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).start();

    }
    //显示水平进度ProgressDialog
    public void showPDTwo(View view) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 30;
                progressDialog.setMax(count);//设置最大值
                for (int i = 0; i < count; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressDialog.setProgress(progressDialog.getProgress() + 1);
                }
                progressDialog.dismiss();
            }
        }).start();
    }

    //时间表
    public void showDataAD(View view) {
        Calendar calendar = Calendar.getInstance();//创建日历对象

        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.DAY_OF_MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        Log.e("TAG", year+"-"+monthOfYear+"-"+dayOfMonth);

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                Log.e("TAG", year+"--"+(monthOfYear+1)+"--"+dayOfMonth);
            }
        },year,monthOfYear,dayOfMonth).show();
    }

    public void showTimeAD(View view) {
        Calendar calendar = Calendar.getInstance();

        int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        Log.e("TAG", hourOfDay+":"+minute);
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                Log.e("TAG", hourOfDay+"::"+minute);
            }
        },hourOfDay,minute,true).show();
    }
}
