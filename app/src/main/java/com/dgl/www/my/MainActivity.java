/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dgl.www.my;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dgl.www.my.Contacts.ContactsSortKey;
import com.dgl.www.my.ThreeLink.ThreeLinkActivity;
import com.dgl.www.my.base.BaseActivity;
import com.dgl.www.my.camera2.Camera2Activity;
import com.dgl.www.my.crash.CrashActivity;
import com.dgl.www.my.customView.ColorMatrixActivity;
import com.dgl.www.my.customView.TestMepcActivity;
import com.dgl.www.my.customView.ThemometerActivity;
import com.dgl.www.my.customView.Thermometer;
import com.dgl.www.my.customView.ViewOneActivity;
import com.dgl.www.my.customView.animator.AnimatorActivity;
import com.dgl.www.my.customView.circlePercent.CirclePercentActivity;
import com.dgl.www.my.customView.scroll.DragActivity;
import com.dgl.www.my.customView.test.TestViewActivity;
import com.dgl.www.my.customView.wave.WaveActivity;
import com.dgl.www.my.customView.weather.MyWeatherActivity;
import com.dgl.www.my.emoji.ChatActivity;
import com.dgl.www.my.emoji.FaceConversionUtil;
import com.dgl.www.my.expandable.Myexpandable;
import com.dgl.www.my.knowledgePoint.AlphaActionBar;
import com.dgl.www.my.knowledgePoint.CreateChooserActivity;
import com.dgl.www.my.knowledgePoint.DialogActivity;
import com.dgl.www.my.knowledgePoint.DrawMesure;
import com.dgl.www.my.knowledgePoint.GetPicture;
import com.dgl.www.my.knowledgePoint.ImageActivity;
import com.dgl.www.my.knowledgePoint.InputActivity;
import com.dgl.www.my.knowledgePoint.LocalFile;
import com.dgl.www.my.knowledgePoint.MyTextWatcher;
import com.dgl.www.my.knowledgePoint.NinePng;
import com.dgl.www.my.knowledgePoint.NormalWebview;
import com.dgl.www.my.knowledgePoint.OnTouchActivity;
import com.dgl.www.my.knowledgePoint.Popup;
import com.dgl.www.my.knowledgePoint.ScaleTypeActivity;
import com.dgl.www.my.knowledgePoint.ShapeActivity;
import com.dgl.www.my.knowledgePoint.ShowHtml;
import com.dgl.www.my.knowledgePoint.SpannableStringActivity;
import com.dgl.www.my.knowledgePoint.TencentX5;
import com.dgl.www.my.knowledgePoint.ToastActivity;
import com.dgl.www.my.knowledgePoint.Translucent;
import com.dgl.www.my.knowledgePoint.WindowManagerActivity;
import com.dgl.www.my.listViewPage.ListFrashActivity;
import com.dgl.www.my.listViewPage.PullToRefreshListViewActivity;
import com.dgl.www.my.listviewWithScrollview.ListWithScroll;
import com.dgl.www.my.materialDesign.MaterialDesignActivity;
import com.dgl.www.my.meituanfenlei.ExpandActivity;
import com.dgl.www.my.miAd.MiAdActivity;
import com.dgl.www.my.netstatus.NetStatusActivity;
import com.dgl.www.my.notification.MyNotification;
import com.dgl.www.my.okhttp.OkHttpActivity;
import com.dgl.www.my.permission.PermissionActivity;
import com.dgl.www.my.qrscan.QrscanActivity;
import com.dgl.www.my.recycleView.RecycleViewActivity;
import com.dgl.www.my.utils.BadgeUtil;
import com.dgl.www.my.video.PlayVideoActivity;
import com.dgl.www.my.virtualKeyboardPassword.TwoPswkeyboardActivity;
import com.dgl.www.my.volley.VolleyAcitvity;
import com.dgl.www.my.weixinHome.WinxinMainActivity;
import com.dgl.www.my.wxapi.WXEntryActivity;

import static android.Manifest.permission.READ_CONTACTS;


/**
 * 主页面
 * listview
 */
public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener,ActivityCompat.OnRequestPermissionsResultCallback {

    private String[] data = new String[]{"沉浸式","渐变","通知栏消息","软键盘的显示和隐藏",
    "textview显示html","手机的分辨率信息",".9图","图片显示方式","微信通讯录"
    ,"RecycleView","Expandable","tencentX5Webview","正常Webview"
    ,"SpannableString","拍照/图片","本地文件地址","微信主页面","图片显示","聊天界面"
    ,"上拉刷新","上拉刷新（框架）","OnTouch事件","分享到微信","监听手机联网状态",
            "输出crash日志到手机","Popupwindow","Volley","悬浮","扫描二维码","申请权限",
            "Material Design","不同位置的toast","DialogActivity","MiAdActivity"
    ,"播放视频","okhttp","三级联动","类似美团分类","shape","自定义view","通过改变图片像素点RGB的值的方式，改变图片的颜色"
    ,"圆形百分比","属性动画","view滑动","系统自带的分享","支付宝密码","白屏","测试measure",
    "温度计1","温度计2","测试view","ListWithScroll","大波浪","天气折线","TextWatcher"};
    private ListView listview;
    private LayoutInflater inflater;
    // 退出时间
    private long currentBackPressedTime = 0;
    // 退出间隔
    private static final int BACK_PRESSED_INTERVAL = 2000;
    private DrawerLayout mDrawerLayout;
    private int INT_READ_CONTACTS = 1;//申请读取通讯录权限

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new Runnable() {
            @Override
            public void run() {
                //表情工具
                FaceConversionUtil.getInstace().getFileText(getApplication());
            }
        }).start();
        image_back.setImageResource(R.drawable.person_face_ico);
        //设置启动图标的消息数量
        BadgeUtil.resetBadgeCount(this);
        BadgeUtil.setBadgeCount(this,10);
        //点击home显示左滑菜单
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
//        navigationView.setCheckedItem(R.id.nav_favourite);
        Resources resource = getBaseContext().getResources();
        ColorStateList csl = resource.getColorStateList(R.color.white);
        navigationView.setItemTextColor(csl);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d("TAG", "Max memory is " + maxMemory + "KB");
        int maxMemoryM = (maxMemory / 1024);
        Log.d("TAG", "Max memory is " + maxMemoryM + "MB");
        Toast.makeText(this,"Max memory is " + maxMemoryM + "MB",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void findWidgets() {
        listview= (ListView) findViewById(R.id.listview);
    }

    @Override
    protected void initComponent() {
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listview.setAdapter(new MyAdapter());
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(mContext,"fab clicked",Toast.LENGTH_LONG).show();
                Snackbar.make(v,"data delete ",Snackbar.LENGTH_SHORT).setAction("yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"data has delete",Toast.LENGTH_LONG).show();
                    }
                }).show();
            }
        });
        image_right.setImageResource(R.drawable.menu_home);
        image_right.setVisibility(View.GONE);
        image_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"menu clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void getIntentData() {

    }

    @Override
    protected void initListener() {
        listview.setOnItemClickListener(this);
    }


    class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView==null){
                viewHolder = new ViewHolder();
                convertView=inflater.inflate(R.layout.item_main, null);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.item_tv);
                convertView.setTag(viewHolder);
            }
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.textView.setText(data[position]);
            return convertView;
        }
        class ViewHolder{
            TextView textView;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    //重写onBackPressed()方法,继承自退出的方法
    @Override
    public void onBackPressed() {
        // 判断时间间隔
        if (System.currentTimeMillis()-currentBackPressedTime>BACK_PRESSED_INTERVAL) {
            currentBackPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "再按一次返回键退出程序", Toast.LENGTH_SHORT).show();
        } else {
            // 退出
            finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent();
        switch (position){
            case 0://沉浸式
                intent.setClass(this,Translucent.class);
                startActivity(intent);
                break;
            case 1://渐变
                intent.setClass(this,AlphaActionBar.class);
                startActivity(intent);
                break;
            case 2://通知栏消息
                intent.setClass(this,MyNotification.class);
                startActivity(intent);
                break;
            case 3://软键盘的显示和隐藏
                intent.setClass(this,InputActivity.class);
                startActivity(intent);
                break;
            case 4://textview显示html
                intent.setClass(this,ShowHtml.class);
                startActivity(intent);
                break;
            case 5://手机的分辨率信息
                intent.setClass(this,DrawMesure.class);
                startActivity(intent);
                break;
            case 6://NinePng
                intent.setClass(this,NinePng.class);
                startActivity(intent);
                break;
            case 7://图片显示方式
                intent.setClass(this,ScaleTypeActivity.class);
                startActivity(intent);
                break;
            case 8://微信通讯录
                if (ContextCompat.checkSelfPermission(this, READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{READ_CONTACTS}, INT_READ_CONTACTS);
                } else {
                    intent.setClass(this,ContactsSortKey.class);
                    startActivity(intent);
                }
                break;
            case 9://RecycleViewTest
                intent.setClass(this,RecycleViewActivity.class);
                startActivity(intent);
                break;
            case 10://Myexpandable
                intent.setClass(this,Myexpandable.class);
                startActivity(intent);
                break;
            case 11://tencentX5Webview
                intent.setClass(this,TencentX5.class);
                startActivity(intent);
                break;
            case 12://正常webview
                intent.setClass(this,NormalWebview.class);
                startActivity(intent);
                break;
            case 13://SpannableStringActivity
                intent.setClass(this,SpannableStringActivity.class);
                startActivity(intent);
                break;
            case 14://拍照/图片
                intent.setClass(this,GetPicture.class);
                startActivity(intent);
                break;
            case 15://LocalFile
                intent.setClass(this,LocalFile.class);
                startActivity(intent);
                break;
            case 16://WinxinMainActivity
                intent.setClass(this,WinxinMainActivity.class);
                startActivity(intent);
                break;
            case 17://图片显示
                intent.setClass(this,ImageActivity.class);
                startActivity(intent);
                break;
            case 18://聊天界面
                intent.setClass(this,ChatActivity.class);
                startActivity(intent);
                break;
            case 19://上拉刷新
                intent.setClass(this,ListFrashActivity.class);
                startActivity(intent);
                break;
            case 20://上拉刷新（框架）
                intent.setClass(this,PullToRefreshListViewActivity.class);
                startActivity(intent);
                break;
            case 21://OnTouch事件
                intent.setClass(this,OnTouchActivity.class);
                startActivity(intent);
                break;
            case 22://分享到微信
                intent.setClass(this,WXEntryActivity.class);
                startActivity(intent);
                break;
            case 23://监听手机联网状态
                intent.setClass(this,NetStatusActivity.class);
                startActivity(intent);
                break;
            case 24://输出crash日志到手机
                intent.setClass(this,CrashActivity.class);
                startActivity(intent);
                break;
            case 25://Popupwindow
                intent.setClass(this,Popup.class);
                startActivity(intent);
                break;
            case 26://Volley
                intent.setClass(this,VolleyAcitvity.class);
                startActivity(intent);
                break;
            case 27://悬浮
                intent.setClass(this,WindowManagerActivity.class);
                startActivity(intent);
                break;
            case 28://二维码
                intent.setClass(this,QrscanActivity.class);
                startActivity(intent);
                break;
            case 29://申请权限
                intent.setClass(this,PermissionActivity.class);
                startActivity(intent);
                break;
            case 30://Material Design
                intent.setClass(this,MaterialDesignActivity.class);
                startActivity(intent);
                break;
            case 31://不同位置的toast
                intent.setClass(this,ToastActivity.class);
                startActivity(intent);
                break;
            case 32://DialogActivity
                intent.setClass(this,DialogActivity.class);
                startActivity(intent);
                break;
            case 33://小米广告
                intent.setClass(this,MiAdActivity.class);
                startActivity(intent);
                break;
            case 34://播放视频
                intent.setClass(this,PlayVideoActivity.class);
                startActivity(intent);
                break;
            case 35://okhttp
                intent.setClass(this,OkHttpActivity.class);
                startActivity(intent);
                break;
            case 36://三级联动
                intent.setClass(this,ThreeLinkActivity.class);
                startActivity(intent);
                break;
            case 37://美团分类
                intent.setClass(this,ExpandActivity.class);
                startActivity(intent);
                break;
            case 38://shape
                intent.setClass(this,ShapeActivity.class);
                startActivity(intent);
                break;
            case 39://自定义view
                intent.setClass(this,ViewOneActivity.class);
                startActivity(intent);
                break;
            case 40://ColorMatrix
                intent.setClass(this,ColorMatrixActivity.class);
                startActivity(intent);
                break;
            case 41://圆形百分比
                intent.setClass(this,CirclePercentActivity.class);
                startActivity(intent);
                break;
            case 42://属性动画
                intent.setClass(this,AnimatorActivity.class);
                startActivity(intent);
                break;
            case 43://view滑动
                intent.setClass(this,DragActivity.class);
                startActivity(intent);
                break;
            case 44://系统自带的分享
                intent.setClass(this,CreateChooserActivity.class);
                startActivity(intent);
                break;
            case 45://支付宝密码
                intent.setClass(this,TwoPswkeyboardActivity.class);
                startActivity(intent);
                break;
            case 46://白屏
                intent.setClass(this,Camera2Activity.class);
                startActivity(intent);
                break;
            case 47://测试measure
                intent.setClass(this,TestMepcActivity.class);
                startActivity(intent);
                break;
            case 48://温度计1
                intent.setClass(this,Thermometer.class);
                startActivity(intent);
                break;
            case 49://温度计2
                intent.setClass(this,ThemometerActivity.class);
                startActivity(intent);
                break;
            case 50://测试view
                intent.setClass(this,TestViewActivity.class);
                startActivity(intent);
                break;
            case 51://ListWithScroll
                intent.setClass(this,ListWithScroll.class);
                startActivity(intent);
                break;
            case 52://大波浪
                intent.setClass(this,WaveActivity.class);
                startActivity(intent);
                break;
            case 53://天气折线
                intent.setClass(this,MyWeatherActivity.class);
                startActivity(intent);
                break;
            case 54://
                intent.setClass(this,MyTextWatcher.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (requestCode == INT_READ_CONTACTS) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        // Permission Granted
                        Toast.makeText(this,"You Granted the permission",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent();
                        intent.setClass(this,ContactsSortKey.class);
                        startActivity(intent);
                    } else {
                        // Permission Denied
                        Toast.makeText(this,"You denied the permission",Toast.LENGTH_LONG).show();
                        Intent localIntent = new Intent();
                        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        if (Build.VERSION.SDK_INT >= 9) {
                            localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                            localIntent.setData(Uri.fromParts("package", MainActivity.this.getPackageName(), null));
                        } else if (Build.VERSION.SDK_INT <= 8) {
                            localIntent.setAction(Intent.ACTION_VIEW);
                            localIntent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
                            localIntent.putExtra("com.android.settings.ApplicationPkgName", MainActivity.this.getPackageName());
                        }
                        startActivity(localIntent);
                    }
                }
                break;
            default:
        }
    }



}