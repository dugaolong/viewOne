package com.dgl.www.my.customView.circlePercent;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.dgl.www.my.R;

import java.util.Random;

/**
 * Created by dugaolong on 17/7/17.
 */

public class CirclePercentActivity extends Activity {

    private CirclePercentView  mCirclePercentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.circlepercent);

        mCirclePercentView = (CirclePercentView) findViewById(R.id.circlePercentView);
        mCirclePercentView.setOnCircleClickListener(new CirclePercentView.OnClickListenerl111() {
            @Override
            public void onClick1111(View v) {
                float percent = (float) (new Random().nextInt(100));
                mCirclePercentView.setCurPercent(percent);
            }


        });
    }
}
