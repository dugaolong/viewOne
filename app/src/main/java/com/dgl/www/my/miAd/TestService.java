package com.dgl.www.my.miAd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class TestService extends Service {
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("当前线程 执行了====TestService0000=====" + Thread.currentThread().getId());

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("当前线程 执行了==22222==" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("当前线程 执行了=====TestService=结束=====" + Thread.currentThread().getId());
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }
}