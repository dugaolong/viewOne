package com.dgl.www.my.ThreeLink.hrefYear;


import java.util.List;

/**
 * 年
 */
public class YearInfoModel {
    private String name;
    private List<HrefInfoModel> hrefList;

    public YearInfoModel() {
        super();
    }

    public YearInfoModel(String name, List<HrefInfoModel> hrefList) {
        super();
        this.name = name;
        this.hrefList = hrefList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HrefInfoModel> getHrefList() {
        return hrefList;
    }

    public void setHrefList(List<HrefInfoModel> hrefList) {
        this.hrefList = hrefList;
    }

    @Override
    public String toString() {
        return "ProvinceInfoModel [name=" + name + ", hrefList=" + hrefList + "]";
    }
}