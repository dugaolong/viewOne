package com.dgl.www.my.customView.test;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by dugaolong on 17/12/8.
 */

public class TestViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyTextView myTextView = new MyTextView(this);
        setContentView(myTextView);
    }
}
