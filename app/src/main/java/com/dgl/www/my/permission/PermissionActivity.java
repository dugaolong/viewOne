package com.dgl.www.my.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.dgl.www.my.R;

/**
 * Created by qianxiaoai on 2016/7/8.
 */
public class PermissionActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String TAG = PermissionActivity.class.getSimpleName();
    private static final int INT_ACTION_CALL = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
    }


    public void callPhone(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, INT_ACTION_CALL);
        } else {
            call();
        }
    }

    private void call() {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        }catch (SecurityException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (requestCode == INT_ACTION_CALL) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // Permission Granted
                        Toast.makeText(this,"You Granted the permission",Toast.LENGTH_LONG).show();
                    } else {
                        // Permission Denied
                        Toast.makeText(this,"You denied the permission",Toast.LENGTH_LONG).show();
                    }
                }
                break;
            default:
        }
    }
}