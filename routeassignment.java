import javax.swing.*;

public class routeassignment extends JFrame{
    private JPanel panelmain;
    private JComboBox routeComboBox;
    private JTextField busTextField;
    private JTextField stopTextField;
    private JList studentList;

    routeassignment () {
        setTitle("Bus Management System");
        setContentPane(panelmain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 500);

        routeComboBox.addActionListener(e -> {
            String selected = (String)
                    routeComboBox.getSelectedItem();
            if ("City Proper".equals(selected)) {
                busTextField.setText("Bus 1234");
                stopTextField.setText("City Proper");
                studentList.setListData(new String[]{"John", "Sarah"});
            } else if ("Jaro Plaza".equals(selected)) {
                busTextField.setText("Bus 1235");
                stopTextField.setText("Jaro Plaza");
                studentList.setListData(new String[]{"Mike", "Anna"});

            } else if ("Lapuz".equals(selected)) {
                busTextField.setText("Bus 1236");
                stopTextField.setText("Lapuz");
                studentList.setListData(new String[]{"Shane", "Jayne"});

            } else if ("Leganes".equals(selected)) {
                busTextField.setText("Bus 1237");
                stopTextField.setText("Leganes");
                studentList.setListData(new String[]{"Jhon Rey", "Shuby"});

            } else if ("Pavia".equals(selected)) {
                busTextField.setText("Bus 1238");
                stopTextField.setText("Pavia");
                studentList.setListData(new String[]{"Twerl", "Babe"});

            } else if ("Festive Walk".equals(selected)) {
                busTextField.setText("Bus 1239");
                stopTextField.setText("Festive Walk");
                studentList.setListData(new String[]{"Maria Lazaro", "Juan Mango", "Angela Parcon",
                        "Dean Alfonso", "Shyla Tupaz", "Ronald Tupaz", "Mark Osorio"});
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {
        new routeassignment();
    }
}
