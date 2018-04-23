package com.example.uitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class ComponentActivity extends AppCompatActivity {
    private ProgressBar pb_progressbar_loading;
    private LinearLayout ll_progress_loading;
    private SeekBar sb_progressbar_loading;
    private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {//滑杆

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {//开始

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {//停止
            int progress = sb_progressbar_loading.getProgress();
            pb_progressbar_loading.setProgress(progress);

            if (progress == sb_progressbar_loading.getMax()) {
                ll_progress_loading.setVisibility(View.GONE);
            } else {
                ll_progress_loading.setVisibility(View.VISIBLE);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        init();
    }

    public void init() {
        pb_progressbar_loading =  findViewById(R.id.pb_progressbar_loading);
        ll_progress_loading =  findViewById(R.id.ll_progress_loading);
        sb_progressbar_loading =  findViewById(R.id.sb_progressbar_loading);

        sb_progressbar_loading.setOnSeekBarChangeListener(onSeekBarChangeListener);
    }
}
