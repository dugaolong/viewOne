package com.dgl.www.my.qrscan;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import com.dgl.www.my.R;
import com.dgl.www.my.base.BaseActivity;
import com.netease.scan.IScanModuleCallBack;
import com.netease.scan.QrScan;
import com.netease.scan.ui.CaptureActivity;

public class QrscanActivity extends BaseActivity{

    private CaptureActivity mCaptureContext;
    private Button mStartScanButton;

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscan);

        initView();

        setListeners();
    }

    private void initView(){
        mStartScanButton = (Button)findViewById(R.id.btn_start_scan);
    }

    private void setListeners(){
        mStartScanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                QrScan.getInstance().launchScan(QrscanActivity.this, new IScanModuleCallBack() {
                    @Override
                    public void OnReceiveDecodeResult(final Context context, String result) {
                        mCaptureContext = (CaptureActivity)context;

                        AlertDialog dialog = new AlertDialog.Builder(mCaptureContext)
                                .setMessage(result)
                                .setCancelable(false)
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        QrScan.getInstance().restartScan(mCaptureContext);
                                    }
                                })
                                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        QrScan.getInstance().finishScan(mCaptureContext);
                                    }
                                })
                                .create();
                        dialog.show();
                    }
                });
            }
        });
    }
}
