package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conn {

    private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "nam321321";
    private static Connection connection;

    public Connection getConnection() {
        if (connection == null) {
            return initConnection();
        }
        return connection;
    }

    private Connection initConnection() {
        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLException " + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
