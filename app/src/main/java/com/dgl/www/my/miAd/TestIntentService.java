package com.dgl.www.my.miAd;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class TestIntentService extends IntentService {

    public TestIntentService(){
        super("TestIntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     * @param name Used to name the worker thread, important only for debugging.
     */
    public TestIntentService(String name) {
        super(name);
    }

    @Override
    public void onCreate() {
        Log.e("TestIntentService--", "onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TestIntentService--", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//        Log.e("TestIntentService--", Thread.currentThread().getName() + "--" + intent.getStringExtra("info") );
//        for(int i = 0; i < 100; i++){ //耗时操作
//            Log.i("onHandleIntent--",  i + "--" + Thread.currentThread().getName());
//        }
                while (true) {
                    System.out.println("TestIntentService=====" + Thread.currentThread().getId());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
    }

    @Override
    public void onDestroy() {
        Log.e("TestIntentService--", "onDestroy");
        super.onDestroy();
    }
}