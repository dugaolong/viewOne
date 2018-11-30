package com.dgl.www.my.recycleView;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dgl.www.my.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 16/8/21.
 * adapter
 * datas
 * recycleview
 */
public class StaggaredRecycleView extends Activity {
    private RecyclerView mRecycleview;
    private List<String> mDatas;
    private StaggearedRecycleAdapter mRecycleAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        initDatas();
        initViews();
        mRecycleAdapter = new StaggearedRecycleAdapter(this, mDatas);
        mRecycleview.setAdapter(mRecycleAdapter);
        //设置布局管理
        mRecycleview.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //设置分割线
//        mRecycleview.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
    }

    private void initViews() {
        mRecycleview = (RecyclerView) findViewById(R.id.id_recycleview);
    }

    private void initDatas() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add((char) i + "");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recycle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_listview:
                Toast.makeText(this, "list", Toast.LENGTH_LONG).show();
                //设置布局管理
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                mRecycleview.setLayoutManager(linearLayoutManager);
                break;
            case R.id.menu_gridview:
                Toast.makeText(this, "grid", Toast.LENGTH_LONG).show();
                //设置布局管理
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
                mRecycleview.setLayoutManager(gridLayoutManager);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
