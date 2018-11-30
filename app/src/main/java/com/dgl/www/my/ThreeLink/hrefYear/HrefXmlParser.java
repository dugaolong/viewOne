package com.dgl.www.my.ThreeLink.hrefYear;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * 读取xml文件内容
 */
public class HrefXmlParser extends DefaultHandler {

    private List<YearInfoModel> yearList = new ArrayList<YearInfoModel>();


    public List<YearInfoModel> getDataList() {
        return yearList;
    }

    @Override
    public void startDocument() throws SAXException {

    }

    YearInfoModel yearModel = new YearInfoModel();
    HrefInfoModel hrefModel = new HrefInfoModel();

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if (qName.equals("year")) {
            yearModel = new YearInfoModel();
            yearModel.setName(attributes.getValue(0));
            yearModel.setHrefList(new ArrayList<HrefInfoModel>());
        } else if (qName.equals("href")) {
            hrefModel = new HrefInfoModel();
            hrefModel.setName(attributes.getValue(0));
            hrefModel.setZipcode(attributes.getValue(0));
        } 
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
       if (qName.equals("href")) {
            yearModel.getHrefList().add(hrefModel);
        } else if (qName.equals("year")) {
            yearList.add(yearModel);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
    }
}