package com.dgl.www.my.materialDesign;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.dgl.www.my.R;
import com.dgl.www.my.base.BaseActivity;
import com.dgl.www.my.recycleView.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 17/3/3.
 *
 */

public class CartViewActivity extends BaseActivity {
    private RecyclerView mRecycleview;
    private List<String> mDatas;
    private RecycleMdAdapter mRecycleAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private int ii = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_recycle_view);
        mRecycleAdapter = new RecycleMdAdapter(this, mDatas);
        mRecycleview.setAdapter(mRecycleAdapter);
        mRecycleAdapter.setOnItemClickListener(new RecycleMdAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Toast.makeText(mContext, position + "", Toast.LENGTH_SHORT).show();
            }
        });

        FullyLinearLayoutManager linearLayoutManager = new FullyLinearLayoutManager(this);
        mRecycleview.setNestedScrollingEnabled(false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        //设置布局管理器
        mRecycleview.setLayoutManager(linearLayoutManager);


    }

    @Override
    protected void findWidgets() {
        mRecycleview = (RecyclerView) findViewById(R.id.id_recycleview);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refrash);
        //进度条的颜色
        swipeRefreshLayout.setColorSchemeResources(R.color.app_theme_color1,R.color.app_theme_color2,R.color.app_theme_color);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrashData();
            }


        });
    }

    private void refrashData() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        mRecycleAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    @Override
    protected void initComponent() {
        mDatas = new ArrayList<String>();
        initData();
    }

    private void initData() {
        ii++;
        mDatas.clear();
        for (int i = 0; i <= 30; i++) {
            mDatas.add( i + ii+"");
        }
    }

    @Override
    protected void getIntentData() {

    }
}
