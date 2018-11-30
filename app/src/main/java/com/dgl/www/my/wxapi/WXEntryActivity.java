package com.dgl.www.my.wxapi;

/**
 * Created by dugaolong on 16/9/23.
 */

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.dgl.www.my.R;
import com.dgl.www.my.base.MyApplication;
import com.dgl.www.my.utils.PicUtil;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.modelmsg.WXTextObject;
import com.tencent.mm.sdk.modelmsg.WXWebpageObject;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.io.ByteArrayOutputStream;

/**
 * 微信客户端回调activity示例
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler, View.OnClickListener {
    String TAG = "WXEntryActivity";
    // IWXAPI 是第三方app和微信通信的openapi接口
    private IWXAPI api;
    int THUMB_SIZE = 150;
    private static final String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();


    Button send_text, send_img, send_webpage,popupwindow;
    private CheckBox isTimelineCb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);
        api = WXAPIFactory.createWXAPI(this, "wx378c84598a2f206c", false);
        api.handleIntent(getIntent(), this);

        send_text = (Button) findViewById(R.id.send_text);
        send_img = (Button) findViewById(R.id.send_img);
        send_webpage = (Button) findViewById(R.id.send_webpage);
        popupwindow = (Button) findViewById(R.id.popupwindow);
        isTimelineCb = (CheckBox) findViewById(R.id.is_timeline_cb);
        isTimelineCb.setChecked(false);
        if (isInstallWx()) {
            send_text.setOnClickListener(this);
            send_img.setOnClickListener(this);
            send_webpage.setOnClickListener(this);
            popupwindow.setOnClickListener(this);
        }


    }

    @Override
    public void onReq(BaseReq arg0) {
    }

    @Override
    public void onResp(BaseResp resp) {
        Log.e(TAG, "resp.errCode:" + resp.errCode + ",resp.errStr:"
                + resp.errStr);
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                Toast.makeText(this, "分享成功", Toast.LENGTH_LONG).show();
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                Toast.makeText(this, "分享取消", Toast.LENGTH_LONG).show();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                Toast.makeText(this, "分享被拒绝", Toast.LENGTH_LONG).show();
                break;
        }
    }

    /**
     * 分享文字
     */
    public void shareText() {
        WXTextObject textObj = new WXTextObject();
        textObj.text = "this is text";

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;
        msg.description = "this is description";

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("text");
        req.message = msg;
        req.scene = isTimelineCb.isChecked() ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;

        api.sendReq(req);
    }


    /**
     * 分享一个图片
     */
    public void shareImage() {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.send_img);
        WXImageObject imgObj = new WXImageObject(bmp);
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imgObj;
        Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
        bmp.recycle();
        msg.thumbData = PicUtil.bmpToByteArray(thumbBmp, true);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("img");
        req.message = msg;
        req.scene = isTimelineCb.isChecked() ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
        api.sendReq(req);
    }



    /**
     * 分享一个网页
     *
     * @param httpUrl     连接
     * @param icon        连接前显示的图标
     */
    public void shareWebPage(String httpUrl, int icon) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = httpUrl;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = "this is title";
        msg.description = "this is description";
        Bitmap bitmap = BitmapFactory.decodeResource(MyApplication.getInstance().getResources(), icon);
        msg.thumbData = bmpToByteArray(bitmap);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webpage");
        req.message = msg;
        req.scene = isTimelineCb.isChecked() ? SendMessageToWX.Req.WXSceneTimeline : SendMessageToWX.Req.WXSceneSession;
        api.sendReq(req);
    }




    /**
     * 得到Bitmap的byte
     *
     * @param bmp 图片
     * @return 返回压缩的图片
     */
    private static byte[] bmpToByteArray(Bitmap bmp) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, output);

        byte[] result = output.toByteArray();
        try {
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 构建一个唯一标志
     *
     * @param type 分享的类型分字符串
     * @return 返回唯一字符串
     */
    private static String buildTransaction(String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    private boolean isInstallWx() {
        if (!api.isWXAppInstalled()) {
            Toast.makeText(this, "您还未安装微信客户端",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.send_text:
                shareText();
                break;
            case R.id.send_img:
                shareImage();
                break;
            case R.id.send_webpage:
                shareWebPage("http://www.baidu.com", R.mipmap.ic_launcher);
                break;
            case R.id.popupwindow:
                startActivity(new Intent(this, ShareToWX.class));
                break;
        }
    }
}