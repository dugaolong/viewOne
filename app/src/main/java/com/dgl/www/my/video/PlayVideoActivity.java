package com.dgl.www.my.video;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.dgl.www.my.R;

import static com.dgl.www.my.R.id.video_view;

/**
 * Created by dugaolong on 17/5/10.
 */

public class PlayVideoActivity extends Activity implements View.OnClickListener{

    private VideoView mVideoView;
    private Button play,pause,replay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_video);


        initVideo();
        initView();

    }

    private void initVideo() {
        mVideoView = (VideoView) findViewById(video_view);
//        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome));
        mVideoView.setVideoURI(Uri.parse("http://47.94.152.182:8080/guangchangan/userControl/r_dyt.mp4"));

        mVideoView.requestFocus();
        mVideoView.start();

    }

    private void initView() {
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        replay = (Button) findViewById(R.id.replay);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        replay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                if(!mVideoView.isPlaying()){
                    mVideoView.start();
                }
                break;
            case R.id.pause:
                if(mVideoView.isPlaying()){
                    mVideoView.pause();
                }
                break;
            case R.id.replay:
                if(!mVideoView.isPlaying()){
                    mVideoView.resume();
                }
                break;
        }
    }

    @Override
    protected void onPause() {
        mVideoView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        mVideoView.resume();
        super.onResume();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mVideoView!=null){
            mVideoView.stopPlayback();
        }
    }
}
