package com.dgl.www.my.ThreeLink.month;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 读取xml文件内容
 */
public class MonthXmlParser extends DefaultHandler {

    private List<YearInfoModel> yearList = new ArrayList<YearInfoModel>();


    public List<YearInfoModel> getDataList() {
        return yearList;
    }

    @Override
    public void startDocument() throws SAXException {

    }

    YearInfoModel yearModel = new YearInfoModel();
    MonthInfoModel MonthModel = new MonthInfoModel();

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals("year")) {
            yearModel = new YearInfoModel();
            yearModel.setName(attributes.getValue(0));
            yearModel.setMonthList(new ArrayList<MonthInfoModel>());
        } else if (qName.equals("month")) {
            MonthModel = new MonthInfoModel();
            MonthModel.setName(attributes.getValue(0));
            MonthModel.setZipcode(attributes.getValue(0));
        } 
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
       if (qName.equals("month")) {
            yearModel.getMonthList().add(MonthModel);
        } else if (qName.equals("year")) {
            yearList.add(yearModel);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
    }
}