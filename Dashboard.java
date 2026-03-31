
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JPanel panel1;

    private JButton listButton;
    private JButton studentButton;
    private JTextField pp;
    private JTextField nm;
    private JComboBox <String> Drop;
    private JButton busManagementButton;

    public Dashboard() {

        setTitle("School bus Tracking System");
        setContentPane(panel1);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Drop.addItem("WVSU");
        Drop.addItem("WIT");
        Drop.addItem("St. Therese");
        Drop.addItem("ISAT");


        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new List().setVisible(true);
            }
        });
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Dashboard().setVisible(true);

            }
        });
        busManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new busmanagement().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}