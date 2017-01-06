/**
 * @Title: GenGlobalConfig.java
 * @Package: com.cheney.gencode
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 * @version: V1.0
 */
package com.cheney.gencode.gen.module;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.Query;

/**
 * @Moudle: GenGlobalConfig
 * @version:v1.0
 * @Description: 获取查询条件
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 */
public class GenQuery {

    /**
     *
     * <p>Title: 获取查询条件</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月21日 下午3:03:05</p>
     * 
     * @param document
     * @return 查询条件
     */
    public static Query getQuery(Document document) {

        Query query = null;

        NodeList list = document.getElementsByTagName("query");
        Element element = (Element) list.item(0);

        if (element != null) {
            query = new Query();

            String content = element.getAttribute("extends");
            query.setExtendsClass(content);

            content = element.getAttribute("implements");
            query.setImplementsInterface(content);

        }
        return query;
    }
}
