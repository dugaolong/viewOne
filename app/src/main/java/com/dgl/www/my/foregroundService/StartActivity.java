package com.dgl.www.my.foregroundService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 19/1/17.
 */

public class StartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_foreground_activity);

    }

    public void startForegroundService(View view) {
        startService(new Intent(this,ForegroundService.class));
    }
}
