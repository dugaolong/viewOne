package com.dgl.www.my.knowledgePoint;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.dgl.www.my.R;
import com.dgl.www.my.base.BaseActivity;
import com.dgl.www.my.utils.ToastUtil;

/**
 * Created by dugaolong on 17/3/6.
 */

public class DialogActivity extends BaseActivity {
    private Context context;
    public static final String TAG = "DialogActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);
        context = this;
        findViewById(R.id.toast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showToast(context,"showToast");
            }
        });
        findViewById(R.id.showToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.myToastShow(context,"myToastShow");
            }
        });
        findViewById(R.id.showTopToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.showTopToast(DialogActivity.this,title,"showTopToast",true);
            }
        });

        Log.d(TAG, "onCreate: ");
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
