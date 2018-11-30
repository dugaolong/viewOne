package com.dgl.www.my.knowledgePoint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dgl.www.my.R;
import com.dgl.www.my.base.BaseActivity;

/**
 * Created by dugaolong on 17/2/8.
 */

public class WindowManagerActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.windowmanager);

    }

    public void startService(View view){
        Intent intent = new Intent(this,WindowService.class);
        startService(intent);
    }
    public void endService(View view){
        Intent intent = new Intent(this,WindowService.class);
        stopService(intent);
    }

    @Override
    protected void findWidgets() {

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }


}
