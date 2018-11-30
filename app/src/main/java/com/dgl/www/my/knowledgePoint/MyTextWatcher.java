package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 18/5/11.
 */

public class MyTextWatcher extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.textwatcher);

        EditText editText = (EditText) findViewById(R.id.edittext);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(MyTextWatcher.this,"before:"+s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Toast.makeText(MyTextWatcher.this,"on:"+s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                Toast.makeText(MyTextWatcher.this,"after:"+s,Toast.LENGTH_LONG).show();
            }
        });

    }
}
