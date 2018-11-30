package com.dgl.www.my.wxapi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.io.ByteArrayOutputStream;


public class ShareToWX extends Activity implements OnClickListener {

    private Bundle bundle;
    private ImageView back;
    private ImageView code;
    private TextView share_to_wx_hint, share_to_wx_text;
    private View share_weixin;
    private View share_friends;
    public static final String CONTENT = "content";
    public static final String IMAGEURL = "imageUrl";
    public static final String URL = "url";
    public static final String TITLE = "title";
    private String title = "";
    private String content = "";
    private String imageUrl = "";
    private String url = "";
    private String hintStr = "";
    private String textStr = "";
    private int appIconResId;
    private IWXAPI api;
    // 微信
    private String WEIXIN_APP_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.share_to_wx_activity);

        title = "我正在使用formore手机版，感觉不错，你也来试试吧。";
        imageUrl = "http://www.zjxxt.com/v2t/mh/images/parent_mobile/putuo.png";
        hintStr = "扫描二维码,下载普陀智慧校园客户端";
        url = "http://t.cn/RLhtmOi";
        textStr = String.format("把%s分享到好友:", "formore");
        appIconResId = R.drawable.icon_clear;

        WEIXIN_APP_ID = "";
        api = WXAPIFactory.createWXAPI(this, WEIXIN_APP_ID, false);
        api.registerApp(WEIXIN_APP_ID);

        initView();
    }



    private void initView() {

        back = (ImageView) this.findViewById(R.id.share_to_wx_btn_back);
        code = (ImageView) this.findViewById(R.id.share_to_wx_code);
        share_to_wx_hint = (TextView) this.findViewById(R.id.share_to_wx_hint);
        share_to_wx_text = (TextView) this.findViewById(R.id.share_to_wx_text);
        share_friends = this.findViewById(R.id.share_to_wx_friends);
        share_weixin = this.findViewById(R.id.share_to_wx_weixin);

        share_to_wx_hint.setText(hintStr);
        share_to_wx_text.setText(textStr);

        // 添加按钮监听
        back.setOnClickListener(this);
        share_weixin.setOnClickListener(this);
        share_friends.setOnClickListener(this);

    }


    public void onClick(View v) {

        if (v.getId() == R.id.share_to_wx_btn_back) {
            finish();
        } else if (v.getId() == R.id.share_to_wx_friends) {//微信朋友圈
            shareToWeiXin(SendMessageToWX.Req.WXSceneTimeline);
        } else if (v.getId() == R.id.share_to_wx_weixin) {//微信好友
            shareToWeiXin(SendMessageToWX.Req.WXSceneSession);
        }
    }

    // 分享到微信
    private void shareToWeiXin(final int scene) {
        shareURLToWeiXin(title, content, url, appIconResId, scene);
    }

    private void shareURLToWeiXin(String title, String content, String url, int iconResId, int scene) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = url;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        if (TextUtils.isEmpty(content)) content = title;
        msg.title = title;
        msg.description = content;
        Bitmap thumb = BitmapFactory.decodeResource(ShareToWX.this.getResources(), iconResId);
        msg.thumbData = pngBmpToByteArray(thumb, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = msg;
        req.scene = scene;
        api.sendReq(req);
        finish();
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis())
                : type + System.currentTimeMillis();
    }

    /**
     * get png format image byte[] array
     *
     * @param bmp
     * @param needRecycle
     * @return
     * @Author hexiaodong
     */
    public static byte[] pngBmpToByteArray(final Bitmap bmp, final boolean needRecycle) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);
        if (needRecycle) {
            bmp.recycle();
        }

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
