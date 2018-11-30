package com.dgl.www.my.miAd.bean;

import java.util.ArrayList;

/**
 * Created by dugaolong on 17/3/31.
 */

public class Ad {
    private int status;
    private String triggerId;
    private ArrayList<AdInfo> adInfos;
    private int style;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId;
    }

    public ArrayList<AdInfo> getAdInfos() {
        return adInfos;
    }

    public void setAdInfos(ArrayList<AdInfo> adInfos) {
        this.adInfos = adInfos;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
