package com.dgl.www.my.miAd;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.dgl.www.my.miAd.bean.ClientInfo;

import okhttp3.MediaType;

/**
 * Created by dugaolong on 17/3/31.
 */

public class MiAdActivity extends Activity {

    public static final String TAG = "MiAdActivity";
    public static final MediaType mediaType = MediaType.parse("application/json;charset=utf-8");
    private ClientInfo clientInfo = new ClientInfo();
    private TextView textView;
private String str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mi_ad);

        textView = (TextView) findViewById(R.id.textview);
//        initData();
    }


    public void request(View v) {

//        startService(new Intent(this, TestIntentService.class));

        Thread td = new Thread(new Runnable() {

            @Override
            public void run() {
                HttpUrlConTest huc = new HttpUrlConTest();
//                for (int i = 0; i < 1494; i++) {
//                    handler.sendEmptyMessage(i);
//                    try {
//                        Thread thread = Thread.currentThread();
//                        thread.sleep(new Random().nextInt(20000));//暂停1.5秒后程序继续执行
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                str = huc.fetchAds();
                handler.sendEmptyMessage(1);
//                }
            }
        });
        td.start();


    }

//    public void stopservice(View v) {
//        stopService(new Intent(this, TestIntentService.class));
//    }


    //handler
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            textView.setText(str);
        }
    };


}
