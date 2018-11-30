package com.dgl.www.my.materialDesign;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dgl.www.my.R;

import java.util.List;

/**
 * Created by dugaolong on 16/8/21.
 */
public class RecycleMdAdapter extends RecyclerView.Adapter<MdViewHolder> implements View.OnClickListener{

    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;

    public RecycleMdAdapter(Context context, List<String> datas) {
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public void onClick(View view) {
        onItemClickListener.onItemClick(view, (Integer) view.getTag());
    }

    //定义一个回调接口
    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }
    //定义一个接口的变量
    public OnItemClickListener onItemClickListener;
    //暴露对外的方法,提供实现者调用
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    //创建itemview
    @Override
    public MdViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recycle_item,parent,false);
        view.setOnClickListener(this);
        MdViewHolder viewHolder = new MdViewHolder(view);
        return viewHolder;
    }

    //item和data绑定
    @Override
    public void onBindViewHolder(MdViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
        holder.itemView.setTag(position);
    }

    //数据总个数
    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}

class MdViewHolder extends RecyclerView.ViewHolder {

    TextView tv;
    //初始化item中的控件
    public MdViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.id_tv);
    }
}
