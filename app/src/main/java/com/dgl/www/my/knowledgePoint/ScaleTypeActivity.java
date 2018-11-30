package com.dgl.www.my.knowledgePoint;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.dgl.www.my.base.BaseActivity;
import com.dgl.www.my.utils.DeviceUtil;

/**
 * Created by dugaolong on 16/8/18.
 */
public class ScaleTypeActivity extends BaseActivity implements View.OnClickListener {
    /**
     * 每一项的高度(px)
     */
    private static float POPUP_ITEM_HEIGHT = 30f;
    private static PopupWindow popupWindow;
    public static ImageView imageView;
    TextView FIT_XY,
            FIT_START,
            FIT_CENTER,
            FIT_END,
            CENTER,
            CENTER_CROP,
            CENTER_INSIDE,
            MATRIX;

    @Override
    protected void findWidgets() {
        tv_right_text.setVisibility(View.VISIBLE);

    }

    @Override
    protected void initComponent() {

    }

    @Override
    protected void getIntentData() {

    }

    @Override
    protected void initListener() {
        tv_right_text.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scale_type);
        imageView = (ImageView) findViewById(R.id.im_scaleType);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);//QUAN
//        imageView.setScaleType(ImageView.ScaleType.FIT_START);
//        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
//        imageView.setScaleType(ImageView.ScaleType.FIT_END);
//        imageView.setScaleType(ImageView.ScaleType.CENTER);//QUAN
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//QUAN
//        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
//        imageView.setScaleType(ImageView.ScaleType.MATRIX);//QUAN


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_right_text) {
            popupWindow = createPopupView(this, view);
            popupWindow.showAsDropDown(view, -160, 8);// 显示
        } else if (view.getId() == R.id.FIT_XY) {
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);//QUAN
            popupWindow.dismiss();
        } else if (view.getId() == R.id.FIT_START) {
            imageView.setScaleType(ImageView.ScaleType.FIT_START);//QUAN
            popupWindow.dismiss();
        } else if (view.getId() == R.id.FIT_CENTER) {
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);//QUAN
            popupWindow.dismiss();
        } else if (view.getId() == R.id.FIT_END) {
            imageView.setScaleType(ImageView.ScaleType.FIT_END);//QUAN
            popupWindow.dismiss();
        } else if (view.getId() == R.id.CENTER) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);//QUAN
            popupWindow.dismiss();
        } else if (view.getId() == R.id.CENTER_CROP) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//QUAN
            popupWindow.dismiss();
        } else if (view.getId() == R.id.CENTER_INSIDE) {
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);//QUAN
            popupWindow.dismiss();
        } else if (view.getId() == R.id.MATRIX) {
            imageView.setScaleType(ImageView.ScaleType.MATRIX);//QUAN
            popupWindow.dismiss();
        }

    }

    /**
     * 初始化popupwindow
     *
     * @param mContext
     * @return
     * @author hexiaodong
     */
    public PopupWindow createPopupView(Context mContext, View view) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.popup_window_view_more, null);
        FIT_XY = (TextView) layout.findViewById(R.id.FIT_XY);
        FIT_START = (TextView) layout.findViewById(R.id.FIT_START);
        FIT_CENTER = (TextView) layout.findViewById(R.id.FIT_CENTER);
        FIT_END = (TextView) layout.findViewById(R.id.FIT_END);
        CENTER = (TextView) layout.findViewById(R.id.CENTER);
        CENTER_CROP = (TextView) layout.findViewById(R.id.CENTER_CROP);
        CENTER_INSIDE = (TextView) layout.findViewById(R.id.CENTER_INSIDE);
        MATRIX = (TextView) layout.findViewById(R.id.MATRIX);

        CENTER_INSIDE.setOnClickListener(this);
        FIT_XY.setOnClickListener(this);
        FIT_START.setOnClickListener(this);
        FIT_CENTER.setOnClickListener(this);
        FIT_END.setOnClickListener(this);
        CENTER.setOnClickListener(this);
        CENTER_CROP.setOnClickListener(this);
        CENTER_INSIDE.setOnClickListener(this);
        MATRIX.setOnClickListener(this);
        int mItemHeight = DeviceUtil.dip2px(mContext, POPUP_ITEM_HEIGHT);
        popupWindow = new PopupWindow(layout);
        popupWindow.setWidth(600);
        popupWindow.setHeight(mItemHeight*8+60);
        popupWindow.setOutsideTouchable(true);

        return popupWindow;
    }
}
