package com.dgl.www.my.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

import com.dgl.www.my.R;
import com.dgl.www.my.utils.ToastUtil;

/**
 * Created by dugaolong on 17/5/19.
 */

public class DownloadService extends Service {
    private DownloadTask downloadTask;
    private String downloadUrl;

    class DownloadBinder extends Binder{
        private void startDownloader(String url){
            if(downloadTask == null){
                downloadUrl = url;
                downloadTask = new DownloadTask(listener);
                downloadTask.execute(downloadUrl);
                startForeground(1,getNotification("Downloading...",0));
                ToastUtil.myToastShow(DownloadService.this,"Downloading...");
            }
        }

        public void pauseDownload(){

        }
    }


    private DownloadListener listener = new DownloadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1,getNotification("downloading...",progress));
        }

        @Override
        public void onSuccess() {
            downloadTask = null;
            //下载成功时,将前台的服务通知关闭,并创建一个下载成功的通知。
            stopForeground(true);

        }

        @Override
        public void onFialed() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onCanceled() {

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private NotificationManager getNotificationManager(){
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    //创建notification
    private Notification getNotification(String title,int progress){
        Intent intent = new Intent(this,DownloadActivity.class);
        //简单的说PendingIntent.getActivity()就是即将发生的intent.
        PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentIntent(pi);
        builder.setContentTitle(title);
        if(progress > 0 ){
            builder.setContentText(progress+"");
            builder.setProgress(100,progress,false);
        }
        return builder.build();
    }
}
