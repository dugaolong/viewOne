package com.dgl.www.my.ThreeLink.month;


import java.util.List;

/**
 * 年
 */
public class YearInfoModel {
    private String name;
    private List<MonthInfoModel> monthList;

    public YearInfoModel() {
        super();
    }

    public YearInfoModel(String name, List<MonthInfoModel> monthList) {
        super();
        this.name = name;
        this.monthList = monthList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MonthInfoModel> getMonthList() {
        return monthList;
    }

    public void setMonthList(List<MonthInfoModel> monthList) {
        this.monthList = monthList;
    }

    @Override
    public String toString() {
        return "ProvinceInfoModel [name=" + name + ", monthList=" + monthList + "]";
    }
}