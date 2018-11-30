package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/8/30.
 */
public class NormalWebview extends Activity{

    private WebView webView;
//    private String url = "http://zhyx.bjjcyh.com/Newstulogin.html";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_webview);

        initView();
    }
    private void initView() {
        webView = (WebView) findViewById(R.id.webview);
//        webView.loadUrl("file:///android_asset/index.html");
        webView.loadUrl("http://player.youku.com/embed/XMzQxNzUzOTMxMg==");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
