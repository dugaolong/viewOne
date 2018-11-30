package com.dgl.www.my.miAd;


import android.util.Log;

import com.dgl.www.my.miAd.responseBean.ResponseBean;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConTest {

    private static String TAG = "HttpUrlConTest";

    // 请求
    public String fetchAds() {
        String str="";
        ResponseBean responseBean =null;
        StringBuilder response = new StringBuilder();
        try {
            String urlstr = "https://www.xajtfb.cn/BusPage/bus_realtime";
            Log.v(TAG,"urlstr="+urlstr);
            URL url = new URL(urlstr);

            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Charsert", "UTF-8"); //设置请求编码
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Host", "www.xajtfb.cn");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0.1; Redmi Note 3 Build/MMB29M; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.132 MQQBrowser/6.2 TBS/043909 Mobile Safari/537.36 MicroMessenger/6.6.5.1280(0x26060533) NetType/WIFI Language/zh_CN");
            connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,image/wxpic,image/sharpp,image/apng,*/*;q=0.8");
            connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
            connection.setRequestProperty("Accept-Language", "zh-CN,en-US;q=0.8");
            connection.setRequestProperty("Cookie", "Hm_lvt_363d1436b31d5d81219f7aa50e8f9168=1521163296; Hm_lpvt_363d1436b31d5d81219f7aa50e8f9168=1521167407");
            connection.setRequestProperty("Accept-Charset", "utf-8");
            connection.connect();

            InputStream input = connection.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input, "utf-8"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            str = response.toString();
            Log.e(TAG,"response:"+response);

            reader.close();
            input.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

}
