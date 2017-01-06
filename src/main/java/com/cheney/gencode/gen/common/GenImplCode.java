package com.cheney.gencode.gen.common;

import java.util.List;

import com.cheney.gencode.gen.comment.GenClassHeadComment;
import com.cheney.gencode.gen.module.GenGlobalConfig;
import com.cheney.gencode.module.GlobalConfig;
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
	public static String gen(String moduleName, List<Method> methods) {

		GlobalConfig globalConfig = GenGlobalConfig.getGlobalConfig();
		// 生成Service实现文件
		String interfaceName = globalConfig.getServicePrefix() + moduleName;
		String implName = globalConfig.getServicePrefix() + moduleName + "Impl";
		StringBuffer sb = new StringBuffer();

		// 包名
		sb.append("package " + globalConfig.getBasepackage() + "." + moduleName.toLowerCase() + ".impl;\r\n\r\n");
		// 实现类注释
		String comment = GenClassHeadComment.gen(implName, globalConfig.getAuthor());
		sb.append(comment);
		// 实现类注解
		if ("Dao".equals(moduleName)) {
			sb.append("@Repository(\"" + StringUtil.toLowerCaseFirstOne(implName) + "\")");
		} else {
			sb.append("@Service(\"" + StringUtil.toLowerCaseFirstOne(implName) + "\")");
		}
		sb.append("\r\n");
		// 实现类
		sb.append("public class " + implName + " implements " + interfaceName + "{");
		sb.append("\r\n");
		sb.append("\r\n");
		// 生成注入Manager或Dao
		if (globalConfig.getManagerPrefix() != null && !globalConfig.getManagerPrefix().equals("")) {
			sb.append("\t@Autowired\r\n");
			if ("Service".equals(moduleName)) {
				sb.append("\tprivate " + globalConfig.getManagerPrefix() + "Manager " + StringUtil.toLowerCaseFirstOne(globalConfig.getManagerPrefix()) + "Manager" + ";");
			} else if ("Manager".equals(moduleName)) {
				sb.append("\tprivate " + globalConfig.getDaoPrefix() + "DAO " + StringUtil.toLowerCaseFirstOne(globalConfig.getDaoPrefix()) + "Dao" + ";");
			}
			sb.append("\r\n");
			sb.append("\r\n");
		}
		// 生成所有方法
		String methodsCode = GenMethodCode.getCode(methods, globalConfig);
		sb.append(methodsCode);
		// 闭合大括号
		sb.append("}");

		return sb.toString();
	}
}
