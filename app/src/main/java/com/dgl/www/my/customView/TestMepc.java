package com.dgl.www.my.customView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.dgl.www.my.utils.ToastUtil;

/**
 * Created by dugaolong on 17/12/1.
 */

public class TestMepc extends View {


    public Context context;
    public TestMepc(Context context) {
        super(context);
    }

    public TestMepc(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //宽度
        String widthmode ="";
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        switch (widthMode){
            case MeasureSpec.AT_MOST:
                widthmode ="MeasureSpec.AT_MOST";
                break;
            case MeasureSpec.EXACTLY:
                widthmode ="MeasureSpec.EXACTLY";
                break;
            case MeasureSpec.UNSPECIFIED:
                widthmode ="MeasureSpec.UNSPECIFIED";
                break;
        }
        //宽度
        String heightmode ="";
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        switch (heightMode){
            case MeasureSpec.AT_MOST:
                heightmode ="MeasureSpec.AT_MOST";
                break;
            case MeasureSpec.EXACTLY:
                heightmode ="MeasureSpec.EXACTLY";
                break;
            case MeasureSpec.UNSPECIFIED:
                heightmode ="MeasureSpec.UNSPECIFIED";
                break;
        }

        ToastUtil.showToast(context.getApplicationContext(),"widthmode: "+widthmode+"\nheightmode: "+heightmode);
    }
}
