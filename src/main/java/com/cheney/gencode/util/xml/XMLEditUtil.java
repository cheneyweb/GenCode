/**
 * @Title: XMLEdit.java
 * @Package: com.cheney.xml
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月24日 上午10:10:12
 * @version: V1.0
 */
package com.cheney.gencode.util.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

/**
 * @Moudle: XMLEditUtil
 * @version:v1.0
 * @Description: XML编辑器
 * @author: xuyushuai
 * @date: 2014年10月24日 上午10:10:12
 *
 */
public class XMLEditUtil {
    /**
     *
     * <p>Title: 将Document输出到文件</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月24日 上午10:10:41</p>
     * 
     * @param fileName
     * @param doc
     */
    public static void editXml(String fileName, Document doc) {
        TransformerFactory transFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource();
            source.setNode(doc);
            StreamResult result = new StreamResult();
            result.setOutputStream(new FileOutputStream(fileName));

            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
