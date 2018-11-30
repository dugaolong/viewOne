package com.dgl.www.my.Contacts;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.dgl.www.my.R;
import com.dgl.www.my.bean.PhoneContact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dugaolong on 16/8/19.
 */
public class ContactsSortKey extends Activity {

    private ExpandableListView expandableListView;
    private SideBar sidebar;
    private TextView dialog;
    public ContactAdapter adapter;
    private List<PhoneContact> mData = new ArrayList<PhoneContact>();
    private HashMap<String,List<PhoneContact>> map=new HashMap<>();
    //设置组视图的显示文字
    private List<String> generalsTypes =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        initData();
        adapter = new ContactAdapter(this,map,generalsTypes);
        expandableListView.setAdapter(adapter);
        expandGroup();
        initView();
        // 设置字母导航触摸监听
        sidebar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {

            @Override
            public void onTouchingLetterChanged(String s) {
                // 该字母首次出现的位置
                Log.e("aaaa","s="+s);
                Log.e("aaaa","s.charAt(0)="+s.charAt(0));
                int position = adapter.getPositionForSelection(s.charAt(0));
                Log.e("position","position="+position);
                if (position != -1) {
//                    expandableListView.setSelection(position);
                    expandableListView.setSelectedGroup(position);
                }
            }
        });
    }

    private void initView() {
        //去掉箭头
        expandableListView.setGroupIndicator(null);
        //expandableListView父级不能点击
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                return true;
            }
        });
        sidebar = (SideBar) findViewById(R.id.sidebar);
        dialog = (TextView) findViewById(R.id.dialog);
        sidebar.setTextView(dialog);
    }

    //展开
    public void expandGroup(){
        for (int i = 0, length = generalsTypes.size(); i < length; i++) {
            expandableListView.expandGroup(i);
        }
    }


    private void initData() {
        String phonebook_label="";
        if(android.os.Build.VERSION.SDK_INT>=19){
            phonebook_label="phonebook_label";
        }else{
            phonebook_label="sort_key";
        }
        // 从Contacts表中找出所有联系人
        Cursor cursor = this.getContentResolver().query(
                ContactsContract.Contacts.CONTENT_URI,
                new String[]{"_id", "display_name", "has_phone_number", phonebook_label},
                null, null, phonebook_label);

        if (cursor != null) {
            while(cursor.moveToNext()) {
                PhoneContact contact = new PhoneContact();
                contact.setName(cursor.getString(cursor.getColumnIndex("display_name")));
                contact.setHasNumber(cursor.getInt(cursor.getColumnIndex("has_phone_number")));
                contact.setContactId(cursor.getInt(cursor.getColumnIndex("_id")));
                String sortKey = getSortKey(cursor.getString(cursor.getColumnIndex(phonebook_label)));
                contact.setSortKey(sortKey);
                mData.add(contact);
                Log.e("ContactsSortKey", contact.toString());
            }
            cursor.close();
        }
        for(PhoneContact phoneContact:mData){
            String sortKey = phoneContact.getSortKey();
            if(!generalsTypes.contains(sortKey)){
                generalsTypes.add(sortKey);
            }
            List<PhoneContact> list=map.get(sortKey);
            if(list==null){
                list = new ArrayList<>();
                map.put(sortKey,list);
            }
            list.add(phoneContact);
        }

    }

    /**
     * 获取sort key的首个字符，如果是英文字母就直接返回，否则返回#。
     *
     * @param sortKeyString 数据库中读取出的sort key
     * @return 英文字母或者#
     */
    private static String getSortKey(String sortKeyString) {
        String key = sortKeyString.substring(0, 1).toUpperCase();
        if (key.matches("[A-Z]")) {
            return key;
        }
        return "#";
    }




}
