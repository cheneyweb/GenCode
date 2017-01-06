package com.cheney.gencode.gen.comment;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cheney.gencode.enums.EnumShortcut;

/**
 * @Moudle: GenClassHeadComment
 * @version:v1.0
 * @Description: 生成类头部注释
 * @author: xuyushuai
 * @date: 2014年10月24日 下午3:43:11
 *
 */
public class GenClassHeadComment {
    /**
     *
     * <p>Title: gen</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月24日 下午3:46:33</p>
     * 
     * @param className
     * @param authorName
     * @return 类头部的注释
     */
    public static String gen(String className, String authorName) {
        String comment = "";
        comment += "/**";
        comment += EnumShortcut.NL.getValue();
        comment += " * @Module: ";
        comment += className;
        comment += EnumShortcut.NL.getValue();
        comment += " * @version:v1.0";
        comment += EnumShortcut.NL.getValue();
        comment += " * @Description: ";
        comment += EnumShortcut.NL.getValue();
        comment += " * @author: ";
        comment += authorName;
        comment += EnumShortcut.NL.getValue();
        comment += " * @date: ";
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        comment += df.format(date);
        comment += EnumShortcut.NL.getValue();
        comment += " */";
        comment += EnumShortcut.NL.getValue();

        return comment;
    }
}
