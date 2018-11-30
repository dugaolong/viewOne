package com.dgl.www.my.okhttp;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.dgl.www.my.utils.DialogUtil;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

import static com.dgl.www.my.R.layout.okhttp;

/**
 * Created by dugaolong on 17/5/11.
 */

public class OkHttpActivity extends Activity implements okhttp3.Callback {

    private static final String TAG = "OkHttpActivity";
    private TextView mTextView;
    private String resp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(okhttp);
        mTextView = (TextView) findViewById(R.id.textview);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogUtil.showProgressDialog(OkHttpActivity.this,"正在查询,请稍后");
                HttpUtil.sendOkHttpRequest("https://www.baidu.com",OkHttpActivity.this);
            }
        });
    }

    @Override
    public void onFailure(Call call, IOException e) {
        e.printStackTrace();
    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
//        Log.i(TAG,response.body().string());
        DialogUtil.closeProgressDialog();
        resp = response.body().string();
        handler.sendEmptyMessage(1);
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                mTextView.setText(response.body().string()+"");
//            }
//        }, 10);
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                mTextView.setText(resp);
            }
        }
    };



//    new okhttp3.Callback(){
//
//        @Override
//        public void onFailure(Call call, IOException e) {
//            e.printStackTrace();
//        }
//
//        @Override
//        public void onResponse(Call call, final Response response) throws IOException {
//            Log.i(TAG,response.body().string());
////                        runOnUiThread(new Runnable() {
////                            @Override
////                            public void run() {
////                                try {
////                                    Log.i(TAG,response.body().string());
//////                                    mTextView.setText(response.body().string()+"");
////                                } catch (Exception e) {
////                                    e.printStackTrace();
////                                }
////                            }
////                        });
//        }
//    }
}
