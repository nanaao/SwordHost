package com.swordHostDemo.utls;


import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @date: 2022/12/28 16:15
 * @description:
 */
public class SQLiteUtils {
    public static void init() {
        Connection connection;
        if (!checkDbFile()) {
            System.out.println("db文件不存在，程序将自动创建！");
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:rules.db");
                // 创建表
                setTable(connection);
                connection.close();
            } catch (Exception e) {
            }
        }
    }

    public static boolean checkDbFile() {
        return (new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "rules.db")).exists();
    }

    /**
     * 初始化rules表
     */
    private static void setTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE rules(" +
                "initVaule TEXT PRIMARY KEY," +
                "Vaule TEXT NOT NULL," +
                "description TEXT)";
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        ArrayList<String> list = new ArrayList<String>() {{
            add("INSERT INTO \"rules\" (\"initVaule\", \"Vaule\", \"description\") VALUES ('rhost', 'rhost', NULL)");
            add("INSERT INTO \"rules\" (\"initVaule\", \"Vaule\", \"description\") VALUES ('rport', 'rport', NULL)");
            add("INSERT INTO \"rules\" (\"initVaule\", \"Vaule\", \"description\") VALUES ('lhost', 'lhost', NULL)");
            add("INSERT INTO \"rules\" (\"initVaule\", \"Vaule\", \"description\") VALUES ('lport', 'lport', NULL)");
            add("INSERT INTO \"rules\" (\"initVaule\", \"Vaule\", \"description\") VALUES ('DnsLog', 'DnsLog=', NULL)");
            add("INSERT INTO \"rules\" (\"initVaule\", \"Vaule\", \"description\") VALUES ('Command', 'Command=', NULL)");
        }};
        for (String i : list) {
            stmt.executeUpdate(i);
        }
        stmt.close();
    }

    public static Map<String, String> matchRule(String queryTxt) {
        Connection connection;
        PreparedStatement stmt;
        HashMap<String, String> res = new HashMap<>();
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:rules.db");
            String sql = "select initVaule,Vaule from rules where initVaule like ?";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + queryTxt + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                res.put(rs.getString("initVaule"), rs.getString("Vaule"));
            }
            connection.close();
            stmt.close();
            return res;
        } catch (Exception e) {
        }
        return res;
    }

    public static boolean insertRule(Map<String, String> rule) {
        Connection connection;
        PreparedStatement stmt;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:rules.db");
            String sql = "INSERT INTO \"rules\" (\"initVaule\", \"Vaule\", \"description\") VALUES (?,?,?)";
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, rule.get("initVaule"));
            stmt.setString(2, rule.get("Vaule"));
            stmt.setString(3, rule.get("rule_description"));
            stmt.executeUpdate();
            connection.close();
            stmt.close();
            return true;
        } catch (Exception e) {

            return false;
        }
    }
}
