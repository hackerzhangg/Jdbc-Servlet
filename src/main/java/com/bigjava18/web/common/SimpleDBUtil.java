package com.bigjava18.web.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author zgp
 * @Since 2021 -04 -16 09 :31
 * @Description MYSQL数据库工具类
 */
public class SimpleDBUtil {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/mybatisreview?useUnicode=true&characterEncoding=utf8&useSSL=false";
    public static final String USER = "root";
    public static final String PASS = "199872";

    /**
     * Open Connection
     * @return java.sql.Connection
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    /**
     * executeQuery
     * @param sql
     * @param params
     * @return
     */
    public static ResultSet executeQuery(String sql, Object[] params) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            if (params != null) {
                for (int i=0; i<params.length; i++) {
                    pstmt.setObject(i+1, params[i]);
                }
            }
            rs = pstmt.executeQuery();

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
//			closeAll(conn, pstmt, rs);
        }

        return rs;
    }

    /**
     * executeUpdate
     * @param sql
     * @param params
     * @return
     */
    public static int executeUpdate(String sql, Object[] params) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            if (params != null) {
                for (int i=0; i<params.length; i++) {
                    pstmt.setObject(i+1, params[i]);
                }
            }
            return pstmt.executeUpdate();

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            closeAll(conn, pstmt, null);
        }
        return -1;
    }

    /**
     * close and release resources
     * @param conn
     * @param pstmt
     * @param rs
     */
    public static void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception ex) {
            System.out.println("An exception occurred while closing, " + ex.getMessage());
        }
    }
}
