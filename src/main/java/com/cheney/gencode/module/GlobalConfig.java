package com.cheney.gencode.module;

/**
 * @Moudle: GlobalConfig
 * @version:v1.0
 * @Description: 全局配置
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:53:06
 *
 */
public class GlobalConfig {

	// Service前缀
	private String servicePrefix;

	// Manager前缀
	private String managerPrefix;

	// Dao前缀
	private String daoPrefix;

	// Bean前缀
	private String beanPrefix;

	// 是否注释
	private String hasNotes;

	// 是否try...catch
	private String hasTryCatch;

	// 输出文件的路径
	private String outputPath;

	// 数据库驱动
	private String driverClassName;

	// 数据库地址
	private String url;

	// 数据库用户名
	private String username;

	// 数据库密码
	private String password;

	// 数据库表
	private String table;

	// 作者名
	private String author;

	// 基础包名
	private String basepackage;

	// DTO拓展类名
	private String extendsClass;

	// DTO实现接口
	private String implementsInterface;

	/**
	 * 取得servicePrefix
	 * 
	 * @return String 处理结果
	 */
	public String getServicePrefix() {
		return servicePrefix;
	}

	/**
	 * 设置servicePrefix
	 * 
	 * @param servicePrefix
	 */
	public void setServicePrefix(String servicePrefix) {
		this.servicePrefix = servicePrefix;
	}

	/**
	 * 取得managerPrefix
	 * 
	 * @return String 处理结果
	 */
	public String getManagerPrefix() {
		return managerPrefix;
	}

	/**
	 * 设置managerPrefix
	 * 
	 * @param managerPrefix
	 */
	public void setManagerPrefix(String managerPrefix) {
		this.managerPrefix = managerPrefix;
	}

	/**
	 * 取得daoPrefix
	 * 
	 * @return String 处理结果
	 */
	public String getDaoPrefix() {
		return daoPrefix;
	}

	/**
	 * 设置daoPrefix
	 * 
	 * @param daoPrefix
	 */
	public void setDaoPrefix(String daoPrefix) {
		this.daoPrefix = daoPrefix;
	}

	/**
	 * 取得beanPrefix
	 * 
	 * @return String 处理结果
	 */
	public String getBeanPrefix() {
		return beanPrefix;
	}

	/**
	 * 设置beanPrefix
	 * 
	 * @param beanPrefix
	 */
	public void setBeanPrefix(String beanPrefix) {
		this.beanPrefix = beanPrefix;
	}

	/**
	 * 取得hasNotes
	 * 
	 * @return String 处理结果
	 */
	public String getHasNotes() {
		return hasNotes;
	}

	/**
	 * 设置hasNotes
	 * 
	 * @param hasNotes
	 */
	public void setHasNotes(String hasNotes) {
		this.hasNotes = hasNotes;
	}

	/**
	 * 取得hasTryCatch
	 * 
	 * @return String 处理结果
	 */
	public String getHasTryCatch() {
		return hasTryCatch;
	}

	/**
	 * 设置hasTryCatch
	 * 
	 * @param hasTryCatch
	 */
	public void setHasTryCatch(String hasTryCatch) {
		this.hasTryCatch = hasTryCatch;
	}

	/**
	 * 取得outputPath
	 * 
	 * @return String 处理结果
	 */
	public String getOutputPath() {
		return outputPath;
	}

	/**
	 * 设置outputPath
	 * 
	 * @param outputPath
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	/**
	 * 取得driverClassName
	 * 
	 * @return String 处理结果
	 */
	public String getDriverClassName() {
		return driverClassName;
	}

	/**
	 * 设置driverClassName
	 * 
	 * @param driverClassName
	 */
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	/**
	 * 取得url
	 * 
	 * @return String 处理结果
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 设置url
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 取得username
	 * 
	 * @return String 处理结果
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 设置username
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 取得password
	 * 
	 * @return String 处理结果
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置password
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 取得table
	 * 
	 * @return String 处理结果
	 */
	public String getTable() {
		return table;
	}

	/**
	 * 设置table
	 * 
	 * @param table
	 */
	public void setTable(String table) {
		this.table = table;
	}

	/**
	 * 取得author
	 * 
	 * @return String 处理结果
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 设置author
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 取得basepackage
	 * 
	 * @return String 处理结果
	 */
	public String getBasepackage() {
		return basepackage;
	}

	/**
	 * 设置basepackage
	 * 
	 * @param basepackage
	 */
	public void setBasepackage(String basepackage) {
		this.basepackage = basepackage;
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
