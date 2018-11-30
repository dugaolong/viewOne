package com.dgl.www.my.miAd.responseBean;

import java.util.Arrays;

/**
 * Created by dugaolong on 17/5/9.
 */

public class ResponseBean {

    private int status;
    private int code;
    private String triggerId;
    private AdInfo[] adInfos;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(String triggerId) {
        this.triggerId = triggerId;
    }

    public AdInfo[] getAdInfos() {
        return adInfos;
    }

    public void setAdInfos(AdInfo[] adInfos) {
        this.adInfos = adInfos;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "status=" + status +
                ", code=" + code +
                ", triggerId='" + triggerId + '\'' +
                ", adInfo=" + Arrays.toString(adInfos) +
                '}';
    }
}
