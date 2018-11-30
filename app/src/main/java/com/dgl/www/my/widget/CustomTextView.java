package com.dgl.www.my.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

import com.dgl.www.my.R;

public class CustomTextView extends TextView {
    private Paint marginPaint;
    private Paint linePaint;
    private int paperColor;
    private float margin;

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }


    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        //获得对资源表的引用
        Resources myResources = getResources();
        //创建将在onDraw方法中使用的画刷
        marginPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        marginPaint.setColor(myResources.getColor(R.color.colorAccent));
        linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(myResources.getColor(R.color.app_theme_color));
        //获得页面背景色和边缘宽度
        paperColor = myResources.getColor(R.color.layout_background);
        margin = myResources.getDimension(R.dimen.noted_margin);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        //绘制页面的颜色
        canvas.drawColor(paperColor);

        //绘制边缘
        canvas.drawLine(0, getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight(), linePaint);

        //draw margin
        canvas.drawLine(margin, 0, margin, getMeasuredHeight(), marginPaint);

        //移动文本，让它跨过边缘
        canvas.save();
        canvas.translate(margin, 0);
        //使用TextView渲染文本
        super.onDraw(canvas);
        canvas.restore();
    }
}