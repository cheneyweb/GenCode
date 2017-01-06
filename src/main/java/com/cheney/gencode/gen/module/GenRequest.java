/*package com.cheney.gencode.gen.module;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.Method;
import com.cheney.gencode.module.Request;
import com.cheney.gencode.module.Service;

*//**
 * @Moudle: GenRequest
 * @version:v1.0
 * @Description: 生成Request
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 *//*
public class GenRequest {
    *//**
     *
     * <p>Title: 获取request</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月21日 下午3:03:05</p>
     * 
     * @param document
     * @return request
     *//*
    public static Request getRequest(Document document) {

        NodeList list = document.getElementsByTagName("request");
        Element element = (Element) list.item(0);
        Request request = null;

        if (element != null) {
            // 根据service的名字来生成对应的request
            Service service = GenService.getService(document);
            if (service == null) {
                return null;
            }
            
            List<String> names = new LinkedList<String>();
            for(Method m : service.getMethods())
            {
                names.add(m.getName());
            }
            request = new Request();
            request.setNames(names);
            
            //生成request的其他属性
            String content = element.getAttribute("extends");
            request.setExtendsClass(content);

            content = element.getAttribute("implements");
            request.setImplementsInterface(content);
        }
        return request;
    }
}
*/