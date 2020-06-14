package chocofactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Queries {

    Connection connection = DBConnection.connection;
    Statement statement;
    ResultSet resultSet;

    User user;

    ArrayList<User> users;

    public ArrayList<User> readUsers(String sqlQuery) throws SQLException {

        users = new ArrayList<>();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()){
                user = new User(resultSet.getString("user_id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("created_on"));
                users.add(user);
            }
        }
        catch (SQLException sqlException){
            System.out.println(sqlException);
        }

        return users;
    }
}
