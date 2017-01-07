package com.cheney.gencode.gen.java.comment;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.util.string.StringUtil;

/**
 * @Moudle: GenAttributeSetComment
 * @version:v1.0
 * @Description: 生成属性的Set方法的注释
 * @author: xuyushuai
 * @date: 2014年10月24日 下午3:27:04
 *
 */
public class GenAttributeSetComment {
    /**
    *
    * <p>Title: genAttributeSetComment</p>
    * <p>author : xuyushuai</p>
    * <p>date : 2014年10月24日 下午3:33:54</p>
    * @param column
    * @param attributeComment
    * @param attributeType
    * @return set方法的注释
    */ 
    public static String gen(String column, String attributeComment, String attributeType) {
        String comment = "";
        comment += EnumShortcut.TAB.getValue();
        comment += "/**";
        comment += EnumShortcut.NL.getValue();
        comment += EnumShortcut.TAB.getValue();
        comment += " * 设置" + StringUtil.columnToAttribute(column, "_");
        comment += EnumShortcut.NL.getValue();
        comment += EnumShortcut.TAB.getValue();
        comment += " * ";
        comment += EnumShortcut.NL.getValue();
        comment += EnumShortcut.TAB.getValue();
        comment += " * @param ";
        /*if (attributeType == null) {
            attributeType = "Date";
        }
        comment += attributeType;
        comment += " ";
        comment += attributeComment;*/
        comment += StringUtil.columnToAttribute(column, "_");
        comment += EnumShortcut.NL.getValue();
        comment += EnumShortcut.TAB.getValue();
        comment += " */";
        comment += EnumShortcut.NL.getValue();
        
        return comment;
    }
}
