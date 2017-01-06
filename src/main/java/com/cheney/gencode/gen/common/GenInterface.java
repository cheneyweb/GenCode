package com.cheney.gencode.gen.common;

import java.util.List;
import java.util.Map;

import com.cheney.gencode.gen.comment.GenMethodComment;
import com.cheney.gencode.module.GlobalConfig;
import com.cheney.gencode.module.Method;

/**
 * @Moudle: GenInterface
 * @version:v1.0
 * @Description: 生成接口
 * @author: xuyushuai
 * @date: 2014年10月27日 下午4:15:12
 *
 */
public class GenInterface {

	/**
	 * <p>Title: getCode</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年5月4日 上午10:50:03</p>
	 * @param methods
	 * @param globalConfig
	 * @return 接口
	 */
	public static String getCode(List<Method> methods, GlobalConfig globalConfig) {
		String code = "";
		for (int i = 0; i < methods.size(); i++) {
			// 生成方法注释
			String comment = GenMethodComment.gen(methods.get(i).getName(), methods.get(i).getInParamMap(), methods.get(i).getReturnType(), globalConfig.getAuthor());
			code += comment;
			// 单位接口
			code += "\tpublic ";
			code += methods.get(i).getReturnType();
			code += " ";
			code += methods.get(i).getName();
			code += "(";
			Map<String, String> inParamMap = methods.get(i).getInParamMap();
			int j = 0;
			for (String inParam : inParamMap.keySet()) {
				code += inParamMap.get(inParam);
				code += " ";
				code += inParam;
				if (j < inParamMap.size() - 1) {
					code += ",";
				}
				j++;
			}
			code += ");";
			code += "\r\n";
			code += "\r\n";
		}
		return code;
	}

	/**
	 *
	 * <p>
	 * Title: getHeadCode
	 * </p>
	 * <p>
	 * author : xuyushuai
	 * </p>
	 * <p>
	 * date : 2014年10月27日 下午4:30:47
	 * </p>
	 * 
	 * @param serviceInterfaceName
	 * @return 接口头部代码
	 */
	public static String getHeadCode(String serviceInterfaceName) {
		String code = "";
		code += "public interface ";
		code += serviceInterfaceName;
		code += "{";
		code += "\r\n";
		code += "\r\n";
		return code;
	}
}
