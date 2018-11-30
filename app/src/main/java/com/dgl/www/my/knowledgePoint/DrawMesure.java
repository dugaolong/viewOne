package com.dgl.www.my.knowledgePoint;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dgl.www.my.R;
import com.dgl.www.my.utils.AppManager;
import com.dgl.www.my.utils.DeviceUtil;
import com.dgl.www.my.utils.MySystemParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 16/8/15.
 */
public class DrawMesure extends Activity {
    private TextView textView;
    private static final int MY_PERMISSIONS_REQUEST = 0; // 请求码
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1; // 请求码
    private static final int MY_PERMISSIONS_REQUEST_SENDSMS = 2; // 请求码
    String[] permissions = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.SEND_SMS
    };
    // 声明一个集合，在后面的代码中用来存储用户拒绝授权的权
    List<String> mPermissionList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawmesure);
        textView = (TextView) findViewById(R.id.tv_show);

        mPermissionList.clear();
//        for (int i = 0; i < permissions.length; i++) {
//            if (ContextCompat.checkSelfPermission(DrawMesure.this, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
//                mPermissionList.add(permissions[i]);
//            }
//        }
//        if (mPermissionList.isEmpty()) {//未授予的权限为空，表示都授予了
//            show();
//            Toast.makeText(DrawMesure.this,"已全部经授权",Toast.LENGTH_LONG).show();
//        } else {//请求权限方法
//            String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
//            ActivityCompat.requestPermissions(DrawMesure.this, permissions, MY_PERMISSIONS_REQUEST);
//        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST: {
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        showToast("权限被拒绝");
                        //判断是否勾选禁止后不再询问
                        boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(DrawMesure.this, permissions[i]);
                        if (showRequestPermission) {
                            showToast("权限未申请");
                        }
                    }
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    show();
                } else {
                    // Permission Denied
                    Toast.makeText(DrawMesure.this, "CONTACTS Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_SENDSMS: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    sendSms();
                } else {
                    // Permission Denied
                    Toast.makeText(DrawMesure.this, "SENDSMS Denied", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void showToast(String string) {
        Toast.makeText(DrawMesure.this, string, Toast.LENGTH_LONG).show();
    }

    /**
     * 跳转到miui的权限管理页面
     */
    private void gotoMiuiPermission() {
        Intent i = new Intent("miui.intent.action.APP_PERM_EDITOR");
        ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        i.setComponent(componentName);
        i.putExtra("extra_pkgname", getPackageName());
        try {
            startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void show() {
        MySystemParams mys = MySystemParams.getInstance(this);
        int px = DeviceUtil.dip2px(this, 45);
        textView.setText(mys.toString() + "\r\n#######" + px + "\r\nIMEI=" + DeviceUtil.getIMEI(this));
        AppManager.isTopActivity(this);
    }

    public void sendSms(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(DrawMesure.this, Manifest.permission.SEND_SMS)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DrawMesure.this, new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SENDSMS);
            } else {
                sendSms();
            }
        } else {
            sendSms();
        }
    }

    public void sendSms() {
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage("10086", null, "1032", null, null);
        Toast.makeText(getApplicationContext(), "发送完毕", Toast.LENGTH_SHORT).show();
    }

    public void showInfo(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(DrawMesure.this, Manifest.permission.READ_PHONE_STATE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(DrawMesure.this, new String[]{Manifest.permission.READ_PHONE_STATE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);
            } else {
                show();
            }
        } else {
            show();
        }

    }

}
