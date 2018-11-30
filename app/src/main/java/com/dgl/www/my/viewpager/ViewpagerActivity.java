package com.dgl.www.my.viewpager;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.dgl.www.my.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 16/6/25.
 */
public class ViewpagerActivity extends Activity {
    /**
     *
     * 数据源
     * adapter
     * viewpager
     */

    private List<View> viewList;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pageradapter);
        viewPager= (ViewPager) findViewById(R.id.pager);

        viewList= new ArrayList<>();

        //通过view队形作为viewpager的数据源
        View view1 = View.inflate(this, R.layout.view1,null);
        View view2 = View.inflate(this, R.layout.view2,null);
        View view3 = View.inflate(this, R.layout.view3,null);
        View view4 = View.inflate(this, R.layout.view4,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        //创建适配器
        MyPagerAdapter adapter = new MyPagerAdapter(viewList);

        if(viewPager==null)
        {
            Log.d("dgl", "viewPager null");

        }
        viewPager.setAdapter(adapter);


    }
}
