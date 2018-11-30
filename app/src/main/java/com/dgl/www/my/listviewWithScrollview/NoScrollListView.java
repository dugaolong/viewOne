package com.dgl.www.my.listviewWithScrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class NoScrollListView extends ListView {

    public NoScrollListView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public NoScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public NoScrollListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultsize = measureHight(600, heightMeasureSpec);
        int expandSpec = MeasureSpec.makeMeasureSpec(defaultsize, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    private int measureHight(int size, int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = size;//最小值是300px ，自己设定
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    float down = 0;
    float y;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                down = ev.getRawY();
                //不让父控件拦截
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                y = ev.getRawY();
                if (y - down > 0) {//向下滑动
                    if (isTop()) {//到顶部
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                if (y - down < 0) {//向上滑动
                    if (isBottom()) {//到底部
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    //判断listview是否滑到顶部
    public boolean isTop() {
        int firstitemposition = getFirstVisiblePosition();//返回的是当前可以看到的第一个item的下标
        if (firstitemposition == 0) {
            if(getChildAt(0).getTop()==0){
                return true;
            }
        }
        return false;
    }

    public boolean isBottom() {
        int firstitemposition = getFirstVisiblePosition();//返回的是当前可以看到的第一个item的下标
        int lastVisiblePosition = getLastVisiblePosition();//返回的是当前可以看到的最后一个item的下标
        if (lastVisiblePosition+1 ==  getCount()) {
            if(getChildAt(lastVisiblePosition-firstitemposition).getBottom()==this.getHeight()){
                return true;
            }
        }
        return false;
    }
}