package com.dgl.www.my.knowledgePoint;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;

import com.dgl.www.my.R;
import com.dgl.www.my.base.BaseActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class TencentX5 extends BaseActivity {

    com.tencent.smtt.sdk.WebView tbsContent;//腾讯X5WebView
    private String url = "http://zhyx.bjjcyh.com/Newstulogin.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tencent_x5);

        getWindow().setFormat(PixelFormat.TRANSLUCENT);//（这个对宿主没什么影响，建议声明）
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        initView();
    }

    private void initView() {
        tbsContent = (com.tencent.smtt.sdk.WebView)findViewById(R.id.tbsContent);
        tbsContent.loadUrl(url);
        WebSettings webSettings = tbsContent.getSettings();
        webSettings.setJavaScriptEnabled(true);
        tbsContent.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && tbsContent.canGoBack()) {
            tbsContent.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }
}