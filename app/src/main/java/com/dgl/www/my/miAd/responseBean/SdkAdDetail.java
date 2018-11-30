package com.dgl.www.my.miAd.responseBean;

/**
 * Created by dugaolong on 17/5/9.
 */

public class SdkAdDetail {

    private boolean isPopUpDownload;

    public boolean isPopUpDownload() {
        return isPopUpDownload;
    }

    public void setPopUpDownload(boolean popUpDownload) {
        isPopUpDownload = popUpDownload;
    }

    @Override
    public String toString() {
        return "SdkAdDetail{" +
                "isPopUpDownload=" + isPopUpDownload +
                '}';
    }
}
