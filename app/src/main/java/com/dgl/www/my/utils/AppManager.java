package com.dgl.www.my.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by zhangxingsheng on 16/5/16.
 */
public class AppManager {
    private static String TAG=AppManager.class.getSimpleName();
    /**
     * 检查程序是否位于前台运行
     */
    public static boolean isTopActivity(Context context) {
        List<ActivityManager.RunningTaskInfo> taskInfo = ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).getRunningTasks(1);
        if (taskInfo.size() > 0) {
            String topActivity = taskInfo.get(0).topActivity.getPackageName();
            if (DeviceUtil.getAppPackageName(context).equals(topActivity)) {
                Log.d(TAG, "topActivity is :"+topActivity);
                Log.d(TAG, "isTopActivity:true");
                return true;
            }
        }
        return false;
    }
}
