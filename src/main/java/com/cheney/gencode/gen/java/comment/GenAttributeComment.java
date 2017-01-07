package com.cheney.gencode.gen.java.comment;

import com.cheney.gencode.enums.EnumShortcut;

/**
 * @Moudle: GenAttributeComment
 * @version:v1.0
 * @Description: 生成属性的注释
 * @author: xuyushuai
 * @date: 2014年10月24日 下午3:01:27
 *
 */
public class GenAttributeComment {
    /**
     *
     * <p>Title: gen</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月24日 下午3:08:06</p>
     * 
     * @param column 表字段
     * @param attributeComment 表字段注释
     * @return javabean属性的注释
     */
    public static String gen(String column, String attributeComment) {
        String comment = "";
        comment += EnumShortcut.TAB.getValue();
        comment += "/**";
        comment += EnumShortcut.NL.getValue();
        comment += EnumShortcut.TAB.getValue();
        comment += " * ";
        comment += attributeComment;
        comment += EnumShortcut.NL.getValue();
        comment += EnumShortcut.TAB.getValue();
        comment += " */";
        comment += EnumShortcut.NL.getValue();
        
        return comment;
    }
}
