package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/9/6.
 */
public class LocalFile extends Activity {

    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localfile);
        textView = (TextView) findViewById(R.id.tv);

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getPath();
                textView.setText(path+"");
            }
        });
        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                textView.setText(path+"");
            }
        });
        findViewById(R.id.bt3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = LocalFile.this.getCacheDir().getAbsolutePath();
                textView.setText(path+"");
            }
        });
        findViewById(R.id.bt4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = LocalFile.this.getFilesDir().getAbsolutePath();
                textView.setText(path+"");
            }
        });
        findViewById(R.id.bt5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = LocalFile.this.getExternalCacheDir().getAbsolutePath();
                textView.setText(path+"");
            }
        });
        findViewById(R.id.bt6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = LocalFile.this.getCacheDir().getAbsolutePath();
                textView.setText(path+"");
            }
        });
    }
}
