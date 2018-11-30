package com.dgl.www.my.customView.circlePercent;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.dgl.www.my.R;
import com.dgl.www.my.utils.DeviceUtil;

/**
 * Created by dugaolong on 17/7/17.
 */

public class CirclePercentView extends View {

    private int mCircleColor;//圆的颜色
    private int mArcColor;//圆弧颜色
    private int mArcWidth;//圆弧宽度
    private int mPercentTextColor;//文字颜色
    private int mPercentTextSize;//字体大小
    private int mRadius;//半径
    private Paint mCirclePaint;//圆的画笔
    private Paint mArcPaint;//弧的画笔
    private Paint mPercentTextPaint;//文字的画笔
    private RectF mArcRectF;//圆弧的矩形
    private Rect mTextBound;//文字的矩形
    private float mCurPercent = 0.0f;//
    private OnClickListenerl111 mOnClickListener;//

    public CirclePercentView(Context context) {
        this(context, null);
    }

    public CirclePercentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CirclePercentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);//
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.CirclePercentView, defStyleAttr, 0);//自定义属性
        mCircleColor = ta.getColor(R.styleable.CirclePercentView_circleBg, 0xff8e29fa);//圆的背景色
        mArcColor = ta.getColor(R.styleable.CirclePercentView_arcColor, 0xffffee00);//弧的颜色
        mArcWidth = ta.getDimensionPixelSize(R.styleable.CirclePercentView_arcWidth, DeviceUtil.dip2px(context, 16));//弧的宽度
        mPercentTextColor = ta.getColor(R.styleable.CirclePercentView_arcColor, 0xffffee00);//弧的颜色
        mPercentTextSize = ta.getDimensionPixelSize(R.styleable.CirclePercentView_percentTextSize, DeviceUtil.sp2px(context, 16));//字体大小
        mRadius = ta.getDimensionPixelSize(R.styleable.CirclePercentView_radius, DeviceUtil.dip2px(context, 100));//半径尺寸
        ta.recycle();//每次使用完，都要讲TypedArray放回池中，单例模式+池

        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);//实例化圆的paint
        mCirclePaint.setStyle(Paint.Style.FILL);//样式：填充
        mCirclePaint.setColor(mCircleColor);//画笔颜色

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//实例化弧的paint
        mArcPaint.setStyle(Paint.Style.STROKE);//样式:空心
        mArcPaint.setStrokeWidth(mArcWidth);//
        mArcPaint.setColor(mArcColor);//
        mArcPaint.setStrokeCap(Paint.Cap.ROUND);////使圆弧两头圆滑

        mPercentTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);//抗锯齿
        mPercentTextPaint.setStyle(Paint.Style.STROKE);//空心
        mPercentTextPaint.setColor(mPercentTextColor);//画笔颜色
        mPercentTextPaint.setTextSize(mPercentTextSize);//字体大小

        mArcRectF = new RectF();////圆弧的外接矩形

        mTextBound = new Rect();////文本的范围矩形

        //在构造方法中
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnClickListener != null) {
                    mOnClickListener.onClick1111(CirclePercentView.this);//
                }
            }
        });//

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureDimension(widthMeasureSpec), measureDimension(heightMeasureSpec));//
    }

    private int measureDimension(int measureSpec) {
        int result;//
        int specMode = MeasureSpec.getMode(measureSpec);//
        int specSize = MeasureSpec.getSize(measureSpec);//
        if (specMode == MeasureSpec.EXACTLY) {//精确地，代表宽高为定值或者match_parent时
            result = specSize;//
        } else {
            result = 2 * mRadius;//
            if (specMode == MeasureSpec.AT_MOST) {//最大地，代表宽高为wrap_content时
                result = Math.min(result, specSize);//
            }
        }
        return result;//
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //画圆
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRadius, mCirclePaint);//

        //素描圆弧
        mArcRectF.set(getWidth() / 2 - mRadius + mArcWidth / 2, getHeight() / 2 - mRadius + mArcWidth / 2
                , getWidth() / 2 + mRadius - mArcWidth / 2, getHeight() / 2 + mRadius - mArcWidth / 2);//
        //画圆弧
        canvas.drawArc(mArcRectF, 270, 360 * mCurPercent / 100, false, mArcPaint);//

        String text = mCurPercent + "%";//
        //得到文本的边界，上下左右，提取到bounds中，可以通过这个计算出文本的宽和高
        mPercentTextPaint.getTextBounds(text, 0, String.valueOf(text).length(), mTextBound);//
        //画百分比文本
        canvas.drawText(text, getWidth() / 2 - mTextBound.width() / 2,
                getHeight() / 2 + mTextBound.height() / 2, mPercentTextPaint);//
    }

    public void setCurPercent(final float curPercent) {
        ValueAnimator anim = ValueAnimator.ofFloat(mCurPercent, curPercent);////属性动画
        //动画时长由百分比大小决定
        anim.setDuration((long) (Math.abs(mCurPercent - curPercent) * 20));//
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();//
//                mCurPercent = curPercent;//
                mCurPercent = (float) (Math.round(value * 10)) / 10;////四舍五入保留到小数点后两位
                invalidate();////重绘，重走onDraw()方法，这也是不能再onDraw()中创建对象的原因
            }
        });//
        anim.start();//
    }

    public void setOnCircleClickListener(OnClickListenerl111 onClickListener) {
        this.mOnClickListener = onClickListener;//
    }

    public interface OnClickListenerl111 {
        void onClick1111(View v);
    }


}
