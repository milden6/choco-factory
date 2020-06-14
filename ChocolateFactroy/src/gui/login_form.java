package gui;

import chocofactory.Queries;
import chocofactory.Session;
import chocofactory.User;

import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class login_form extends JFrame{
    private JTextField user_name;
    private JPasswordField password;
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

            if (user_name.getText().equals("") || password.equals("")){
                showMessageDialog(null, "Заполните поля");
            }
            else{

            Queries queries = new Queries();
            User user = null;

            user = queries.getUser(user_name.getText(), String.valueOf(password.getPassword()));

            if (user == null){
                showMessageDialog(null, "Ошибка авторизации");
            }
            else {
                Session.currentUserId = Integer.parseInt(user.userId);
                Session.currentUser = user.userName;
                dispose();
                home_form homeForm = new home_form();
            }
            }
        });
    }
}
