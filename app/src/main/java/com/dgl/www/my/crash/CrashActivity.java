package com.dgl.www.my.crash;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.dgl.www.my.R;

public class CrashActivity extends Activity implements OnClickListener {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
        initView();
    }

    private void initView() {
        mButton = (Button)findViewById(R.id.button1);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mButton) {
            try{
                int aaa= 4/0;
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
            //在这里默认异常抛出情况，人为抛出一个运行时异常
            throw new RuntimeException("自定义异常：这是自己抛出的异常");
        }
        
    }
}
