package com.dgl.www.my.customView.weather;

import android.os.Bundle;

import com.dgl.www.my.R;
import com.dgl.www.my.base.BaseActivity;

/**
 * Created by dugaolong on 18/1/9.
 */

public class MyWeatherActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.weather);
        WeatherChartView chartView = (WeatherChartView) findViewById(R.id.line_char);
        // 设置白天温度曲线
        chartView .setTempDay(new int[]{12,15,16,13,16,15});
        // 设置夜间温度曲线
        chartView .setTempNight(new int[]{5,6,8,0,4,3});
        chartView .invalidate();

    }

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }
}
