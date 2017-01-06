/**
 * @Title: GenMethodCode.java
 * @Package: com.cheney.gen.code
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月27日 下午3:49:20
 * @version: V1.0
 */
package com.cheney.gencode.gen.common;

import java.util.List;
import java.util.Map;

import com.cheney.gencode.gen.comment.GenMethodComment;
import com.cheney.gencode.module.GlobalConfig;
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
    public static String getCode(List<Method> methods, GlobalConfig globalConfig) {
        String code = "";
        // 循环生成每个Method方法
        for (int i = 0; i < methods.size(); i++) {
            // 生成方法注释
            String comment = GenMethodComment.gen(methods.get(i).getName(), methods.get(i).getInParamMap(), methods.get(i).getReturnType(), globalConfig.getAuthor());
            code += comment;
            // 重写注解
            code += "\t@Override";
            code += "\r\n";
            // 方法头
            code += "\tpublic ";
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
            code += "\r\n";
            // log
            code += "\t\t";
            code += "log.info(\"\");";
            code += "\r\n";
            // try catch
            code += "\t\t" + "try{";
            code += "\r\n";
            code += "\r\n";
            code += "\t\t" + "}catch(Exception e){";
            code += "\r\n";
            code += "\t\t\t" + "log.error(e.getMessage());";
            code += "\r\n";
            code += "\t\t" + "}";
            code += "\r\n";

            if(!methods.get(i).getReturnType().equals("void") && !methods.get(i).getReturnType().equals(""))
            {
                code += "\t\treturn null;";
                code += "\r\n";
            }
            //方法闭合括号
            code += "\t" + "}";
            code += "\r\n";
        }
        return code;
    }
}
