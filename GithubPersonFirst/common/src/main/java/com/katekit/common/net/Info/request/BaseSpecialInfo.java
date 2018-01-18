package com.katekit.common.net.Info.request;

import android.text.TextUtils;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * Created by »ÆÃ÷²Ó on 2017/10/27 10:57.
 */

public class BaseSpecialInfo {
    private Document document;
    private Element eleHead;
    private Element request;
    private Element eleBody;

    public BaseSpecialInfo() {
        document = DocumentFactory.getInstance().createDocument();
        document.setXMLEncoding("utf-8");
        request = DocumentHelper.createElement("PospReq");
        document.setRootElement(request);

        eleHead = request.addElement("Head");
        eleBody = request.addElement("Body");
    }
    public BaseSpecialInfo(String test) {
        document = DocumentFactory.getInstance().createDocument();
        document.setXMLEncoding("utf-8");
        request = DocumentHelper.createElement("PospRes");
        document.setRootElement(request);

        eleHead = request.addElement("Head");
        eleBody = request.addElement("Body");
    }

    public BaseSpecialInfo addHeadItem(String property, String value) {
        if (TextUtils.isEmpty(value)){
            return this;
        }
        Element element = eleHead.addElement(property);
        element.setText(value);
        return this;
    }
    public BaseSpecialInfo addbodyItem(String property, String value) {
        if (TextUtils.isEmpty(value)){
            return this;
        }
        Element element = eleBody.addElement(property);
        element.setText(value);
        return this;
    }

    public String makeRequestXMLData() {
        if (document == null){
            return "";
        }
//        String macBody = document.asXML();
//            macBody = macBody.replace("<request>","").replace("</request>","").replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n","");
//            Element eleMac = request.addElement(XML_TAG_MAC);
//            eleMac.setText(getMac(macBody));
        return document.asXML();
    }
}
