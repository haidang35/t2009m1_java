package com.t2009m1.accountmodelasm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static final String DATABABSE_URL = "jdbc:mysql://localhost:3306/java_demo_mysql";
    private static final String DATABABSE_USERNAME = "root";
    private static final String DATABABSE_PASSWORD = "";

    public static Connection connection;
    public static Connection getConnection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            if(connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DATABABSE_URL, DATABABSE_USERNAME, DATABABSE_PASSWORD);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
