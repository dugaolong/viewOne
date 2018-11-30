package com.dgl.www.my.expandable;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/7/17.
 */
public class Myexpandable extends Activity {

    public Myadapter adapter;
    public TextView tv_refrash;
    public String[] generalsTypes;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.expandable_layout);
        tv_refrash = (TextView) findViewById(R.id.tv_refrash);
        adapter = new Myadapter(this);

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
        expandableListView.setAdapter(adapter);
//        adapter.setData();
        //设置item点击的监听器
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Toast.makeText(
                        Myexpandable.this,
                        "你点击了" + adapter.getChild(groupPosition, childPosition),
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });


        tv_refrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        Myexpandable.this,
                        "你点击了wowo",
                        Toast.LENGTH_SHORT).show();
//                adapter.setData();
            }
        });
    }


}
