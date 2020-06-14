package gui;

import chocofactory.Queries;
import chocofactory.User;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class login_form extends JFrame{
    private JTextField user_name;
    private JTextField password;
    private JButton ConfirmButton;
    private JPanel root_panel;

    public login_form() {

        setContentPane(root_panel);
        pack();
        setLocationRelativeTo(null);
        setSize(500, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ConfirmButton.addActionListener(actionEvent -> {

            if (user_name.getText().equals("") || password.getText().equals("")){
                showMessageDialog(null, "Заполните поля");
            }
            else{

            ArrayList<User> users = new ArrayList<>();

            Queries queries = new Queries();
            try {
                users = queries.readUsers("SELECT * FROM users " +
                        "WHERE username = '" + user_name.getText() + "'" +
                        "AND password = '" + password.getText() +  "'");
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }

            if (users.size() != 1){
                showMessageDialog(null, "Ошибка авторизации");
            }
            else {
                dispose();
                //login_form login_form = new login_form();
            }
            }
        });
    }
}
