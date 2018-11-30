package com.dgl.www.my.customView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 17/12/1.
 */

public class TestMepcActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.test_spec);
        //输出一个int的二进制数
        ((TextView)findViewById(R.id.tv)).setText(
                "AT_MOST: \nInteger.toBinaryString(2 << 30)\n=="+Integer.toBinaryString(2 << 30)+
                "\n\nEXACTLY: \nInteger.toBinaryString(1 << 30)\n=="+Integer.toBinaryString(1 << 30)+
                "\n\nUNSPECIFIED: \nInteger.toBinaryString(1 << 30)\n=="+Integer.toBinaryString(0 << 30));
    }

    public void wrap_content(View view) {
        startActivity(new Intent(this, MepcWrapActivity.class));
    }

    public void match_parent(View view) {
        startActivity(new Intent(this, MepcMatchActivity.class));
    }

    public void oneoo(View view) {
        startActivity(new Intent(this, MepcOneooActivity.class));
    }
}
