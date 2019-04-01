package com.dgl.www.my.foregroundService;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.dgl.www.my.MainActivity;
import com.dgl.www.my.R;

/**
 * Created by dugaolong on 19/1/17.
 */

public class ForegroundService extends Service {

    public String TAG = "ForegroundService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand()");
        // 在API11之后构建Notification的方式
        Notification.Builder builder = new Notification.Builder
                (this.getApplicationContext()); //获取一个Notification构造器
        Intent nfIntent = new Intent(this, MainActivity.class);
        builder.setContentIntent(PendingIntent.getActivity(this, 0, nfIntent, 0)) // 设置PendingIntent
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(),
                        R.mipmap.ic_launcher)) // 设置下拉列表中的图标(大图标)

                .setContentTitle("this is Title") // 设置下拉列表里的标题　　　　.setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏内的小图标
                .setContentText("this is content") // 设置上下文内容
                .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间　　
        Notification notification = builder.build(); // 获取构建好的Notification
        notification.defaults = Notification.DEFAULT_SOUND; //设置为默认的声音
        // 参数一：唯一的通知标识；参数二：通知消息。

        startForeground(110, notification);// 开始前台服务
        return super.onStartCommand(intent, flags, startId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        stopForeground(true);// 停止前台服务--参数：表示是否移除之前的通知
        super.onDestroy();
    }
}
