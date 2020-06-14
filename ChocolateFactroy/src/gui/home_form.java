package gui;

import chocofactory.Session;

import javax.swing.*;

public class home_form extends JFrame{
    private JTabbedPane tabbedPane1;
    private JTextField start_period;
    private JTextField parties_count;
    private JTextField end_period;
    private JButton add_to_report;
    private JButton save;
    private JButton send;
    private JTable table1;
    private JLabel choco_count_in_partie;
    private JLabel time_of_production;
    private JLabel pack_type;
    private JLabel current_user;
    private JTable table2;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JTable table3;
    private JComboBox comboBox2;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton button2;
    private JPanel root_panel;

    public home_form() {
        setContentPane(root_panel);
        pack();
        setLocationRelativeTo(null);
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        current_user.setText(Session.currentUser);
    }
}
