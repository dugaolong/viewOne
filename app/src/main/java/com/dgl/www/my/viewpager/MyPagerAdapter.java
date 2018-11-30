package com.dgl.www.my.viewpager;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dugaolong on 16/6/25.
 */
public class MyPagerAdapter extends PagerAdapter {

    private List<View> viewList;
    public MyPagerAdapter(List<View> viewList){
        this.viewList = viewList;
        Log.i("dgl",viewList.size()+"");
    }

    //返回页面的数量（页卡）
    @Override
    public int getCount() {
        return viewList.size();
    }

    //判断view是否来自于对象
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //实例化一个页卡
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        return super.instantiateItem(container, position);
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    //销毁一个页卡
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        container.removeView(viewList.get(position));
    }

}
