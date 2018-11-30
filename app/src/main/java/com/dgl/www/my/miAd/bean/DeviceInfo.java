package com.dgl.www.my.miAd.bean;

/**
 * Created by dugaolong on 17/3/31.
 */

public class DeviceInfo {
    private int screenWidth;
    private int screenHeight;
    private String screenDensity;
    private String model;
    private String device;
    private String androidVersion;
    private String miuiVersion;
    private String bc;
    private String make;
    private boolean isInter;

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public String getScreenDensity() {
        return screenDensity;
    }

    public void setScreenDensity(String screenDensity) {
        this.screenDensity = screenDensity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getMiuiVersion() {
        return miuiVersion;
    }

    public void setMiuiVersion(String miuiVersion) {
        this.miuiVersion = miuiVersion;
    }

    public String getBc() {
        return bc;
    }

    public void setBc(String bc) {
        this.bc = bc;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public boolean isInter() {
        return isInter;
    }

    public void setInter(boolean inter) {
        isInter = inter;
    }
}
