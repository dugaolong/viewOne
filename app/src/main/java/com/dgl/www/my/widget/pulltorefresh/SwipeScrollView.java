package com.dgl.www.my.widget.pulltorefresh;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import com.dgl.www.my.widget.swipemenulistview.SwipeMenuListView;


/**
 * 控制scrollview在指定角度范围内接受ontouch事件
 * @author hexiaodong
 *
 */
public class SwipeScrollView extends ScrollView {

	private float mDownX;
	private float mDownY;
	private SwipeMenuListView mSwipeMenuListView;
	private double degree = 60;//action_down 和 action_up 所连直线需，大于tan(degree)， 小于tan(-degree)才能运行执行ontouch

	public SwipeScrollView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public SwipeScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public SwipeScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		float k;
		double limitTan;
		double limitTanNagetive;
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			return super.onTouchEvent(ev);
		case MotionEvent.ACTION_MOVE:
			k = (mDownY - ev.getY()) / (mDownX - ev.getX());
			limitTan = Math.tan(Math.toRadians(degree));
			limitTanNagetive = Math.tan(Math.toRadians(-degree));
			if (k < limitTanNagetive || k > limitTan) {
				return super.onTouchEvent(ev);
			} else {
				return false;
			}
		case MotionEvent.ACTION_UP:
			if (null != mSwipeMenuListView) {
				mSwipeMenuListView.onTouchEvent(ev);
			}
			k = (mDownY - ev.getY()) / (mDownX - ev.getX());
			limitTan = Math.tan(Math.toRadians(degree));
			limitTanNagetive = Math.tan(Math.toRadians(-degree));
			if (k < limitTanNagetive || k > limitTan) {
				super.onTouchEvent(ev);
				return false;
			} else {
				return false;
			}
		default:
			return super.onTouchEvent(ev);
		}
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			mDownX = ev.getX();
			mDownY = ev.getY();
			break;
		case MotionEvent.ACTION_UP:
			super.onInterceptTouchEvent(ev);
			return false;
		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}

	public void setSwipeMenuListView(SwipeMenuListView view) {
		this.mSwipeMenuListView = view;
	}
}
