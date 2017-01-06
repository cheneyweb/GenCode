package com.cheney.gencode.util.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * @Moudle: XMLParseUtil
 * @version:v1.0
 * @Description: XML解析器
 * @author: xuyushuai
 * @date: 2014年10月21日 下午1:27:36
 *
 */
public class XMLParseUtil {
    /**
     * <p>Title: getDocument()</p>
     * <p>Description: 获取Document</p>
     * 
     * @param configXMLFilePath
     * @return Document
     */
    public static Document getDocument(File file) {
        // step 1:获得DOM解析器工厂
        // 工厂的作用是创建具体的解析器
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // step 2：获得具体的dom解析器
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("获取dom解析器出错");
        }

        // step 3:解析一个xml文档，获得Document对象（根节点）
        // 此文档放在项目目录下即可
        Document document = null;
        try {
            document = db.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("config.xml文件不存在!");
        }
        return document;
    }
    
    public static Document getDocument(InputStream is) {
        // step 1:获得DOM解析器工厂
        // 工厂的作用是创建具体的解析器
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        // step 2：获得具体的dom解析器
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("获取dom解析器出错");
        }

        // step 3:解析一个XML的InputStream，获得Document对象（根节点）
        // 此文档放在项目目录下即可
        Document document = null;
        try {
            document = db.parse(is);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}
