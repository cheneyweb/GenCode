/**
 * @Title: GenMethodCode.java
 * @Package: com.cheney.gen.code
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月27日 下午3:49:20
 * @version: V1.0
 */
package com.cheney.gencode.gen.java.common;

import java.util.List;
import java.util.Map;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.gen.java.comment.GenMethodComment;
import com.cheney.gencode.module.Method;

/**
 * @Moudle: GenMethodCode
 * @version:v1.0
 * @Description: 生成方法代码
 * @author: xuyushuai
 * @date: 2014年10月27日 下午3:49:20
 *
 */
public class GenMethodCode {
    /**
     *
     * <p>Title: getcode</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月27日 下午4:05:51</p>
     * 
     * @param methods
     * @param globalConfig
     * @return 方法代码
     */
    public static String getCode(Map<String,String> parmMap,List<Method> methods) {
    	// 入参设置
    	String author = parmMap.get("author");
        String code = "";
        // 循环生成每个Method方法
        for (int i = 0; i < methods.size(); i++) {
            // 生成方法注释
            String comment = GenMethodComment.gen(methods.get(i).getName(), methods.get(i).getInParamMap(), methods.get(i).getReturnType(), author);
            code += comment;
            // 重写注解
            code += EnumShortcut.TAB.getValue();
            code += "@Override";
            code += EnumShortcut.NL.getValue();
            // 方法头
            code += EnumShortcut.TAB.getValue();
            code += "public ";
            code += methods.get(i).getReturnType();
            code += " ";
            code += methods.get(i).getName();
            code += "(";
            int j = 0;
            Map<String, String> inParamMap = methods.get(i).getInParamMap();
            for (String inParam : inParamMap.keySet()) {
                code += inParamMap.get(inParam);
                code += " ";
                code += inParam;
                if (j < inParamMap.size() - 1) {
                    code += ",";
                }
                j++;
            }
            code += "){";
            code += EnumShortcut.NL.getValue();
            // log
            code += EnumShortcut.TAB2.getValue();
            code += "log.info(\"\");";
            code += EnumShortcut.NL.getValue();
            // try catch
            code += EnumShortcut.TAB2.getValue();
            code += "try{";
            code += EnumShortcut.NL2.getValue();
            code += EnumShortcut.TAB2.getValue();
            code += "}catch(Exception e){";
            code += EnumShortcut.NL.getValue();
            code += EnumShortcut.TAB3.getValue();
            code += "log.error(e.getMessage());";
            code += EnumShortcut.NL.getValue();
            code += EnumShortcut.TAB2.getValue();
            code += "}";
            code += EnumShortcut.NL.getValue();

            if(!methods.get(i).getReturnType().equals("void") && !methods.get(i).getReturnType().equals("")){
            	code += EnumShortcut.TAB2.getValue();
                code += "return null;";
                code += EnumShortcut.NL.getValue();
            }
            //方法闭合括号
            code += EnumShortcut.TAB.getValue();
            code += "}";
            code += EnumShortcut.NL.getValue();
        }
        return code;
    }
}
