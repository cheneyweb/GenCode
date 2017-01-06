package com.cheney.gencode.module;

import java.util.List;

/**
 * @Moudle: Manager
 * @version:v1.0
 * @Description: Manager
 * @author: xuyushuai
 * @date: 2014年10月21日 下午4:43:20
 *
 */
public class Manager {
    private List<Method> methods;

    /**
     * 取得methods
     * 
     * @return List<Method> 处理结果
     */
    public List<Method> getMethods() {
        return methods;
    }

    /**
     * 设置methods
     * 
     * @param methods
     */
    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

}
