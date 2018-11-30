package com.dgl.www.my.customView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {
    private Rect mBound;
    public MyView(Context context) {
        super(context);
    }

    /**
     * 这个构造方法调用时间：在xml布局中加入<com.dgl.www.my.customView.MyView/> 时候
     * 注意点：只在代码中使用new MyView()的时候，可以不用这个方法
     * @param context
     * @param attrs
     */
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.e("MyView","MyView (Context context, AttributeSet attrs)");
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0;
        int height = 0;

        /**
         * ÉèÖÃ¿í¶È
         */
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        switch (specMode)
        {
            case MeasureSpec.EXACTLY:// Ã÷È·Ö¸¶¨ÁË
                width = getPaddingLeft() + getPaddingRight() + specSize;
                break;
            case MeasureSpec.AT_MOST:// Ò»°ãÎªWARP_CONTENT
                width = getPaddingLeft() + getPaddingRight() + mBound.width();
                break;
        }

        /**
         * ÉèÖÃ¸ß¶È
         */
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode)
        {
            case MeasureSpec.EXACTLY:// Ã÷È·Ö¸¶¨ÁË
                height = getPaddingTop() + getPaddingBottom() + specSize;
                break;
            case MeasureSpec.AT_MOST:// Ò»°ãÎªWARP_CONTENT
                height = getPaddingTop() + getPaddingBottom() + mBound.height();
                break;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);

        // 设置画布的背景颜色
        canvas.drawColor(Color.WHITE);
        /**
         * 定义矩形为空心
         */
        // 定义画笔1
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        // 消除锯齿
        paint.setAntiAlias(true);
        // 设置画笔的颜色
        paint.setColor(Color.RED);
        // 设置paint的外框宽度
        paint.setStrokeWidth(2);

        // 画一个圆
        canvas.drawCircle(40, 30, 20, paint);
        // 画一个正放形
        canvas.drawRect(20, 70, 70, 120, paint);
        // 画一个长方形
        RectF rect = new RectF(20, 170, 130, 230);
        canvas.drawRect(rect, paint);
        // 画一个椭圆
        RectF re = new RectF(20, 270, 100, 340);
        canvas.drawOval(re, paint);

        /**
         * 定义矩形为实心
         */
        paint.setStyle(Paint.Style.FILL);
        // 定义画笔2
        Paint paint2 = new Paint();
        // 消除锯齿
        paint2.setAntiAlias(true);
        // 设置画笔的颜色
        paint2.setColor(Color.BLUE);
        // 画一个空心圆
        canvas.drawCircle(150, 30, 20, paint2);
        // 画一个正方形
        canvas.drawRect(185, 70, 130, 120, paint2);
        // 画一个长方形
        canvas.drawRect(200, 130, 130, 180, paint2);
        // 画一个椭圆形
        RectF re2 = new RectF(200, 230, 130, 190);
        canvas.drawOval(re2, paint2);
        Rect face = new Rect(getWidth()/4, getHeight()/3, getWidth()-getWidth()/4, getHeight()-getHeight()/3);
        drawFaceRect(canvas,face,false);
    }

    static public void drawFaceRect(Canvas canvas, Rect face,  boolean DrawOriRect) {
        if (canvas == null) {
            return;
        }

        Paint paint = new Paint();
        paint.setColor(Color.rgb(255, 203, 15));
        int len = (face.bottom - face.top) / 8;
        if (len / 8 >= 2) paint.setStrokeWidth(len / 8);
        else paint.setStrokeWidth(2);

        Rect rect = face;


        if (DrawOriRect) {
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(rect, paint);
        } else {
            int drawl = rect.left - len;
            int drawr = rect.right + len;
            int drawu = rect.top - len;
            int drawd = rect.bottom + len;

            canvas.drawLine(drawl, drawd, drawl, drawd - len, paint);
            canvas.drawLine(drawl, drawd, drawl + len, drawd, paint);
            canvas.drawLine(drawr, drawd, drawr, drawd - len, paint);
            canvas.drawLine(drawr, drawd, drawr - len, drawd, paint);
            canvas.drawLine(drawl, drawu, drawl, drawu + len, paint);
            canvas.drawLine(drawl, drawu, drawl + len, drawu, paint);
            canvas.drawLine(drawr, drawu, drawr, drawu + len, paint);
            canvas.drawLine(drawr, drawu, drawr - len, drawu, paint);
        }
    }
}
