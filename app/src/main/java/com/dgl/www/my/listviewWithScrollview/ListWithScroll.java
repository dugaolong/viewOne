package com.dgl.www.my.listviewWithScrollview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.dgl.www.my.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 17/12/11.
 */

public class ListWithScroll extends Activity {

    private NoScrollListView scrollListView;
    private List<String> data = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.list_with_scroll);
        scrollListView = (NoScrollListView) findViewById(R.id.noScrollListView);
        //要显示的数据
        data.add("11111111111111111111111");
        data.add("22222222222222222222222");
        data.add("3333333333333333333333");
        data.add("4444444444444444444444444");
        data.add("5555555555555555555555555");
        data.add("566666666666666666666666");
        data.add("7777777777777777777777777");
        data.add("88888888888888888888888888");
        data.add("9999999999999999999999999");
        data.add("101010101010101010101010101");
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1, data);
        scrollListView.setAdapter(adapter);
    }


}