package com.dgl.www.my.netstatus;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/10/14.
 */
public class NetStatusActivity extends Activity {
    private static final String LOGTAG = "NetStatusActivity";
    // 手机相关管理器
    private TelephonyManager telephonyManager;
    // 电话状态监听器
    private PhoneStateListener phoneStateListener;
    private BroadcastReceiver connectivityReceiver= new ConnectivityReceiver();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spannable);
        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        phoneStateListener = new PhoneStateChangeListener();
        registerConnectivityReceiver();
        startService(new Intent(NetStatusActivity.this, ListenNetStateService.class));
    }

    private void registerConnectivityReceiver() {
        Log.d(LOGTAG, "registerConnectivityReceiver()...");
        // 监听网络连接状态：LISTEN_DATA_CONNECTION_STATE
        telephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);
        IntentFilter filter = new IntentFilter();
        // filter.addAction(android.net.wifi.WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(android.net.ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectivityReceiver, filter);
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        Log.d(LOGTAG, "onBind()...");
        return null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOGTAG, "registerConnectivityReceiver()...");
        unregisterReceiver(connectivityReceiver);

    }
}
