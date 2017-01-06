package com.cheney.gencode.gen.module;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.Method;

/**
 * @Moudle: GenMethod
 * @version:v1.0
 * @Description: 生成方法代码
 * @author: xuyushuai
 * @date: 2014年10月27日 下午3:16:47
 *
 */
public class GenMethod {
    /**
     *
     * <p>Title: getMethods</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月27日 下午3:18:14</p>
     * @param methodList 
     * 
     * @return List<Method>
     */
    public static List<Method> getMethods(NodeList methodList) {
        
        List<Method> methods = new LinkedList<Method>();
        
        for (int j = 0; j < methodList.getLength(); j++) {
            Method method = new Method();
            Element e = (Element) methodList.item(j);
            // 设置方法名字
            method.setName(e.getFirstChild()==null?"":e.getFirstChild().getNodeValue());
            // 设置返回值
            method.setReturnType(e.getAttribute("returnType"));

            // 设置入参和入参类型
            String[] inParamTypes = e.getAttribute("inParamTypes").split(",");
            String[] inParams = e.getAttribute("inParams").split(",");

            Map<String, String> inParamMap = new HashMap<String, String>();
            for (int i = 0; i < inParams.length; i++) {
                inParamMap.put(inParams[i], inParamTypes[i]);
            }
            method.setInParamMap(inParamMap);
            methods.add(method);
        }
        return methods;
    }
}
