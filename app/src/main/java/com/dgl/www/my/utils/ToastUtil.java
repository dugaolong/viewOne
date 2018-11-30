package com.dgl.www.my.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.dgl.www.my.R;


public class ToastUtil {

    private static Toast toast;

    public static int commentcount;
    public static long classid = -1;
    public static String classname = "";
    public static boolean isfirstenter1 = true;
    public static boolean isfirstenter2 = true;
    public static boolean isfirstenter3 = true;
    public static boolean isfirstenter4 = true;
    public static PopupWindow popupwindow;
    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                PopupWindow window = null;
                if (null != msg) {
                    window = (PopupWindow) msg.obj;
                }
                if (null != window) {
                    window.dismiss();
                }

            } catch (IllegalArgumentException e) {

            }
//            popupwindow.dismiss();
        }
    };

    public static synchronized void showTopToast(Activity activity, View view, String text, boolean isSuccess) {
        if (popupwindow != null) {
            popupwindow.dismiss();
            popupwindow = null;
        }
        initmPopupWindowView(activity, text, isSuccess);
//        if (popupwindow!=null && !popupwindow.isShowing()){
        popupwindow.showAsDropDown(view, 0, 0);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                } catch (Exception e) {

                }
                Message msg = new Message();
                msg.obj = popupwindow;
                handler.sendMessage(msg);
            }
        }).start();


//            Runnable runnable=new Runnable() {
//                @Override
//                public void run() {
//                    // TODO Auto-generated method stub
//                    // 要做的事情
//
//
//                }
//            };
//            handler.postDelayed(runnable, 1500);
////        }

    }

    private static void initmPopupWindowView(Activity context, String text, boolean isSuccess) {

        // // 获取自定义布局文件pop.xml的视图
        View customView = context.getLayoutInflater().inflate(R.layout.top_toast_layout,
                null, false);


        // 创建PopupWindow实例,200,150分别是宽度和高度
//        if (popupwindow == null){
        popupwindow = new PopupWindow(customView);
//        }

        popupwindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        popupwindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        // 设置动画效果 [R.style.AnimationFade 是自己事先定义好的]
//        popupwindow.setAnimationStyle(R.style.top_tost_style);
        // 自定义view添加触摸事件

        customView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popupwindow != null && popupwindow.isShowing()) {
                    popupwindow.dismiss();
                    popupwindow = null;
                }

                return false;
            }
        });

//        /** 在这里可以实现自定义视图的功能 */
        int drawableId = R.drawable.toast_success_icon;
        if (isSuccess) {
            drawableId = R.drawable.toast_success_icon;
        } else {
            drawableId = R.drawable.toast_cancel_icon;
        }

        Drawable drawable = context.getResources().getDrawable(drawableId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());

        final TextView mTextView = (TextView) customView.findViewById(R.id.tip);
        mTextView.setText(text);
        mTextView.setCompoundDrawables(drawable, null, null, null); //设置TextView的drawableleft

    }

    /**
     * Toast提醒
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }

    /**
     * Toast提醒
     *
     * @param context
     */
    public static void showToast(Context context, int resId) {
        if (toast == null) {
            toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
        } else {
            toast.setText(context.getResources().getString(resId));
        }
        toast.show();
    }

    public static void myToastShow(Context context, int stringId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.msg_notify_toast_layout, null);
        TextView text = (TextView) layout.findViewById(R.id.msg_notify_toast_text);
        text.setText(stringId);
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

    public static void myToastShow(Context context, String content) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.msg_notify_toast_layout, null);
        TextView text = (TextView) layout.findViewById(R.id.msg_notify_toast_text);
        text.setText(content);
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
