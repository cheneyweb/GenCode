package com.cheney.gencode.module;

/**
 * @Moudle: Query
 * @version:v1.0
 * @Description: 查询条件
 * @author: xuyushuai
 * @date: 2014年10月21日 下午3:29:10
 *
 */
public class Query {
    // 继承的类
    private String extendsClass;
    // 实现的接口
    private String implementsInterface;
    /** 
     * 取得extendsClass
     * @return String 处理结果
     */
    public String getExtendsClass() {
        return extendsClass;
    }
    /** 
     * 设置extendsClass
     * @param extendsClass
     */
    public void setExtendsClass(String extendsClass) {
        this.extendsClass = extendsClass;
    }
    /** 
     * 取得implementsInterface
     * @return String 处理结果
     */
    public String getImplementsInterface() {
        return implementsInterface;
    }
    /** 
     * 设置implementsInterface
     * @param implementsInterface
     */
    public void setImplementsInterface(String implementsInterface) {
        this.implementsInterface = implementsInterface;
    }
    
    
}
