/*package com.cheney.gencode.gen.module;

import java.util.LinkedList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.Method;
import com.cheney.gencode.module.Response;
import com.cheney.gencode.module.Service;

*//**
 * @Moudle: GenResponse
 * @version:v1.0
 * @Description: 生成Response
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 *//*
public class GenResponse {
    *//**
     *
     * <p>Title: 获取response</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月21日 下午3:03:05</p>
     * 
     * @param document
     * @return response
     *//*
    public static Response getResponse(Document document) {

        Response response = null;

        NodeList list = document.getElementsByTagName("response");
        Element element = (Element) list.item(0);

        if (element != null) {
            // 根据service的名字来生成对应的request
            Service service = GenService.getService(document);
            if (service == null) {
                return null;
            }

            List<String> names = new LinkedList<String>();
            for (Method m : service.getMethods()) {
                names.add(m.getName());
            }
            response = new Response();
            response.setNames(names);

            // 生成response的其他属性
            String content = element.getAttribute("extends");
            response.setExtendsClass(content);

            content = element.getAttribute("implements");
            response.setImplementsInterface(content);

        }
        return response;
    }
}
*/