package com.dgl.www.my.customView;

import android.app.Activity;
import android.os.Bundle;

/**
 *
 * 温度计
 * Created by dugaolong on 17/12/1.
 */

public class ThemometerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Themometer themometer = new Themometer(this);
        themometer.setTemperature(37f);
        setContentView(themometer);

    }

}
