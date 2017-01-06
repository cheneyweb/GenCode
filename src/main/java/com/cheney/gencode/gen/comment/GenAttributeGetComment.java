/**
 * @Title: GenAttributeGetComment.java
 * @Package: com.cheney.gen.comment
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月24日 下午3:18:50
 * @version: V1.0
 */
package com.cheney.gencode.gen.comment;

import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.util.string.StringUtil;

/**
 * @Moudle: GenAttributeGetComment
 * @version:v1.0
 * @Description: 生成属性的Get方法的注释
 * @author: xuyushuai
 * @date: 2014年10月24日 下午3:18:50
 *
 */
public class GenAttributeGetComment {
	/**
	*
	* <p>Title: gen</p>
	* <p>author : xuyushuai</p>
	* <p>date : 2014年10月24日 下午3:22:48</p>
	* @param column
	* @param attributeComment
	* @param attributeType
	* @return get方法的注释
	*/
	public static String gen(String column, String attributeComment, String attributeType) {
		String comment = "";
		comment += EnumShortcut.TAB.getValue();
		comment += "/**";
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " * 取得" + StringUtil.columnToAttribute(column, "_");
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " * ";
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " * @return ";
		if (attributeType == null) {
			attributeType = "Date";
		}
		comment += attributeType;
		comment += " ";
		comment += attributeComment;
		comment += EnumShortcut.NL.getValue();
		comment += EnumShortcut.TAB.getValue();
		comment += " */";
		comment += EnumShortcut.NL.getValue();
		return comment;
	}
}
