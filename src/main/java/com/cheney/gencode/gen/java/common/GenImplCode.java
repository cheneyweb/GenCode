package com.cheney.gencode.gen.java.common;

import java.util.List;
import java.util.Map;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.gen.java.comment.GenClassHeadComment;
import com.cheney.gencode.module.Method;
import com.cheney.gencode.util.string.StringUtil;

/**
 * @Moudle: GenImplCode 
 * @version:v1.0
 * @Description: 生成接口的实现代码
 * @author: xuyushuai
 * @date: 2015年5月4日 上午10:49:08
 *
 */
public class GenImplCode {
	/**
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:49:10</p>
	 * @param moduleName
	 * @param methods
	 * @return 接口的实现代码
	 */
	public static String gen(Map<String,String> parmMap, List<Method> methods) {
		// 入参设置
		String moduleName = parmMap.get("moduleName");
		String prefix = parmMap.get("prefix");
		String basepackage = parmMap.get("basepackage");
		String author = parmMap.get("author");
		// 生成Service实现代码
		String interfaceName = prefix + moduleName;
		String implName = prefix + moduleName + "Impl";
		StringBuffer sb = new StringBuffer();
		// 包名
		sb.append("package " + basepackage + "." + moduleName.toLowerCase() + ".impl;");
		sb.append(EnumShortcut.NL2.getValue());
		// 实现类注释
		String comment = GenClassHeadComment.gen(implName, author);
		sb.append(comment);
		// 实现类注解
		if ("Dao".equals(moduleName)) {
			sb.append("@Repository(\"" + StringUtil.toLowerCaseFirstOne(implName) + "\")");
		} else {
			sb.append("@Service(\"" + StringUtil.toLowerCaseFirstOne(implName) + "\")");
		}
		sb.append(EnumShortcut.NL.getValue());
		// 实现类
		sb.append("public class " + implName + " implements " + interfaceName + "{");
		sb.append(EnumShortcut.NL2.getValue());
		// 生成注入Dao
//		if (globalConfig.getManagerPrefix() != null && !globalConfig.getManagerPrefix().equals("")) {
//			sb.append("\t@Autowired\r\n");
//			sb.append("\tprivate " + globalConfig.getDaoPrefix() + "DAO " + StringUtil.toLowerCaseFirstOne(globalConfig.getDaoPrefix()) + "Dao" + ";");
//
//			sb.append("\r\n");
//			sb.append("\r\n");
//		}
		// 生成所有方法
		String methodsCode = GenMethodCode.getCode(parmMap,methods);
		sb.append(methodsCode);
		// 闭合大括号
		sb.append("}");

		return sb.toString();
	}
}
