package com.cheney.gencode.module;

/**
 * @Moudle: Entity
 * @version:v1.0
 * @Description: Entity
 * @author: xuyushuai
 * @date: 2014年10月21日 下午3:29:10
 *
 */
public class Entity {
	// 表前缀
	private String tablePrefix;
	// 类名
    private String className;
	// 继承的类
    private String extendsClass;
    // 实现的接口
    private String implementsInterface;
    
	public String getTablePrefix() {
		return tablePrefix;
	}
	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getExtendsClass() {
		return extendsClass;
	}
	public void setExtendsClass(String extendsClass) {
		this.extendsClass = extendsClass;
	}
	public String getImplementsInterface() {
		return implementsInterface;
	}
	public void setImplementsInterface(String implementsInterface) {
		this.implementsInterface = implementsInterface;
	}
}
