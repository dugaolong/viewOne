package com.dgl.www.my.animations;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.dgl.www.my.MainActivity;
import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/7/31.
 * 帧动画
 */
public class AnimationsActivity extends Activity {

    private AnimationDrawable mImgAnim;//可以加载Drawable资源实现帧动画。
    private AnimationDrawable rotateDrawable;//可以加载Drawable资源实现帧动画。
    private ImageView imageView;
    private ImageView iv_anim_rotate;//旋转动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.animations);
        imageView = (ImageView) findViewById(R.id.iv_animations);
        iv_anim_rotate = (ImageView) findViewById(R.id.iv_anim_rotate);
        mImgAnim = (AnimationDrawable) getResources().getDrawable(R.drawable.fresh);
        imageView.setImageDrawable(mImgAnim);

        //开始动画
        mImgAnim.start();
        //动画执行一次
//        mImgAnim.setOneShot(true);

    }

    public void startAn(View view) {
//
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 270f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(3000);
        rotateAnimation.setRepeatCount(0);
        rotateAnimation.setFillAfter(true);
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.addAnimation(rotateAnimation);
        iv_anim_rotate.startAnimation(rotateAnimation);

//        Animation animation = AnimationUtils.loadAnimation(AnimationsActivity.this,R.anim.anim_rotate);
//        iv_anim_rotate.startAnimation(animation);


    }
}
