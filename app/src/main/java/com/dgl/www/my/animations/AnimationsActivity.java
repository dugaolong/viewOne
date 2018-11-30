package com.dgl.www.my.animations;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/7/31.
 * 帧动画
 */
public class AnimationsActivity extends Activity {

    private AnimationDrawable mImgAnim;//可以加载Drawable资源实现帧动画。
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animations);
        imageView = (ImageView) findViewById(R.id.iv_animations);
        mImgAnim = (AnimationDrawable) getResources().getDrawable(R.anim.fresh);
        imageView.setImageDrawable(mImgAnim);

        //开始动画
        mImgAnim.start();
        //动画执行一次
//        mImgAnim.setOneShot(true);


    }
}
