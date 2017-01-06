package com.cheney.gencode.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @Moudle: DBUtil
 * @version:v1.0
 * @Description: 数据库连接工具
 * @author: xuyushuai
 * @date: 2014年10月22日 下午1:35:47
 *
 */
public class DBUtil {

    /**
     *
     * <p>Title: connectOracle</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月22日 下午1:45:26</p>
     * 
     * @param driverClassName
     * @param url
     * @param username
     * @param password
     * @return oracle数据库连接
     */
    public static Connection connectOracle(String driverClassName, String url, String username, String password) {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * <p>Title: getOracleColumnInfo</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月22日 下午2:23:53</p>
     * 
     * @param connection
     * @param table
     * @return Map<字段名，字段类型>
     */
    public static Map<String, String> getOracleColumnNameAndType(Connection connection, String table) {
        String sql = "select COLUMN_NAME,DATA_TYPE from user_tab_columns where table_name =UPPER('" + table + "')";
        Statement st = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String key = rs.getString("COLUMN_NAME"); // 获取字段名
                String val = rs.getString("DATA_TYPE"); // 获取数据类型
                map.put(key, val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    
    /**
    *
    * <p>Title: getOracleColumnComment</p>
    * <p>author : xuyushuai</p>
    * <p>date : 2014年10月22日 下午2:23:53</p>
    * 
    * @param connection
    * @param table
    * @return Map<字段名，字段注释>
    */
   public static Map<String, String> getOracleColumnNameAndComment(Connection connection, String table) {
       String sql = "select * from user_col_comments where table_name =UPPER('" + table + "')";
       Statement st = null;
       Map<String, String> map = new HashMap<String, String>();
       try {
           st = connection.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while (rs.next()) {
               String key = rs.getString("COLUMN_NAME"); // 获取字段名
               String val = rs.getString("COMMENTS"); // 获取数据注释
               map.put(key, val);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return map;
   }
}
