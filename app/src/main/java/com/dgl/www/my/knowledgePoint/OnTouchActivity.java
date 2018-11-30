package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.dgl.www.my.R;

public class OnTouchActivity extends Activity {
	//声明TextView、ImageView对象
	private TextView  tvInfo=null;
	private ImageView ivwPicture=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ontouch);
		//获取TextView、ImageView对象
		tvInfo=(TextView)super.findViewById(R.id.info);
		ivwPicture=(ImageView)super.findViewById(R.id.picture);
		//注册OnTouch监听器
		ivwPicture.setOnTouchListener(new PicOnTouchListener());
	}
	//OnTouch监听器
	private class PicOnTouchListener implements OnTouchListener{
		@Override
		public boolean onTouch(View v, MotionEvent event){			
			//event.getX获取X坐标；event.getY()获取Ｙ坐标
			String sInfo="getX="+String.valueOf(event.getX())+"  getY="+String.valueOf(event.getY());
			String sInfoRaw="RawX="+String.valueOf(event.getRawX())+"  RawY="+String.valueOf(event.getRawY());
			tvInfo.setText(sInfo+"\r\n"+sInfoRaw);
			return true;
		}
	}	
}
