package com.dgl.www.my.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.FeatureInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import com.dgl.www.my.MainActivity;
import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/7/5.
 */
public class MyNotification extends Activity implements View.OnClickListener {

    NotificationManager manager;
    int noti_id = 111;
    int index = 0;
    private Camera camera;
    private boolean isopent = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);

//        setview();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Button bt_send = (Button) findViewById(R.id.send);
        Button bt_cancel = (Button) findViewById(R.id.cancel);
        Button bt_light = (Button) findViewById(R.id.light);
        TextView tv = (TextView) findViewById(R.id.tv);
        bt_send.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
        bt_light.setOnClickListener(this);
        String str = "就点击付款时间公开的的积极发挥的实际感觉到覅功能的粉丝的";
//        if(str.length()>10){
//            str = str.substring(0,10)+"...";
//        }
        tv.setText(str);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send:
                sendNotification();
                break;
            case R.id.cancel:
                manager.cancelAll();
                break;
            case R.id.light:
                flshLight();
                break;
            case R.id.sendCustom:
                sendCustomNotification();
                break;
        }
    }

    private void flshLight() {
        int ii = 0;
        PackageManager pm = this.getPackageManager();
        FeatureInfo[] features = pm.getSystemAvailableFeatures();
        for (FeatureInfo f : features) {
            if (PackageManager.FEATURE_CAMERA_FLASH.equals(f.name))   //判断设备是否支持闪光灯
            {
                ii = 1;
                Log.v("dgl", "支持闪光灯");
            }
        }
        Camera.Parameters parameter;
        if (ii == 1) {
            if (!isopent) {
                Toast.makeText(getApplicationContext(), "您已经打开了手电筒", 0)
                        .show();
                camera = Camera.open();
                Camera.Parameters params = camera.getParameters();
                params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(params);
                camera.startPreview(); // 开始亮灯

                isopent = true;
            } else {
                Toast.makeText(getApplicationContext(), "关闭了手电筒",
                        Toast.LENGTH_SHORT).show();
                camera.stopPreview(); // 关掉亮灯
                camera.release(); // 关掉照相机
                isopent = false;
            }
        }
    }

    private void sendNotification() {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("这是一个通知消息这是一个通知消息这是一个通知消息" + (index++));
        builder.setContentTitle("这是title" + (index));
        builder.setContentText("这是content" + (index));
        builder.setWhen(System.currentTimeMillis());
//        builder.setDefaults(Notification.DEFAULT_LIGHTS);
//        builder.setLights(Color.RED, 3000, 3000);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setDefaults(Notification.DEFAULT_VIBRATE);
        long[] pattern = {500, 500, 500, 500, 500, 500};
        builder.setVibrate(pattern);
//        builder.setDefaults(Notification.DEFAULT_ALL);
        builder.setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.zz));
        //点击通知自动消失
        builder.setAutoCancel(true);
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pint = PendingIntent.getActivity(this, 0, intent, 0);
        builder.setContentIntent(pint);
        Notification notification = new NotificationCompat.Builder(this).build();
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
//            notification = builder.build();
//        } else {
//            notification = builder.getNotification();
//        }
        notification.flags = Notification.FLAG_SHOW_LIGHTS;
        notification.ledARGB = 0xff0000ff;
        notification.ledOnMS = 300;
        notification.ledOffMS = 300;
        // 第一个参数唯一的标识该Notification，第二个参数就是Notification对象。
//        manager.notify(noti_id, notification);
        manager.notify((int) System.currentTimeMillis(), notification);
    }

    private void sendCustomNotification() {
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_drawer)//通知图标
                .setTicker("来了一条消息")//状态栏显示的通知文本提示
                .setWhen(System.currentTimeMillis())//通知产生的时间，会在通知信息里显示
                .setAutoCancel(true)//点击后消失
                .setLights(Notification.DEFAULT_SOUND, 0, 1000)
                .setVibrate(new long[]{0, 1000, 1000, 1000})
                .build();
        Intent intent = new Intent(this, MyNotification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.view_notification_type_0);
        remoteViews.setTextViewText(R.id.title_tv, "火影");
        remoteViews.setTextViewText(R.id.content_tv, "鸣人大战佩恩");
        remoteViews.setImageViewResource(R.id.icon_iv, R.mipmap.ic_drawer);
        Intent intent2 = new Intent(this, MainActivity.class);
        //remoteViews的意图
        PendingIntent pendingIntent2 = PendingIntent.getActivity(
                this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        //给我remoteViews上的控件tv_content添加监听事件
        remoteViews.setOnClickPendingIntent(R.id.content_tv, pendingIntent2);

        notification.contentView = remoteViews;
        notification.contentIntent = pendingIntent;
        manager.notify((int) System.currentTimeMillis(), notification);
    }

    private void setview() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

}
