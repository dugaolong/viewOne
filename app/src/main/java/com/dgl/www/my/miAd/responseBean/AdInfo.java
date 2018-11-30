package com.dgl.www.my.miAd.responseBean;

import java.util.Arrays;

/**
 * Created by dugaolong on 17/5/9.
 */

public class AdInfo {

    private int id;
    private String title;
    private String summary;
    private String source;
    private String[] imgUrls;
    private String ex;
    private String template;
    private String landingPageUrl;
    private int targetType;
    private String[] viewMonitorUrls;
    private int adStyle;
    private int materialType;
    private String tagId;
    private Parameter[] parameters;
    private String dspShowName;
    private long expireTime;
    private SdkAdDetail sdkAdDetail;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String[] getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getLandingPageUrl() {
        return landingPageUrl;
    }

    public void setLandingPageUrl(String landingPageUrl) {
        this.landingPageUrl = landingPageUrl;
    }

    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public String[] getViewMonitorUrls() {
        return viewMonitorUrls;
    }

    public void setViewMonitorUrls(String[] viewMonitorUrls) {
        this.viewMonitorUrls = viewMonitorUrls;
    }

    public int getAdStyle() {
        return adStyle;
    }

    public void setAdStyle(int adStyle) {
        this.adStyle = adStyle;
    }

    public int getMaterialType() {
        return materialType;
    }

    public void setMaterialType(int materialType) {
        this.materialType = materialType;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Parameter[] getParameters() {
        return parameters;
    }

    public void setParameters(Parameter[] parameters) {
        this.parameters = parameters;
    }

    public String getDspShowName() {
        return dspShowName;
    }

    public void setDspShowName(String dspShowName) {
        this.dspShowName = dspShowName;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public SdkAdDetail getSdkAdDetail() {
        return sdkAdDetail;
    }

    public void setSdkAdDetail(SdkAdDetail sdkAdDetail) {
        this.sdkAdDetail = sdkAdDetail;
    }


    @Override
    public String toString() {
        return "AdInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", source='" + source + '\'' +
                ", imgUrls=" + Arrays.toString(imgUrls) +
                ", ex='" + ex + '\'' +
                ", template='" + template + '\'' +
                ", landingPageUrl='" + landingPageUrl + '\'' +
                ", targetType=" + targetType +
                ", viewMonitorUrls=" + Arrays.toString(viewMonitorUrls) +
                ", adStyle=" + adStyle +
                ", materialType=" + materialType +
                ", tagId='" + tagId + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                ", dspShowName='" + dspShowName + '\'' +
                ", expireTime=" + expireTime +
                ", sdkAdDetail=" + sdkAdDetail +
                '}';
    }
}
