package com.swordHostDemo.utls;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @date: 2022/12/30 18:12
 * @description:
 */
public class SQLiteUtls {

    //初始化
    public static void init() {
        sqlTable(initTable());
    }

    public static String initTable() {
        String sql = "";
        if (!checkDbFile()) {
            createSQLiteDB();
            String menuTable = "CREATE TABLE IF NOT EXISTS `menu` (" +
                    "`name`  VARCHAR(40) NOT NULL," +
                    "`namevalue`  VARCHAR(40) NOT NULL" +
                    ");";
            String customTable = "CREATE TABLE IF NOT EXISTS `custom` (" +
                    "`name` VARCHAR(40) NOT NULL," +
                    "`namevalue` VARCHAR(40) NOT NULL" +
                    ");";
            String insertCustomInit = "INSERT INTO custom (name,namevalue) VALUES ('customValue','');";
            String insertMenuInit = "INSERT INTO menu (name,namevalue) VALUES ('Lhost','');\n" +
                    "INSERT INTO menu (name,namevalue) VALUES ('Lport','');\n" +
                    "INSERT INTO menu (name,namevalue) VALUES ('DnsLog','');\n" +
                    "INSERT INTO menu (name,namevalue) VALUES ('Rhost','');\n" +
                    "INSERT INTO menu (name,namevalue) VALUES ('Rport','');\n" +
                    "INSERT INTO menu (name,namevalue) VALUES ('Command','');\n"+
                    "INSERT INTO menu (name,namevalue) VALUES ('FileName','');";
            sql = menuTable + customTable + insertMenuInit + insertCustomInit;
        }
        return sql;

    }

    //创建数据库
    public static void createSQLiteDB() {
        {
            Connection c = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:data.db");
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Opened database successfully");
        }
    }

    public static boolean checkDbFile() {
            return (new File( "data.db")).exists();
        }

        //执行sql语句
    public static void sqlTable(String sql) {
        {
            Connection c = null;
            Statement stmt = null;
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:data.db");
                System.out.println("Opened database successfully");
                stmt = c.createStatement();
                stmt.executeUpdate(sql);
                stmt.setQueryTimeout(60);
                stmt.close();
                c.close();
            } catch (Exception e) {
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
                System.exit(0);
            }
            System.out.println("Table created successfully");
        }
    }

    public static String deleteSQLiteDB() {
        String insertCustomInit = "INSERT INTO custom (name,namevalue) VALUES ('customValue','');";
        String insertMenuInit = "INSERT INTO menu (name,namevalue) VALUES ('Lhost','');\n" +
                "INSERT INTO menu (name,namevalue) VALUES ('Lport','');\n" +
                "INSERT INTO menu (name,namevalue) VALUES ('DnsLog','');\n" +
                "INSERT INTO menu (name,namevalue) VALUES ('Rhost','');\n" +
                "INSERT INTO menu (name,namevalue) VALUES ('Rport','');\n" +
                "INSERT INTO menu (name,namevalue) VALUES ('Command','');";
        return insertCustomInit + insertMenuInit;
    }

}