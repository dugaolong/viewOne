package com.dgl.www.my.ThreeLink.month;

import android.content.res.AssetManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.dgl.www.my.ThreeLink.widget.WheelView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Administrator on 2016/6/7 0007.
 * 选择 年 月 
 */
public class YearMonthActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * 与选择年相关
     */
    protected ArrayList<String> mYearDatas;
    protected Map<String, ArrayList<String>> mMonthsDatasMap = new HashMap<String, ArrayList<String>>();
    protected String mCurrentYearName;
    protected String mCurrentMonthName;

    private View contentView;
    private PopupWindow addrPopWindow;
    private WheelView mYearPicker;
    private WheelView mMonthPicker;
    private LinearLayout boxBtnCancel;
    private LinearLayout boxBtnOk;
    protected boolean isDataLoaded = false;
    /**
     *  选择地址
     */
    private LinearLayout ll_select_month;
    private TextView tv_year;
    private LinearLayout rootview;
    private boolean isAddrChoosed = false;

    /**
     *  其他控件
     */

    private EditText et_detail_address;
    private boolean isUpdate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_month);
        initView();
    }



    public void initView() {
        ll_select_month=(LinearLayout)findViewById(R.id.ll_select_month);
        tv_year=(TextView)findViewById(R.id.tv_year);
        ll_select_month.setOnClickListener(YearMonthActivity.this);
        rootview=(LinearLayout)findViewById(R.id.root_view);
        et_detail_address=(EditText)findViewById(R.id.et_detail_address);
        initYearSelectView();
    }


    private void  initYearSelectView(){

        contentView = LayoutInflater.from(this).inflate(
                R.layout.picker_month, null);
        mYearPicker = (WheelView) contentView.findViewById(R.id.year);
        mMonthPicker = (WheelView) contentView.findViewById(R.id.month);
        boxBtnCancel = (LinearLayout) contentView.findViewById(R.id.box_btn_cancel);
        boxBtnOk = (LinearLayout) contentView.findViewById(R.id.box_btn_ok);


        addrPopWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        //addrPopWindow.setBackgroundDrawable(new ColorDrawable(0xffffff));
        addrPopWindow.setBackgroundDrawable(new BitmapDrawable());
        mYearPicker.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                String yearText = mYearDatas.get(id);
                if (!mCurrentYearName.equals(yearText)) {
                    mCurrentYearName = yearText;
                    ArrayList<String> mMonthData = mMonthsDatasMap.get(mCurrentYearName);
                    mMonthPicker.resetData(mMonthData);
                    mMonthPicker.setDefault(0);
                    mCurrentMonthName = mMonthData.get(0);

                }
            }

            @Override
            public void selecting(int id, String text) {
            }
        });

        mMonthPicker.setOnSelectListener(new WheelView.OnSelectListener() {
            @Override
            public void endSelect(int id, String text) {
                ArrayList<String> mMonthData = mMonthsDatasMap.get(mCurrentYearName);
                String MonthText = mMonthData.get(id);
                if (!mCurrentMonthName.equals(MonthText)) {
                    mCurrentMonthName = MonthText;
                }
            }

            @Override
            public void selecting(int id, String text) {

            }
        });

        boxBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addrPopWindow.dismiss();
            }
        });

        boxBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAddrChoosed = true;
                String addr = mCurrentYearName + mCurrentMonthName;
                tv_year.setText(addr);
                addrPopWindow.dismiss();
            }
        });

        // 启动线程读取数据
        new Thread() {
            @Override
            public void run() {
                // 读取数据
                isDataLoaded = readMonthDatas();

                // 通知界面线程
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        mYearPicker.setData(mYearDatas);
                        mYearPicker.setDefault(0);
                        mCurrentYearName = mYearDatas.get(0);

                        ArrayList<String> mMonthData = mMonthsDatasMap.get(mCurrentYearName);
                        mMonthPicker.setData(mMonthData);
                        mMonthPicker.setDefault(0);
                        mCurrentMonthName = mMonthData.get(0);

                    }
                });
            }
        }.start();

    }


    @Override
    public void onClick(View v)
    {
        switch (v.getId()){

            case R.id.ll_select_month:
//                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                if (isDataLoaded)
                    addrPopWindow.showAtLocation(rootview, Gravity.CENTER_VERTICAL, 0, 0);
                else
                    //toast("加载数据失败，请稍候再试！");
                break;

                break;
        }
    }




    /**
     * 读取地址数据，请使用线程进行调用
     *
     * @return
     */
    protected boolean readMonthDatas() {
        List<YearInfoModel> yearList = null;
        AssetManager asset = getAssets();
        try {
            InputStream input = asset.open("month_data.xml");
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            MonthXmlParser handler = new MonthXmlParser();
            parser.parse(input, handler);
            input.close();
            yearList = handler.getDataList();
            if (yearList != null && !yearList.isEmpty()) {
                mCurrentYearName = yearList.get(0).getName();
                List<MonthInfoModel> MonthList = yearList.get(0).getMonthList();
                if (MonthList != null && !MonthList.isEmpty()) {
                    mCurrentMonthName = MonthList.get(0).getName();
//                  MonthList.get(0).getZipcode();
                }
            }
            mYearDatas = new ArrayList<String>();
            for (int i = 0; i < yearList.size(); i++) {
                mYearDatas.add(yearList.get(i).getName());
                List<MonthInfoModel> MonthList = yearList.get(i).getMonthList();
                ArrayList<String> MonthNames = new ArrayList<String>();
                for (int j = 0; j < MonthList.size(); j++) {
                    MonthNames.add(MonthList.get(j).getName());
                }
                mMonthsDatasMap.put(yearList.get(i).getName(), MonthNames);
            }
            return true;
        } catch (Throwable e) {
            e.printStackTrace();
            return false;
        }
    }



}
