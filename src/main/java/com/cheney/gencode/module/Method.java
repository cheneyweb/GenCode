/**
 * @Title: Dao.java
 * @Package: com.cheney.module
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午4:06:14
 * @version: V1.0
 */
package com.cheney.gencode.module;

import java.util.Map;

/**
 * @Moudle: Method
 * @version:v1.0
 * @Description: Method
 * @author: xuyushuai
 * @date: 2014年10月21日 下午4:06:14
 *
 */
public class Method {
	// 名称
    private String name;
    // 入参map
    private Map<String, String> inParamMap;
    // 返回值
    private String returnType;

    

    /**
     * 取得returnType
     * 
     * @return String 处理结果
     */
    public String getReturnType() {
        return returnType;
    }

    /**
     * 设置returnType
     * 
     * @param returnType
     */
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    /**
     * 取得inParamMap
     * 
     * @return Map<String,String> 处理结果
     */
    public Map<String, String> getInParamMap() {
        return inParamMap;
    }

    /**
     * 设置inParamMap
     * 
     * @param inParamMap
     */
    public void setInParamMap(Map<String, String> inParamMap) {
        this.inParamMap = inParamMap;
    }

    /**
     * 取得name
     * 
     * @return String 处理结果
     */
    public String getName() {
        return name;
    }

    /**
     * 设置name
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
