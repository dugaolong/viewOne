package com.dgl.www.my.customView.scroll;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dugaolong on 17/7/28.
 */

public class DragView extends View {

    private int lastX;
    private int lastY;

    public DragView(Context context) {
        super(context, null);
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点坐标
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                //在当前left，top，right，bottom基础上，加上偏移量
                //因为layout中的坐标是相对于父控件的位置的。
                layout(getLeft() + offsetX, getTop() + offsetY, getRight() + offsetX, getBottom() + offsetY);
                break;

        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
}
