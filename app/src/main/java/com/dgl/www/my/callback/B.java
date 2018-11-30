package com.dgl.www.my.callback;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by dugaolong on 16/6/19.
 */
public class B extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        A a = new A();
        a.eat(new Callback() {
            @Override
            public void callback() {
                Log.i("dgl","callback 方法");
            }
        });
    }
}
