package com.dgl.www.my.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dugaolong on 17/5/11.
 */

public class HttpUtil {



    public static void sendOkHttpRequest(String address, okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(address)
                .build();
        client.newCall(request).enqueue(callback);
    }



}
