package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.dgl.www.my.R;
import com.dgl.www.my.utils.AsynImageLoader;

public class ImageActivity extends Activity {


    //定义一个图片显示控件
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);

        //图片资源
        String url1 = "http://223.82.248.230:8886/mobile3/pull/f/ABjiMn";
        String url2 = "http://223.82.248.230:8889/mobile3//upfile/picture//msg/nc/2/2838031/1474338132266_thumb.jpg";
        String url3 = "http://172.16.170.38:8080/mobile3/pull/f/QBjume";
        String url4 = "http://172.16.170.38:8080/mobile3//upfile/picture//msg/cs/2/103046/1474340905233_thumb.jpg";
        //得到可用的图片
//        Bitmap bitmap1 = getHttpBitmap(url1);
//        Bitmap bitmap2 = getHttpBitmap(url2);
//        Bitmap bitmap3 = getHttpBitmap(url3);
//        Bitmap bitmap4 = getHttpBitmap(url4);
        imageView1 = (ImageView)this.findViewById(R.id.image1);
        imageView2 = (ImageView)this.findViewById(R.id.image2);
        imageView3 = (ImageView)this.findViewById(R.id.image3);
        imageView4 = (ImageView)this.findViewById(R.id.image4);
        //显示
        new AsynImageLoader().showImageAsyn(imageView1,url1,R.drawable.person_face_img);
        new AsynImageLoader().showImageAsyn(imageView2,url2,R.drawable.person_face_img);
        new AsynImageLoader().showImageAsyn(imageView3,url3,R.drawable.person_face_img);
        new AsynImageLoader().showImageAsyn(imageView4,url4,R.drawable.person_face_img);
//        imageView1.setImageBitmap(bitmap1);
//        imageView2.setImageBitmap(bitmap2);
//        imageView3.setImageBitmap(bitmap3);
//        imageView4.setImageBitmap(bitmap4);

    }

}