package com.rns.myproject;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ORMConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mavenproject";
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Pratham@1";

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null; // or handle the exception appropriately
        }
    }
}
