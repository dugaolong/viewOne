package com.dgl.www.my.systemService;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/6/26.
 */
public class SystemServiceActiity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.system_service, null);
        setContentView(view);

    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.network:
                if (isNetWorkOpen(SystemServiceActiity.this)) {
                    Log.i("dgl", "网络链接正常");
                }else{
                    Log.i("dgl", "网络未连接");
                }
                break;
        }
    }

    public boolean isNetWorkOpen(Context content) {

        if(content != null){
            ConnectivityManager connManager = (ConnectivityManager) this
                    .getSystemService(CONNECTIVITY_SERVICE);

//            ConnectivityManager connManager = (ConnectivityManager) this
//                    .getSystemService(NETWORK_STATS_SERVICE);

            if(connManager==null){
                Log.i("dgl","connManager2 is null");
            }
            //NetworkInfo对象用来描述网络信息。
            NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

            if (networkInfo!=null) {
                if(networkInfo.isAvailable()){
                    return true;
                }
            }
        }


        return false;
    }
}
