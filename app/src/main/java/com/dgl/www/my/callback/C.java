package com.dgl.www.my.callback;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by dugaolong on 16/6/19.
 */
public class C extends Activity implements Callback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        A a = new A();
        a.eat(this);
    }

    @Override
    public void callback() {
        Log.i("dgl","callback 方法");
    }
}
