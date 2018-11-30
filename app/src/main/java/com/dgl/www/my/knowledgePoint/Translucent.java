package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

/**
 * Created by dugaolong on 16/8/10.
 * 沉浸式
 */
public class Translucent extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置沉浸式标题栏
        /**
         * 沉浸式要求：
         * 跟布局的背景色和标题栏的背景色必须一样。
         */
        int sdkInt = Build.VERSION.SDK_INT;
        Log.v("dgl", (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) + "");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        if (sdkInt > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {// api15 以上打开硬件加速
            if (!this.getComponentName().getClassName().equals("com.ryg.dynamicload.DLProxyActivity")) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED, WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
            }
        }
    }
}
