package com.dgl.www.my.customView.animator;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dugaolong on 17/7/19.
 */

public class Circle extends View {

    private OnClickListener mListener;
    private Paint circlePiant;
    private float radius = 10f;

    public Circle(Context context) {
        this(context, null);
    }

    public Circle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Circle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //初始化paint
        circlePiant = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePiant.setColor(Color.GREEN);
        circlePiant.setStyle(Paint.Style.STROKE);//描边
        circlePiant.setStrokeWidth(2);
        super.setBackgroundColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, circlePiant);
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        mListener = l;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (x + getLeft() < getRight() && y + getTop() < getBottom()) {
                    mListener.onClick(this);
                }
                break;
        }
        return true;
    }

    public void valueAnimator() {
        ValueAnimator anim = ValueAnimator.ofFloat(0f, 100f);
        anim.setDuration(1000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                radius = currentValue;
                Log.d("TAG", "cuurent radius is " + radius);
                //至关重要：调用invalidate()才会重新绘制view，也就会调用ondraw()方法。
                invalidate();
            }
        });
        anim.start();
    }

    public void objectAnimator() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "alpha", 1f, 0f, 1f);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //至关重要：调用invalidate()才会重新绘制view，也就会调用ondraw()方法。
                invalidate();
            }
        });
        animator.start();
    }

    public void animatorSet() {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(this, "alpha", 1f, 0f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(this, "radius", 0f, 100f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(animator1).with(animator2);
        animSet.setDuration(1000);
        animSet.start();
    }


    public float getRadius() {
        return radius;
    }

    /**
     * 为什么必须要有 setRadius()？
     * 因为：
     * 在ObjectAnimator animator2 = ObjectAnimator.ofFloat(this, "radius", 0f, 100f);构造方法中，
     * 实际是调用了circle对象的set和get方法
     */
    public void setRadius(float radius) {
        this.radius = radius;
        invalidate();
    }
}
