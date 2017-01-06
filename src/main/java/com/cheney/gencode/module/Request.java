package com.cheney.gencode.module;

import java.util.List;

/**
 * @Moudle: Request
 * @version:v1.0
 * @Description: Request
 * @author: xuyushuai
 * @date: 2014年10月21日 下午3:29:10
 *
 */
public class Request {
    // 名称
    private List<String> names;

    // 继承的类
    private String extendsClass;

    // 实现的接口
    private String implementsInterface;

    /**
     * 取得names
     * 
     * @return List<String> 处理结果
     */
    public List<String> getNames() {
        return names;
    }

    /**
     * 设置names
     * 
     * @param names
     */
    public void setNames(List<String> names) {
        this.names = names;
    }

    /**
     * 取得extendsClass
     * 
     * @return String 处理结果
     */
    public String getExtendsClass() {
        return extendsClass;
    }

    /**
     * 设置extendsClass
     * 
     * @param extendsClass
     */
    public void setExtendsClass(String extendsClass) {
        this.extendsClass = extendsClass;
    }

    /**
     * 取得implementsInterface
     * 
     * @return String 处理结果
     */
    public String getImplementsInterface() {
        return implementsInterface;
    }

    /**
     * 设置implementsInterface
     * 
     * @param implementsInterface
     */
    public void setImplementsInterface(String implementsInterface) {
        this.implementsInterface = implementsInterface;
    }

}
