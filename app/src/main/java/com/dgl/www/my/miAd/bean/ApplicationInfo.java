package com.dgl.www.my.miAd.bean;

/**
 * Created by dugaolong on 17/3/31.
 */

public class ApplicationInfo {
    private String packageName;
    private String version;
    private String platform;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
