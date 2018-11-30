package com.dgl.www.my.ThreeLink.hrefYear;

/**
 * 半年
 */
public class HrefInfoModel {

    private String name;
    private String zipcode;

    public HrefInfoModel() {
        super();
    }

    public HrefInfoModel(String name, String zipcode) {
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