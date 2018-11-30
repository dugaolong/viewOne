package com.dgl.www.my.listViewPage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.dgl.www.my.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 上拉刷新
 * 下拉刷新
 *
 */
public class ListFrashActivity extends Activity implements AbsListView.OnScrollListener {

    protected static final String TAG="ListFrashActivity";

    public boolean isLastItem = false;//是否滑到底部
    public LinearLayout ll;
    public List<String> myArrayList;
    public ArrayAdapter<String> myArrayAdapter;
    private int mI=0;
    RefreshableView refreshableView;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            //加载新数据
            loadMoreData();
            myArrayAdapter.notifyDataSetChanged();
            return false;
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listactivity_layout);
        View view  = getLayoutInflater().inflate(R.layout.footer,null);
        ll = (LinearLayout) view.findViewById(R.id.ll);
        ListView listview = (ListView) findViewById(R.id.listview);
        myArrayList = new ArrayList<>();
        loadData();
        myArrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myArrayList);
        //注意在setAdapter之前添加
        listview.addFooterView(view);
        ll.setVisibility(View.GONE);
        listview.setAdapter(myArrayAdapter);
        listview.setOnScrollListener(this);
        refreshableView = (RefreshableView) findViewById(R.id.refreshable_view);
        refreshableView.setOnRefreshListener(new RefreshableView.PullToRefreshListener() {
            @Override
            public void onRefresh() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                refreshableView.finishRefreshing();
            }
        }, 0);
    }

    //滑动

    /**
     * absListView
     * @param absListView
     * @param scrollState 0:屏幕停止滚动；1：屏幕滚动中并且手指还在屏幕上；2：屏幕惯性滑动中
     */
    @Override
    public void onScrollStateChanged(AbsListView absListView, int scrollState) {
        Log.i("dgl","scrollState:" + scrollState);
        if(scrollState == 0){//屏幕停止滚动
            if(isLastItem){
                //显示底部view
                ll.setVisibility(View.VISIBLE);
                Thread t = new Thread(new Runnable(){
                    public void run(){
                        try {
                            Thread.sleep(2000);
//                            System.out.print("    线程睡眠2秒！\n");
                            Log.i(TAG,"    线程睡眠2秒！\n");
                            handler.sendEmptyMessage(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }});
                t.start();
                isLastItem = false;
            }
        }
    }



    /**
     * @param absListView
     * @param firstVisibleItem 当前屏幕显示的第一个listitem的位置在整个items的
     * @param visibleItemCount
     * @param totalItemCount
     */
    //滑动过程中
    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        Log.i("dgl","***firstParamInt:" + firstVisibleItem);
        Log.i("dgl","***visibleItemCount:" + visibleItemCount);
        Log.i("dgl","***totalItemCount:" + totalItemCount);
        //到达底部
        if(firstVisibleItem + visibleItemCount == totalItemCount){
            isLastItem = true;
        }
    }

    private void loadData() {
        for(int i = mI;i<16;i++){
            myArrayList.add("ssssssssssssssss数据"+i);
            mI=i;
        }

    }
    private void loadMoreData() {
        for(int i = mI+1;i<mI+5;i++){
            myArrayList.add("ssssssssssssssss数据"+i);
        }
        mI+=4;
    }


}
