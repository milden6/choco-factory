import chocofactory.DBConnection;
import gui.login_form;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        DBConnection.create_connection();
        login_form loginForm = new login_form();
        //Session.currentUser = "debug";
        //home_form homeForm = new home_form();
    }
}