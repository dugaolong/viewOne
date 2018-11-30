package com.dgl.www.my.miAd.bean;

import java.util.ArrayList;

/**
 * Created by dugaolong on 17/3/31.
 */

public class AdInfo {
    private String ex;
    private int id;
    private String title;
    private ArrayList<String> imgUrls;
    private String summary;
    private String landingPageUrl;
    private int targetType;
    private String source;
    private int duration;
    private ArrayList<String> viewMonitorUrls;
    private String tagId;
    private String template;
    private int width;
    private int height;
    private int sequence;
    private int allDownloadNum;
    private Parameter parameter;
    private String dspShowName;
    private int expireTime;
    private int adStyle;
    private int materialType;
    private SdkAdDetail sdkAdDetail;

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

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

    public ArrayList<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(ArrayList<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getViewMonitorUrls() {
        return viewMonitorUrls;
    }

    public void setViewMonitorUrls(ArrayList<String> viewMonitorUrls) {
        this.viewMonitorUrls = viewMonitorUrls;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getAllDownloadNum() {
        return allDownloadNum;
    }

    public void setAllDownloadNum(int allDownloadNum) {
        this.allDownloadNum = allDownloadNum;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    public String getDspShowName() {
        return dspShowName;
    }

    public void setDspShowName(String dspShowName) {
        this.dspShowName = dspShowName;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
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

    public SdkAdDetail getSdkAdDetail() {
        return sdkAdDetail;
    }

    public void setSdkAdDetail(SdkAdDetail sdkAdDetail) {
        this.sdkAdDetail = sdkAdDetail;
    }
}
