package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dgl.www.my.R;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dugaolong on 16/8/15.
 */
public class ShowHtml extends Activity {
    private String html;
    private TextView tv;
    private ProgressBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showhtml);
        // 网上找的html数据
        html = "<html><head><title>TextView使用HTML</title></head><body><p><strong>强调</strong></p><p><em>斜体</em></p>"
                + "<p><a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a>学习HTML!</p><p><font color=\"#aabb00\">颜色1"
                + "</p><p><font color=\"#00bbaa\">颜色2</p><h1>标题1</h1><h3>标题2</h3><h6>标题3</h6><p>大于>小于<</p>"
                + "<p>下面是网络图片</p><img src=\"http://223.82.248.230:8886/mobile3/pull/f/ABjiMn\"/>"
                + "<p>下面是网络图片</p><img src=\"http://223.82.248.230:8889/mobile3//upfile/picture//msg/nc/2/2838031/1474338132266_thumb.jpg\"/>"
                + "<p>下面是网络图片</p><img src=\"http://172.16.170.38:8080/mobile3/pull/f/QBjume\"/>"
                + "<p>下面是网络图片</p><img src=\"http://172.16.170.38:8080/mobile3//upfile/picture//msg/cs/2/103046/1474340905233_thumb.jpg\"/></body></html>";

        tv = (TextView) this.findViewById(R.id.tv_html);
        bar = (ProgressBar) this.findViewById(R.id.id_bar);
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());// 滚动
        final MyHandler myHandler = new MyHandler(this);
        Thread t = new Thread(new Runnable() {
            Message msg = Message.obtain();

            @Override
            public void run() {
                bar.setVisibility(View.VISIBLE);
                /**
                 * 要实现图片的显示需要使用Html.fromHtml的一个重构方法：public static Spanned
                 * fromHtml (String source, Html.ImageGetterimageGetter,
                 * Html.TagHandler
                 * tagHandler)其中Html.ImageGetter是一个接口，我们要实现此接口，在它的getDrawable
                 * (String source)方法中返回图片的Drawable对象才可以。
                 */
                Html.ImageGetter imageGetter = new Html.ImageGetter() {

                    @Override
                    public Drawable getDrawable(String source) {
                        URL url;
                        Drawable drawable = null;
                        try {
                            url = new URL(source);
                            drawable = Drawable.createFromStream(
                                    url.openStream(), null);
                            drawable.setBounds(0, 0,
                                    drawable.getIntrinsicWidth(),
                                    drawable.getIntrinsicHeight());
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return drawable;
                    }
                };
                CharSequence test = Html.fromHtml(html, imageGetter, null);
                msg.what = 0x101;
                msg.obj = test;
                myHandler.sendMessage(msg);
            }
        });
        t.start();
    }

    /*
     * Handler
     * 类应该应该为static类型，否则有可能造成泄露。在程序消息队列中排队的消息保持了对目标Handler类的应用。如果Handler是个内部类，那
     * 么它也会保持它所在的外部类的引用。为了避免泄露这个外部类，应该将Handler声明为static嵌套类，并且使用对外部类的弱应用。
     */
    private static class MyHandler extends Handler {
        WeakReference<ShowHtml> mActivity;
        public MyHandler(ShowHtml activity) {
            mActivity = new WeakReference<ShowHtml>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            ShowHtml theActivity = mActivity.get();
            if (msg.what == 0x101) {
                theActivity.bar.setVisibility(View.GONE);
                theActivity.tv.setText((CharSequence) msg.obj);
            }
            super.handleMessage(msg);
        }
    }
}
