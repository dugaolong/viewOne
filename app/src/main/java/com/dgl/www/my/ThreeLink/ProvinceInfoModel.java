package com.dgl.www.my.ThreeLink;

import java.util.List;
/**
 * 省
 */
public class ProvinceInfoModel {
    private String name;
    private List<CityInfoModel> cityList;

    public ProvinceInfoModel() {
        super();
    }

    public ProvinceInfoModel(String name, List<CityInfoModel> cityList) {
        super();
        this.name = name;
        this.cityList = cityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CityInfoModel> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityInfoModel> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String toString() {
        return "ProvinceInfoModel [name=" + name + ", cityList=" + cityList + "]";
    }
}