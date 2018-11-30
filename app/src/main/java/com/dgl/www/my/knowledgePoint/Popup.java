package com.dgl.www.my.knowledgePoint;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/7/4.
 */
public class Popup extends Activity implements View.OnClickListener{

    private PopupWindow popupWindow; // 活动窗口
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showPo(view);
//            }
//        });
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    private void showPo(View v) {
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.homework_teacher_title_popup, null);

        TextView aaaa = (TextView) view.findViewById(R.id.aaaa);
        TextView bbb = (TextView) view.findViewById(R.id.bbb);
        TextView ccc = (TextView) view.findViewById(R.id.ccc);


        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setAnimationStyle(R.style.AnimationPreview);
        popupWindow.showAsDropDown(v, -200, 0);

    }

    @Override
    public void onClick(View view) {
        showPo(view);
    }
}
