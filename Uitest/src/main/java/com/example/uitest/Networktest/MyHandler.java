package com.example.uitest.Networktest;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by 赵泳霖 on 2017/11/12.
 */

public class MyHandler extends DefaultHandler {
    //开始xml解析
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
    }
    //开始解析某个节点
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
    }
    //获取某个节点
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
    }
    //完成解析某个节点
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
    }
    //完成整个xml解析
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
