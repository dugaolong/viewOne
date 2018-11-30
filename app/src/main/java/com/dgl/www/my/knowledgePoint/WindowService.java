package com.dgl.www.my.knowledgePoint;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.dgl.www.my.base.MyApplication;

/**
 * Created by dugaolong on 17/2/8.
 */

public class WindowService extends Service {
    public String TAG = this.getClass().getSimpleName();
    private WindowManager.LayoutParams wmParams;
    private WindowManager mWindowManager;
    private View mWindowView;
    private TextView mPercentTv;

    private int mStartX;
    private int mStartY;
    private int mEndX;
    private int mEndY;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        initWindowParams();
        initView();
        addWindowView2Window();
//        initClick();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
        if (mWindowView != null) {
            //移除炫富窗口
            mWindowManager.removeView(mWindowView);
        }

    }

    private void addWindowView2Window() {
        mWindowManager.addView(mWindowView, wmParams);
    }

    private void initView() {
        mWindowView = LayoutInflater.from(MyApplication.getInstance()).inflate(R.layout.windowservice, null);
        mPercentTv = (TextView) mWindowView.findViewById(R.id.percentTv);
    }

    private void initWindowParams() {
        mWindowManager = (WindowManager) MyApplication.getInstance().getSystemService(MyApplication.getInstance().WINDOW_SERVICE);
        wmParams = new WindowManager.LayoutParams();
        wmParams.type = WindowManager.LayoutParams.TYPE_PHONE;
        wmParams.format = PixelFormat.TRANSLUCENT;
        wmParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        wmParams.gravity = Gravity.LEFT | Gravity.TOP;
        wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
    }
}
