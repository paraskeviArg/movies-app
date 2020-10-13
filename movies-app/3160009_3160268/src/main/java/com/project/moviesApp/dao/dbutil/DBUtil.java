package com.project.moviesApp.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static Connection conn;

    private DBUtil() {}

    public static Connection openConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/moviesapp?useSSL=false";
        String username = "root";
        String password = "ψασπερ1998μυσ;λ";
        conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void closeConnection() throws SQLException {
        conn.close();
    }
}
