package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.KeyEventDispatcher;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.dgl.www.my.R;

public class WindowVisibleDisplayFrame extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.window_visible);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                top();
            }
        });

    }

    public void top(){
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);

        Log.e("window top",rect.top+"");
        Log.e("window bottom",rect.bottom+"");

//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
       int widthPixels =  getWindow().getDecorView().getWidth();
       int heightPixels =  getWindow().getDecorView().getHeight();

        Log.e("window .widthPixels",widthPixels+"");
        Log.e("window .heightPixels",heightPixels+"");
    }



}
