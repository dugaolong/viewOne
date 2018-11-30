package com.dgl.www.my.customView;

import android.app.Activity;
import android.os.Bundle;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 17/7/6.
 */
public class ViewOneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MyView myView = new MyView(this);
//        setContentView(myView);
        setContentView(R.layout.viewone);


    }
}
