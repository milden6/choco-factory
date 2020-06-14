package chocofactory;

import java.sql.*;

public class DBConnection {

    static final String DB_URL = "jdbc:postgresql://localhost:5432/choco_factory";
    static final String USER = "admin";
    static final String PASS = "admin";
    static Connection connection = null;

    public static void create_connection() {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

}
