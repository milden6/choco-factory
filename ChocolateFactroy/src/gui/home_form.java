package gui;

import chocofactory.ProducedChoco;
import chocofactory.Queries;
import chocofactory.Session;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class home_form extends JFrame{
    private JTabbedPane tabbedPane1;
    private JTextField start_period;
    private JTextField choco_name;
    private JTextField end_period;
    private JButton create_report;
    private JTable prod_choc_tab;
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
    private JPanel build_report;
    private JScrollPane tab_panel;

    public home_form() {
        setContentPane(root_panel);
        pack();
        setLocationRelativeTo(null);
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        current_user.setText(Session.currentUser);

        create_report.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Queries queries = new Queries();
                ArrayList<ProducedChoco> producedChocos = new ArrayList<>();

                ArrayList<String> ids = new ArrayList<>();
                ArrayList<String> dates = new ArrayList<>();
                ArrayList<String> names = new ArrayList<>();
                ArrayList<Integer> counts = new ArrayList<>();

                producedChocos = queries.getProducedChoco();

                for (ProducedChoco prodChoco:producedChocos) {
                    ids.add(prodChoco.id);
                    dates.add(prodChoco.date);
                    names.add(prodChoco.chocoName);
                    counts.add(prodChoco.count);
                }

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Номер", ids.toArray());
                model.addColumn("Дата", dates.toArray());
                model.addColumn("Наименование", names.toArray());
                model.addColumn("Количество", counts.toArray());
                JTable table = new JTable(model);

                tab_panel.setViewportView(table);

                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame("Charts");

                        frame.setSize(600, 400);
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setVisible(true);

                        DefaultXYDataset ds = new DefaultXYDataset();

                        double[][] data = { {0.1, 0.2, 0.3}, {1, 2, 3} };

                        ds.addSeries("series1", data);

                        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                                "x", "y", ds, PlotOrientation.VERTICAL, true, true,
                                false);

                        ChartPanel cp = new ChartPanel(chart);

                        frame.getContentPane().add(cp);
                    }
                });

            }
        });
    }
}
