package com.dgl.www.my.customView;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.dgl.www.my.R;

/*
 * @author yuanbieli 20110805
 * */
public class Thermometer extends Activity implements Callback {

    private SurfaceView mSurface;
    private SurfaceHolder mHolder;
    private EditText mEditText;
    private Button mDisOnThe;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themometer);
        mSurface = (SurfaceView) findViewById(R.id.surface);
        mEditText = (EditText) findViewById(R.id.inputtem);
        mDisOnThe = (Button) findViewById(R.id.lookup);
        mHolder = mSurface.getHolder();
        mHolder.addCallback(this);
        mDisOnThe.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String tem = mEditText.getText().toString();
                draw(tem);
            }

        });
    }

    private void draw(String temp) {
        float tem1 = Float.parseFloat(temp);
        int y = 260 - (int) ((tem1 - 35) * 20);
        Canvas canvas = mHolder.lockCanvas();
        Paint mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        canvas.drawRect(40, 50, 60, 280, mPaint);
        Paint paintCircle = new Paint();
        paintCircle.setColor(Color.RED);
        Paint paintLine = new Paint();
        paintLine.setColor(Color.BLUE);
        canvas.drawRect(40, y, 60, 280, paintCircle);
        canvas.drawCircle(50, 300, 25, paintCircle);
        int ydegree = 260;
        int tem = 35;
        while (ydegree > 55) {
            canvas.drawLine(60, ydegree, 67, ydegree, mPaint);
            if (ydegree % 20 == 0) {
                canvas.drawLine(60, ydegree, 72, ydegree, paintLine);
                canvas.drawText(tem + "", 70, ydegree + 4, mPaint);
                tem++;
            }
            ydegree = ydegree - 2;
        }
        mHolder.unlockCanvasAndPost(canvas);// 更新屏幕显示内容
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }
}