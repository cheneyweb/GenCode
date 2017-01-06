package com.cheney.gencode.util.db;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;

/**
 * @Moudle: SQLUtil 
 * @version:v1.0
 * @Description: SQL解析引擎
 * @author: xuyushuai
 * @date: 2015年4月28日 上午10:00:32
 *
 */
public class SQLUtil {
	/**
	 * <p>Title: 根据SQL解析表的列名和类型</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年4月28日 上午11:13:13</p>
	 * @param createTableSql
	 * @return
	 */
	public static Map<String, String> getColumnNameAndTypeMap(String createTableSql) {
		Map<String, String> resultMap = new HashMap<String, String>();
			try {
				createTableSql = createTableSql.trim();
				CreateTable createTableStmt = (CreateTable)CCJSqlParserUtil.parse(createTableSql);
				List<ColumnDefinition> columnDefinitionList = createTableStmt.getColumnDefinitions();
				for(ColumnDefinition columnDefinition : columnDefinitionList){
					resultMap.put(columnDefinition.getColumnName(),columnDefinition.getColDataType().getDataType());
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		return resultMap;
	}

	/**
	 * <p>Title: 根据SQL解析表的列名和注释</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年4月28日 上午11:13:50</p>
	 * @param columnCommentSql
	 * @return
	 */
	public static Map<String, String> getColumnNameAndCommentMap(String columnCommentSql) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			if(StringUtils.isNotBlank(columnCommentSql)){
				columnCommentSql = columnCommentSql.trim();
				String[] columns = columnCommentSql.split(";");
				for (String column : columns) {
					String columnAndComment = column.split("\\.")[1];
					String name = columnAndComment.split(" ")[0];
					String comment = columnAndComment.split(" ")[2].substring(1, columnAndComment.split(" ")[2].length() - 1);
					map.put(name, comment);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}
}
