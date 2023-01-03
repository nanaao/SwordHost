package com.swordHostDemo.Dao;

import java.sql.*;

/**
 * @date: 2022/12/31 10:39
 * @description:
 */
//操作数据库的公共类
public class BaseDao {
    public static void executeUpdateSQL(String sql) {
        //用于执行sql语句
        Statement stmt;
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            stmt = conn.createStatement();

            stmt.setQueryTimeout(60);
            //打印输出语句
            System.out.println(sql);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static String executeSelectSQL(String sql,String namevalues) {
        //用于执行sql语句
        PreparedStatement pstmt;
        Connection conn = null;
        ResultSet rs;
        String namevalue = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:data.db");
            pstmt = conn.prepareStatement(sql);
//            System.out.println(sql);
            pstmt.setQueryTimeout(60);

            pstmt.setString(1, namevalues);

           rs = pstmt.executeQuery();
            while (rs.next()) {
                namevalue =rs.getString("namevalue");
//                System.out.println(namevalue);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return namevalue;
    }
}
