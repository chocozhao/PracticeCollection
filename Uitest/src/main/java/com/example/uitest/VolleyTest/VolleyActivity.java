package com.example.uitest.VolleyTest;

import android.graphics.Bitmap;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.uitest.R;

public class VolleyActivity extends AppCompatActivity {

    private Button volley_btn_Click;
    private ImageView volley_iv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        intiView();
        intiImageRequest();
    }

    private void intiImageRequest() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        ImageLoader imageLoader = new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String s) {
                return null;
            }

            @Override
            public void putBitmap(String s, Bitmap bitmap) {

            }
        });
        ImageLoader.ImageListener listener = ImageLoader
                .getImageListener(volley_iv_show,
                R.drawable.diary_selected,
                R.drawable.diary_unselected);

//        imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener);

        imageLoader.get("http://img.my.csdn.net/uploads/201404/13/1397393290_5765.jpeg", listener, 400, 400);
    }

    private void intiView() {
        volley_btn_Click = findViewById(R.id.volley_btn_Click);
    }


}
