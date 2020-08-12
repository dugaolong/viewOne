package com.dgl.www.my.customView.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by dugaolong on 17/12/8.
 */

public class MyTextView extends View {

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        //空心circle
        Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.RED);
        textPaint.setStrokeWidth(2f);
        textPaint.setTextSize(22f);
        canvas.drawText("空心circle", 100f, 30f, textPaint);

        Paint circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);//打开抗锯齿
        circlePaint.setStrokeWidth(20f);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setColor(Color.RED);
        canvas.drawCircle(100f, 100f, 30f, circlePaint);
        //实心circle
        canvas.drawText("实心circle", 400f, 30f, textPaint);
        circlePaint.setStrokeWidth(20f);
        circlePaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(400f, 100f, 30f, circlePaint);

        ////实心rect
        canvas.drawText("实心rect", 100f, 260f, textPaint);
        Paint rectPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//打开抗锯齿
        rectPaint.setStrokeWidth(20f);
        rectPaint.setStyle(Paint.Style.FILL);
        rectPaint.setColor(Color.GREEN);
        Rect rect = new Rect(100,300,300,400);
        canvas.drawRect(rect,rectPaint);
        canvas.save();
        canvas.rotate(30);
        ////空心rect
        canvas.drawText("空心rect", 400f, 260f, textPaint);
        rectPaint.setStrokeWidth(20f);
        rectPaint.setStyle(Paint.Style.STROKE);
        Rect rectSTROKE = new Rect(400,300,600,400);
        canvas.drawRect(rectSTROKE,rectPaint);
        canvas.restore();
        ////实心arc
        canvas.drawText("实心arc,useCenter", 100f, 460f, textPaint);
        Paint arcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//打开抗锯齿
        arcPaint.setStrokeWidth(20f);
        arcPaint.setStyle(Paint.Style.FILL);
        arcPaint.setColor(Color.GREEN);
        RectF rectF = new RectF(100,500,300,700);
        canvas.drawArc(rectF,-45,145,true,arcPaint);

        canvas.drawText("实心arc,no useCenter", 400f, 460f, textPaint);
        RectF rectFNo = new RectF(400,500,600,700);
        canvas.drawArc(rectFNo,-45,150,false,arcPaint);
        ////空心arc
        canvas.drawText("空心arc,useCenter", 100f, 740f, textPaint);
        arcPaint.setStrokeWidth(20f);
        arcPaint.setStyle(Paint.Style.STROKE);
        RectF RectFSTROKE = new RectF(100,800,300,1000);
        canvas.drawArc(RectFSTROKE,-45,145,true,arcPaint);

        canvas.drawText("空心arc,no useCenter", 400f, 740f, textPaint);
        RectF RectFSTROKENo = new RectF(400,800,600,1000);
        //设置线帽样式，取值有Cap.ROUND(圆形线帽)、Cap.SQUARE(方形线帽)、Paint.Cap.BUTT(无线帽)
        arcPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(RectFSTROKENo,-90,250,false,arcPaint);

    }
}
