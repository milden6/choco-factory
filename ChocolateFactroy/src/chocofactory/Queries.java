package chocofactory;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Queries {

    Connection connection = DBConnection.connection;
    Statement statement;
    ResultSet resultSet;

    public User getUser(String username, String password) {

        User user = null;

        try {
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM users " +
                    "WHERE username = '" + username + "'" +
                    "AND password = '" + password +  "'");

            while (resultSet.next()){
                user = new User(resultSet.getString("user_id"),
                                resultSet.getString("username"),
                                resultSet.getString("password"),
                                resultSet.getString("created_on"));
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }

        return user;
    }
}
