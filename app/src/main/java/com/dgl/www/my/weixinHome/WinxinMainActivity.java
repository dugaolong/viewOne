package com.dgl.www.my.weixinHome;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.dgl.www.my.utils.MySystemParams;
import com.jauker.widget.BadgeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dugaolong on 16/9/12.
 * view
 * adapter
 * data
 */
public class WinxinMainActivity extends FragmentActivity implements View.OnClickListener{

    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;
    private List<Fragment> datas;
    private TextView chatTv;
    private TextView friendTv;
    private TextView contactTv;
    private LinearLayout ll_chat;
    private LinearLayout ll_friend;
    private LinearLayout ll_contact;
    BadgeView mBadgeViewChat;
    BadgeView mBadgeViewFriend;
    BadgeView mBadgeViewContact;
    private ImageView iv_tabline;
    private int currentTab;//当前tab
    private int width1_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.weixin_main);
        initLine();
        initView();
    }

    private void initLine() {
        MySystemParams mys = MySystemParams.getInstance(this);
        width1_3 = mys.screenWidth/3;

    }

    private void initView() {
        chatTv = (TextView) findViewById(R.id.chatTv);
        friendTv = (TextView) findViewById(R.id.friendTv);
        contactTv = (TextView) findViewById(R.id.contactTv);
        viewPager = (ViewPager) findViewById(R.id.id_vp);
        ll_chat = (LinearLayout) findViewById(R.id.ll_chat);
        ll_friend = (LinearLayout) findViewById(R.id.ll_friend);
        ll_contact = (LinearLayout) findViewById(R.id.ll_contact);
        ll_chat.setOnClickListener(this);
        ll_friend.setOnClickListener(this);
        ll_contact.setOnClickListener(this);
        iv_tabline = (ImageView) findViewById(R.id.iv_tabline);
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) iv_tabline.getLayoutParams();
        lp.width=width1_3;
        iv_tabline.setLayoutParams(lp);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return datas.get(position);
            }

            @Override
            public int getCount() {
                return datas.size();
            }
        };
        datas = new ArrayList<Fragment>();
        final ChatFragment chatFragment = new ChatFragment();
        final FriendFragment friendFragment = new FriendFragment();
        ContactFragment contactFragment = new ContactFragment();
        datas.add(chatFragment);
        datas.add(friendFragment);
        datas.add(contactFragment);
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *
             * @param position 当前页面，及你点击滑动的页面
             * @param positionOffset 当前页面偏移的百分比
             * @param positionOffsetPixels 当前页面偏移的像素位置
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) iv_tabline.getLayoutParams();

                if(currentTab ==0 && position==0){//0-->1
                    lp.leftMargin = (int) (positionOffset*width1_3);
                }else if(currentTab ==1 && position==1){//1-->2
                    lp.leftMargin = (int) (currentTab*width1_3 + positionOffset*width1_3);
                }else if(currentTab ==1 && position==0){//1-->0
                    lp.leftMargin = (int) (currentTab*width1_3 + (positionOffset-1)*width1_3);
                }else if(currentTab ==2 && position==1){//2-->1
                    lp.leftMargin = (int) (currentTab*width1_3 + (positionOffset-1)*width1_3);
                }
                iv_tabline.setLayoutParams(lp);
                Log.e("onPageScrolled",position+"   ,   " + positionOffset+"  ,  " + positionOffsetPixels);
                Log.e("onPageScrolled","width1_3:"+width1_3);
            }

            //此方法是页面跳转完后得到调用，position是你跳转完后得到的页面的Position（位置编号）。
            @Override
            public void onPageSelected(int position) {
                currentTab = position;
                initTextColor();
                switch (position){
                    case 0:
                        chatTv.setTextColor(Color.GREEN);
                        if(mBadgeViewChat == null){
                            mBadgeViewChat = new BadgeView(WinxinMainActivity.this);
                        }
                        setBadge(ll_chat,mBadgeViewChat, 2);
                        break;
                    case 1:
                        friendTv.setTextColor(Color.GREEN);
                        if(mBadgeViewFriend == null){
                            mBadgeViewFriend = new BadgeView(WinxinMainActivity.this);
                        }
                        setBadge(ll_friend, mBadgeViewFriend, 5);
                        break;
                    case 2:
                        contactTv.setTextColor(Color.GREEN);
                        if(mBadgeViewContact == null){
                            mBadgeViewContact = new BadgeView(WinxinMainActivity.this);
                        }
                        setBadge(ll_contact, mBadgeViewContact, 7);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initTextColor() {
        chatTv.setTextColor(Color.BLACK);
        friendTv.setTextColor(Color.BLACK);
        contactTv.setTextColor(Color.BLACK);
    }
    private void setSelect(int i) {
        //设置那个fragment 显示
        viewPager.setCurrentItem(i);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.ll_chat:
                setSelect(0);
                if(mBadgeViewChat == null){
                    mBadgeViewChat = new BadgeView(WinxinMainActivity.this);
                }
                setBadge(ll_chat, mBadgeViewChat, 1);

                break;
            case R.id.ll_friend:
                setSelect(1);
                if(mBadgeViewFriend == null){
                    mBadgeViewFriend = new BadgeView(WinxinMainActivity.this);
                }
                setBadge(ll_friend, mBadgeViewFriend, 1);
                break;
            case R.id.ll_contact:
                setSelect(2);
                if(mBadgeViewContact == null){
                    mBadgeViewContact = new BadgeView(WinxinMainActivity.this);
                }
                setBadge(ll_contact, mBadgeViewContact, 1);
                break;
        }
    }

    private void setBadge(LinearLayout container,BadgeView badgeView,int num){
        container.removeView(badgeView);
        badgeView.setBadgeCount(num);
        container.addView(badgeView);
    }
}
