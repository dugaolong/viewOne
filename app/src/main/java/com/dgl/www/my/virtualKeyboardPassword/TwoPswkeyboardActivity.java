package com.dgl.www.my.virtualKeyboardPassword;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 17/10/18.
 */

public class TwoPswkeyboardActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_pswkeyboard);
    }

    public void toNormalKeyBoard(View view) {
        startActivity(new Intent(this, NormalKeyBoardActivity.class));
    }

    public void toPayKeyBoard(View view) {
        startActivity(new Intent(this, PaymentKeyBoardActivity.class));
    }

}
