package com.dgl.www.my.volley;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by dugaolong on 17/1/3.
 * 作为缓存，肯定有一个缓存的大小，这个大小是可以设定的（自定义sizeOf()）。
 * 当你访问了一个item（需要缓存的对象），这个item应该被加入到内存中，然后移动到一个队列的顶部，
 * 如此循环后这个队列的顶部应该是最近访问的item了，
 * 而队尾部就是很久没有访问的item，这样我们就应该对队尾部的item优先进行回收操作。
 */

public class BitmapCache implements ImageLoader.ImageCache {

    private LruCache<String,Bitmap> cache;
    private int max = 10*1024*1024;//最大缓存大小10M,如果缓存超过10M,会自动回收。
    //构造方法
    public BitmapCache(){
        //实例化cache
        cache = new LruCache<String,Bitmap>(max){
            //sizeOf返回的是你缓存的item的大小
            @Override
            protected int sizeOf(String key, Bitmap value) {
//                return value.getRowBytes() * value.getHeight();//计算每张图片的大小
                return value.getByteCount();//计算每张图片的大小
            }
        };
    }
    //返回缓存里的图片
    @Override
    public Bitmap getBitmap(String s) {
        return cache.get(s);
    }

    //吧图片放进缓存
    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        cache.put(s,bitmap);
    }
}
