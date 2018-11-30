package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/8/18.
 */
public class NinePng extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ninepng);
        TextView textView = (TextView) findViewById(R.id.tv_nine);
        textView.setText("两个楼梦");

    }
}
