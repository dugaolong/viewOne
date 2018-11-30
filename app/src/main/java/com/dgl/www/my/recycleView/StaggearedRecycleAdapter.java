package com.dgl.www.my.recycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dgl.www.my.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 16/8/21.
 */
public class StaggearedRecycleAdapter extends RecyclerView.Adapter<StaggearedRecycleAdapter.MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    private List<Integer> mHeights;

    public StaggearedRecycleAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(mContext);
        //随机生成item的高度
        mHeights = new ArrayList<Integer>();
        for(int i = 0;i<mDatas.size();i++){
            mHeights.add((int)(100+Math.random()*400));
        }
    }

    //创建itemview
    @Override
    public StaggearedRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycle_item,parent,false);
        StaggearedRecycleAdapter.MyViewHolder viewHolder = new StaggearedRecycleAdapter.MyViewHolder(view);
        return viewHolder;
    }

    //item和data绑定
    @Override
    public void onBindViewHolder(StaggearedRecycleAdapter.MyViewHolder holder, int position) {
        //设置动态的item的高度
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));
    }

    //数据总个数
    @Override
    public int getItemCount() {
        return mDatas.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        //初始化item中的控件
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.id_tv);
        }
    }
}

