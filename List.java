import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class List extends JFrame {
    private JPanel panel1;
    private JButton listButton;
    private JButton studentButton;
    private JButton enterButton;
    private JLabel Stat;
    private JTextField Name;
    private JButton button1;
    private JTable listTable;
    private JTextField IDN;
    private JButton busManangementButton;
    private DefaultTableModel listStudents;

    public List() {
        setTitle("School bus Tracking System");
        setContentPane(panel1);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String[] columns = {
                "Name", "Student ID", "Status"
        };
        listStudents = new DefaultTableModel(columns, 0);
        listTable.setModel(listStudents);

        loadTableFromStorage();
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sName = Name.getText();
                String sID = IDN.getText();
                if (sName.isEmpty() || sID.isEmpty()) {
                    JOptionPane.showMessageDialog(List.this,
                            "Missing fields, please fill up all boxes",
                            "", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        });
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId   = IDN.getText().trim();
                String studentName = Name.getText().trim();
                String[] names = {
                        "Jayne Reina Osorio", "Maria Lazaro", "Juan Mango",
                        "Angela Parcon", "Shane Glendale", "Twerlbabe Vinas",
                        "Dean Alfonso", "Shyla Tupaz", "Ronald Tupaz", "Mark Osorio"
                };
                String[] ids = {
                        "0001", "0002", "0003", "0004", "0005",
                        "0006", "0007", "0008", "0009", "0010"
                };
                boolean found = false;
                if (studentId.isEmpty() || studentName.isEmpty()) {
                    JOptionPane.showMessageDialog(List.this,
                            "Please enter ID and Name",
                            "Missing Fields",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                for (int i = 0; i < names.length; i++) {
                    if (studentId.equals(ids[i]) &&
                            studentName.equalsIgnoreCase(names[i])) {
                        found = true;
                        break;
                    }
                }
                if (found) {

                    boolean alreadyAdded = false;
                    for (String[] existing : BusDataStorage.getInstance().busList) {
                        if (existing[1].equals(studentId)) {
                            alreadyAdded = true;
                            break;
                        }
                    }
                    if (alreadyAdded) {
                        JOptionPane.showMessageDialog(List.this,
                                studentName + " is already in the list.",
                                "Already Added",
                                JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(List.this,
                            "You've been added to the list " + studentName +
                                    ". Please wait for the School Bus to arrive.");

                    String[] newEntry = { studentName, studentId, "Enrolled" };
                    BusDataStorage.getInstance().busList.add(newEntry);

                    listStudents.addRow(newEntry);
                    Name.setText("");
                    IDN.setText("");
                } else {
                    JOptionPane.showMessageDialog(List.this,
                            "Student not enrolled",
                            "Access Denied",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Dashboard();
            }
        });
        busManangementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }

    private void loadTableFromStorage() {
        listStudents.setRowCount(0);
        for (String[] student : BusDataStorage.getInstance().busList) {
            listStudents.addRow(student);
        }
    }
    public static void main(String[] args) {
        new List();
    }
}
