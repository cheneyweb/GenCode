package com.cheney.gencode.gen.java.common;

import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.cheney.gencode.module.Entity;
import com.cheney.gencode.util.db.SQLUtil;
import com.cheney.gencode.util.string.StringUtil;
import com.cheney.gencode.util.vm.ToolBox;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.create.table.CreateTable;

public class GenEntityClassCode {
	public static String gen(Map<String, String> parmMap, Entity entity) throws JSQLParserException {
		String code = "";
		// 入参设置
		String basepackage = parmMap.get("basepackage");
		String createTableSql = parmMap.get("createTableSql");
		String columnCommentSql = parmMap.get("columnCommentSql");
		// 设置类名
		CreateTable createTableStmt = (CreateTable) CCJSqlParserUtil.parse(createTableSql.trim());
		String className = StringUtil.tableNameToClassName(createTableStmt.getTable().getName(),entity.getTablePrefix(), "_");
		entity.setClassName(className);
		// 获取所需的属性map
		Map<String, String> columnMap = SQLUtil.getColumnNameAndTypeMap(createTableSql, "_");
		Map<String, String> commentMap = SQLUtil.getColumnNameAndCommentMap(columnCommentSql, "_");
		// 设置包名
		parmMap.put("packageName", basepackage +".entity;");
		// 根据模板生成代码
		VelocityEngine velocityEngine = new VelocityEngine();
		VelocityContext velocityContext = new VelocityContext();
		StringWriter stringWriter = new StringWriter();
		velocityContext.put("entity", entity);
		velocityContext.put("columnMap", columnMap);
		velocityContext.put("commentMap", commentMap);
		velocityContext.put("parmMap", parmMap);
		velocityContext.put("toolBox", new ToolBox());
		velocityEngine.mergeTemplate("src/main/resources/templates/code/java/entity.vm", "UTF-8", velocityContext,stringWriter);
		code += stringWriter.toString();

		return code;

	}
}
