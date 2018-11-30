package com.dgl.www.my.miAd.bean;

import com.dgl.www.my.miAd.bean.impRequest.ImpRequest;

import java.util.ArrayList;

/**
 * Created by dugaolong on 17/3/31.
 */

public class ClientInfo {
    private DeviceInfo deviceInfo;
    private UserInfo userInfo;
    private ApplicationInfo applicationInfo;
    private ArrayList<ImpRequest> impRequests;
    private AdSdkInfo adSdkInfo;
    private Context context;

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
    }

    public ArrayList<ImpRequest> getImpRequests() {
        return impRequests;
    }

    public void setImpRequests(ArrayList<ImpRequest> impRequests) {
        this.impRequests = impRequests;
    }

    public AdSdkInfo getAdSdkInfo() {
        return adSdkInfo;
    }

    public void setAdSdkInfo(AdSdkInfo adSdkInfo) {
        this.adSdkInfo = adSdkInfo;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
