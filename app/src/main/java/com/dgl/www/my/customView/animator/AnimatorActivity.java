package com.dgl.www.my.customView.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 17/7/19.
 */

public class AnimatorActivity extends Activity {

    public static final String TAG = "AnimatorActivity";
    private Circle circle;
    private Button value;
    private Button object;
    private Button animatorSet;
    private Button typeEvaluator;
    private MyAnimView myAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animator_test);

        circle = (Circle) findViewById(R.id.circle);
        value = (Button) findViewById(R.id.value);
        object = (Button) findViewById(R.id.object);
        animatorSet = (Button) findViewById(R.id.animatorSet);
        typeEvaluator = (Button) findViewById(R.id.typeEvaluator);
        myAnimView = (MyAnimView) findViewById(R.id.myAnimView);

        value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.valueAnimator();
            }
        });
        object.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.objectAnimator();
            }
        });
        animatorSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circle.animatorSet();
            }
        });
        circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(circle, "alpha", 1f, 0f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(circle, "radius", 0f, 100f);
                AnimatorSet animSet = new AnimatorSet();
                animSet.play(animator1).with(animator2);
                animSet.setDuration(1000);
                animSet.start();
            }
        });
        typeEvaluator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnimView.startAnimation();
            }
        });
    }
}
