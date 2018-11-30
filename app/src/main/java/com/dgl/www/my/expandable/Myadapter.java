package com.dgl.www.my.expandable;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dgl.www.my.R;

/**
 * Created by dugaolong on 16/7/17.
 */
public class Myadapter extends BaseExpandableListAdapter {
    public Context mContext;
    Myadapter(Context context) {
        mContext= context;
    }

    //设置组视图的图片
    int[] logos = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    //设置组视图的显示文字
    String[] generalsTypes = new String[]{"家人", "同事", "朋友"};

    //子视图显示文字
    private String[][] generals = new String[][]{
            {"李xx", "李xx", "李xx", "李xx", "李xx", "李xx"},
            {"王小二", "王小二", "王小二", "王小二", "王小二", "王小二"},
            {"张小三", "张小三", "张小三", "张小三", "张小三"}

    };
    //子视图图片
    public int[][] generallogos = new int[][]{
            {R.drawable.aaa, R.drawable.aaa,
                    R.drawable.aaa, R.drawable.aaa,
                    R.drawable.aaa, R.drawable.aaa},
            {R.drawable.bbb, R.drawable.bbb,
                    R.drawable.bbb, R.drawable.bbb,
                    R.drawable.bbb, R.drawable.bbb},
            {R.drawable.ccc, R.drawable.ccc, R.drawable.ccc,
                    R.drawable.ccc, R.drawable.ccc}};

    //自己定义一个获得文字信息的方法
    TextView getTextView() {
        AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.FILL_PARENT, 64);
        TextView textView = new TextView(
                mContext);
        textView.setLayoutParams(lp);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        textView.setPadding(36, 0, 0, 0);
        textView.setTextSize(20);
        textView.setTextColor(Color.BLACK);
        return textView;
    }


    //重写ExpandableListAdapter中的各个方法
    public int getGroupCount() {
        return generalsTypes.length;
    }

    public Object getGroup(int groupPosition) {
        return generalsTypes[groupPosition];
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public int getChildrenCount(int groupPosition) {
        return generals[groupPosition].length;
    }

    public Object getChild(int groupPosition, int childPosition) {
        return generals[groupPosition][childPosition];
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        LinearLayout ll = new LinearLayout(
                mContext);
        ll.setOrientation(0);
        ImageView logo = new ImageView(mContext);
        logo.setImageResource(logos[groupPosition]);
        logo.setPadding(50, 10, 0, 0);
        ll.addView(logo);
        TextView textView = getTextView();
        textView.setTextColor(Color.BLACK);
        textView.setText(getGroup(groupPosition).toString());
        ll.addView(textView);

        return ll;
    }

    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        LinearLayout ll = new LinearLayout(
                mContext);
        ll.setOrientation(0);
        ImageView generallogo = new ImageView(
                mContext);
        generallogo
                .setImageResource(generallogos[groupPosition][childPosition]);
        generallogo.setPadding(50, 10, 0, 0);
        ll.addView(generallogo);
        TextView textView = getTextView();
        textView.setText(getChild(groupPosition, childPosition)
                .toString());
        ll.addView(textView);
        return ll;
    }

    public boolean isChildSelectable(int groupPosition,
                                     int childPosition) {
        return true;
    }

    public void setData() {
        generalsTypes = new String[]{"家人1", "同事1", "朋友1"};
    }

}
