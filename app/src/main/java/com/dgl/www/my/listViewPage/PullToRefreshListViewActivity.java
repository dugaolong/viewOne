package com.dgl.www.my.listViewPage;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.dgl.www.my.R;
import com.dgl.www.my.widget.pulltorefresh.PullToRefreshBase;
import com.dgl.www.my.widget.pulltorefresh.PullToRefreshListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 16/9/22.
 */
public class PullToRefreshListViewActivity extends Activity {

    private PullToRefreshListView pulllistview;
    private ListView listview;
    private int refreshFlag = -1;
    public List<String> myArrayList = new ArrayList<String>();
    private int mI = 0;
    private Handler handler;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pulllistview);
        handler = new MyHandler();
        pulllistview = (PullToRefreshListView) findViewById(R.id.pulltorefresh_listview);
        pulllistview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                // 下拉的时候数据重置
                refreshFlag = 0;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            handler.sendEmptyMessage(refreshFlag);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                // 上拉的时候添加选项
                refreshFlag = 1;
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            handler.sendEmptyMessage(refreshFlag);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });

                thread.start();
            }
        });
        pulllistview.setMode(PullToRefreshBase.Mode.BOTH);
        listview = pulllistview.getRefreshableView();
        loadData();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myArrayList);
        listview.setAdapter(arrayAdapter);
    }

    private void complate() {
        //调用onRefreshComplete方法去,停止刷新操作
        pulllistview.onRefreshComplete();
    }

    private void loadData() {
        for (int i = mI; i < 16; i++) {
            myArrayList.add("ssssssssssssssss数据" + i);
            mI = i;
        }
    }

    class MyHandler extends Handler {
        public MyHandler() {
        }

        public MyHandler(Looper L) {
            super(L);
        }

        // 子类必须重写此方法，接受数据
        @Override
        public void handleMessage(Message msg) {
            Log.d("MyHandler", "handleMessage。。。。。。");
            super.handleMessage(msg);
            if (msg.what == 0) {
//                    Thread.sleep(2000);
                myArrayList.add(0, "pull top");
                arrayAdapter.notifyDataSetChanged();
                complate();
            }
            if (msg.what == 1) {
                myArrayList.add("pull bottom");
                arrayAdapter.notifyDataSetChanged();
                complate();
            }
        }
    }
}
