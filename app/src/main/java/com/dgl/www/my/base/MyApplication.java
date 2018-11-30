package com.dgl.www.my.base;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.dgl.www.my.BuildConfig;
import com.dgl.www.my.R;
import com.dgl.www.my.crash.CrashHandler;
import com.dgl.www.my.utils.Constant;
import com.netease.scan.QrScan;
import com.netease.scan.QrScanConfiguration;

import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.security.auth.x500.X500Principal;

import okhttp3.OkHttpClient;

/**
 * 系统全局application
 */
public class MyApplication extends Application {
    private static Context appContext;
    public static MyApplication instance;
    private Bitmap screenShot;
    String TAG = "MyApplication";
    public static RequestQueue queue;//app全局的请求队列
    OkHttpClient client;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        instance = this;
        //实例化请求队列,放在oncreate里,全局只会有一个。
        queue = Volley.newRequestQueue(getApplicationContext());
        Log.e(TAG,"签名的哈希地址sign====="+this.checkAPP(this));
        //debg版本，数据库不加密
        if (isDebuggable(getApplicationContext())) {
            Constant.SQLPWD = "";
        } else {
            //release版本,数据库加密
            Constant.SQLPWD = "quantonghejiaoyu";
        }

        //在这里为应用设置异常处理程序，然后我们的程序才能捕获未处理的异常
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        Log.e(TAG,"Android SDK平台获取高唯一性设备识别码:"
                +Settings.Secure.getString(appContext.getContentResolver(), "android_id"));


        QrScanConfiguration configuration = new QrScanConfiguration.Builder(this)
                .setTitleHeight(53)
                .setTitleText("来扫一扫")
                .setTitleTextSize(18)
                .setTitleTextColor(R.color.white)
                .setTipText("将二维码放入框内扫描~")
                .setTipTextSize(14)
                .setTipMarginTop(40)
                .setTipTextColor(R.color.white)
                .setSlideIcon(R.mipmap.capture_add_scanning)
                .setAngleColor(R.color.white)
                .setMaskColor(R.color.black_80)
                .setScanFrameRectRate((float) 0.8)
                .build();
        QrScan.getInstance().init(configuration);


        boolean debug = BuildConfig.LOG_DEBUG;
        Log.e("Mainactivity","LOG_DEBUG:"+debug);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            for(int i=0;i<Build.SUPPORTED_ABIS.length;i++){
                Log.e("QtsppApplication", "SUPPORTED_ABIS:"+Build.SUPPORTED_ABIS[i]);
            }
        }
    }

    //全局实例
    public static MyApplication getInstance() {
        if (instance == null) {
            instance = new MyApplication();
        }
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    //暴露方法,获得volley的请求队列
    public static RequestQueue getQueue(){
        return queue;
    }
    //截屏
    public void setScreenShot(Bitmap screenShot) {
        this.screenShot = screenShot;
    }

    public Bitmap getScreenShot() {
        return screenShot;
    }

    //位于栈顶的activity
    public String getRunningActivityName() {
        android.app.ActivityManager mActivityManager = (android.app.ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        return mActivityManager.getRunningTasks(1).get(0).topActivity.getClassName();
    }

    //检查apk的哈希值
    public int checkAPP(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(),
                            PackageManager.GET_SIGNATURES);
            Signature[] signs = packageInfo.signatures;
            Signature sign = signs[0];

            int hashcode = sign.hashCode();
            Log.i("test", "hashCode : " + hashcode);
            return hashcode == -82892576 ? 1 : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    //debug默认签名中含有的信息
    private final static X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");

    //判断是否是debug版本，用来数据库加密和log自动判断,true表示debug版本，false表示release版本
    public boolean isDebuggable(Context ctx) {
        boolean debuggable = false;
        try {
            PackageInfo pinfo = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(), PackageManager.GET_SIGNATURES);
            Signature signatures[] = pinfo.signatures;
            for (int i = 0; i < signatures.length; i++) {
                CertificateFactory cf = CertificateFactory.getInstance("X.509");
                ByteArrayInputStream stream = new ByteArrayInputStream(signatures[i].toByteArray());
                X509Certificate cert = (X509Certificate) cf.generateCertificate(stream);
                // 判断是否含有debug默认的签名信息
                debuggable = cert.getSubjectX500Principal().equals(DEBUG_DN);
                if (debuggable) {
                    break;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
        } catch (CertificateException e) {
            e.printStackTrace();
        }
        return debuggable;
    }


}
