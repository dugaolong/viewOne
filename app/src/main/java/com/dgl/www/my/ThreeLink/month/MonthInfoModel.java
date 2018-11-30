package com.dgl.www.my.ThreeLink.month;

/**
 * 月
 */
public class MonthInfoModel {

    private String name;
    private String zipcode;

    public MonthInfoModel() {
        super();
    }

    public MonthInfoModel(String name, String zipcode) {
        super();
        this.name = name;
        this.zipcode = zipcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "MonthInfoModel [name=" + name + ", zipcode=" + zipcode + "]";
    }

}