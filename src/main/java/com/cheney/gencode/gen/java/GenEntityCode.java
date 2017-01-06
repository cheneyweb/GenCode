package com.cheney.gencode.gen.java;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.cheney.gencode.enums.EnumDataType;
import com.cheney.gencode.enums.EnumShortcut;
import com.cheney.gencode.gen.comment.GenAttributeComment;
import com.cheney.gencode.gen.comment.GenAttributeGetComment;
import com.cheney.gencode.gen.comment.GenAttributeSetComment;
import com.cheney.gencode.gen.comment.GenClassHeadComment;
import com.cheney.gencode.gen.common.GenAttributeCode;
import com.cheney.gencode.gen.common.GenAttributeGetMethodCode;
import com.cheney.gencode.gen.common.GenAttributeSetMethodCode;
import com.cheney.gencode.gen.common.GenClassHeadCode;
import com.cheney.gencode.gen.module.GenEntity;
import com.cheney.gencode.module.Entity;
import com.cheney.gencode.util.db.SQLUtil;
import com.cheney.gencode.util.string.StringUtil;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.create.table.CreateTable;

/**
 * @Moudle: GenDtoCode
 * @version:v1.0
 * @Description: 生成dto代码
 * @author: xuyushuai
 * @date: 2014年10月21日 下午5:28:31
 *
 */
public class GenEntityCode {
	private static Map<String, String> tableMap;

	private static Map<String, String> commentMap;

	private static Map<String, String> dataTypeMap = EnumDataType.toMap();

	/**
	 *
	 * <p>Title: gen</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2014年10月22日 下午6:02:32</p>
	 * 
	 * @param document
	 * @throws IOException
	 */
	public static Map<String,String> gen(Map<String,String> parmMap) {
		Map<String,String> resultMap = new HashMap<String,String>();
		resultMap.put("respMsg","Y");
		try {
			// 入参设置
			Entity entity = GenEntity.getEntity(parmMap);
			String basepackage = parmMap.get("basepackage");
			String author = parmMap.get("author");
			String createTableSql = parmMap.get("createTableSql");
			String columnCommentSql = parmMap.get("columnCommentSql");
			
			StringBuffer sb = new StringBuffer();
			// 设置类名
			CreateTable createTableStmt = (CreateTable)CCJSqlParserUtil.parse(createTableSql.trim());
			String beanPrefix = StringUtil.tableNameToClassName(createTableStmt.getTable().getName(),"TABLE_","_");
			String dtoName = beanPrefix + "Entity";
			// 获取所需的属性map
			tableMap = SQLUtil.getColumnNameAndTypeMap(createTableSql);
			commentMap = SQLUtil.getColumnNameAndCommentMap(columnCommentSql);

			// 包名
			sb.append("package " + basepackage + ".dto;"+EnumShortcut.NL2.getValue());
			// 生成类头部注释
			String comment = GenClassHeadComment.gen(dtoName, author);
			sb.append(comment);

			// 生成Dto类头部
			String classHead = GenClassHeadCode.gen(dtoName, entity);
			sb.append(classHead);

			// 循环生成每个字段
			for (String key : tableMap.keySet()) {
				// 生成属性注释
				String attributeComment = GenAttributeComment.gen(key, commentMap.get(key));
				sb.append(attributeComment);
				// 生成属性
				String attribute = GenAttributeCode.gen(tableMap, dataTypeMap, key);
				sb.append(attribute);
			}

			// 循环生成get和set方法
			for (String key : tableMap.keySet()) {
				// 生成get注释
				String attributeGetComment = GenAttributeGetComment.gen(key, commentMap.get(key), dataTypeMap.get(tableMap.get(key)));
				sb.append(attributeGetComment);
				// get方法
				String attributeGetMethod = GenAttributeGetMethodCode.gen(tableMap, dataTypeMap, key);
				sb.append(attributeGetMethod);
				// 生成set注释
				String attributeSetComment = GenAttributeSetComment.gen(key, commentMap.get(key), dataTypeMap.get(tableMap.get(key)));
				sb.append(attributeSetComment);
				// set方法
				String attributeSetMethod = GenAttributeSetMethodCode.gen(tableMap, dataTypeMap, key);
				sb.append(attributeSetMethod);
			}
			// 结尾闭合大括号
			sb.append("}");
			resultMap.put("code",sb.toString());
			return resultMap;
		} catch (Exception e) {
			resultMap.put("respMsg","生成代码出错");
			return resultMap;
		}
	}
}
