/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.dgl.www.my.widget.pulltorefresh;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.dgl.www.my.R;
import com.dgl.www.my.widget.swipemenulistview.SwipeMenuListView;


/**
 * 与SwipeMenuListView兼容的PulltorefreshScrollView
 * @author hexiaodong
 *
 */
public class PullToRefreshSwipeScrollView extends PullToRefreshBase<SwipeScrollView> {
	SwipeScrollView mSwipeScrollView;
	
	public PullToRefreshSwipeScrollView(Context context) {
		super(context);
	}

	public PullToRefreshSwipeScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public PullToRefreshSwipeScrollView(Context context, Mode mode) {
		super(context, mode);
	}

	public PullToRefreshSwipeScrollView(Context context, Mode mode, AnimationStyle style) {
		super(context, mode, style);
	}

	@Override
	public final Orientation getPullToRefreshScrollDirection() {
		return Orientation.VERTICAL;
	}

	@SuppressLint("NewApi")
	@Override
	protected SwipeScrollView createRefreshableView(Context context, AttributeSet attrs) {
		if (VERSION.SDK_INT >= VERSION_CODES.GINGERBREAD) {
			mSwipeScrollView = new InternalScrollViewSDK9(context, attrs);
		} else {
			mSwipeScrollView = new SwipeScrollView(context, attrs);
		}

		mSwipeScrollView.setId(R.id.scrollview);
		return mSwipeScrollView;
	}

	@Override
	protected boolean isReadyForPullStart() {
		return mRefreshableView.getScrollY() == 0;
	}

	@Override
	protected boolean isReadyForPullEnd() {
		View scrollViewChild = mRefreshableView.getChildAt(0);
		if (null != scrollViewChild) {
			return mRefreshableView.getScrollY() >= (scrollViewChild.getHeight() - getHeight());
		}
		return false;
	}

	@TargetApi(9)
	final class InternalScrollViewSDK9 extends SwipeScrollView {

		public InternalScrollViewSDK9(Context context, AttributeSet attrs) {
			super(context, attrs);
		}

		@Override
		protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX,
				int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {

			final boolean returnValue = super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX,
					scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);

			// Does all of the hard work...
			OverscrollHelper.overScrollBy(PullToRefreshSwipeScrollView.this, deltaX, scrollX, deltaY, scrollY,
					getScrollRange(), isTouchEvent);

			return returnValue;
		}

		/**
		 * Taken from the AOSP ScrollView source
		 */
		private int getScrollRange() {
			int scrollRange = 0;
			if (getChildCount() > 0) {
				View child = getChildAt(0);
				scrollRange = Math.max(0, child.getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
			}
			return scrollRange;
		}
		
		@Override
		public boolean onTouchEvent(MotionEvent ev) {
			// TODO Auto-generated method stub
			if (mOnTouchEventCallBack != null)
				mOnTouchEventCallBack.touchEvent(ev);
			return super.onTouchEvent(ev);
		}
	}
	
	private GetScrollYCallBack getScrollYCallBack = null;
	public void setGetScrollYCallBack(GetScrollYCallBack getScrollYCallBack) {
		this.getScrollYCallBack = getScrollYCallBack;
	}
	public interface GetScrollYCallBack{
		public void getScrolly(int deltaX, int deltaY, int scrollX, int scrollY);
	}
	
	private OnTouchEventCallBack mOnTouchEventCallBack = null;
	public void setOnTouchEventCallBack(OnTouchEventCallBack onTouchEventCallBack) {
		this.mOnTouchEventCallBack = onTouchEventCallBack;
	}
	public interface OnTouchEventCallBack{
		public void touchEvent(MotionEvent ev);
	}
	
	public void setSwipeMenuListView(SwipeMenuListView view){
		this.mSwipeScrollView.setSwipeMenuListView(view);
	}
}
