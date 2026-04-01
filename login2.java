
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class login2 extends JFrame{
    private JPanel panel1;

    private JTextField Name;
    private JPasswordField Pass;
    private JButton button5;
    private JLabel inputIpass;
    private JLabel inputName;
    private JButton cancelButton;
    private JButton routeButton;
    private JLabel error;

    public login2 () {
        setTitle("School bus Tracking System");
        setContentPane(panel1);
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String [] columns = {
                "Name", "Student ID",
        };




        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userName = Name.getText();
                String pass = new String(Pass.getPassword());

                if (userName.equals("Admin") && pass.equals("admin")) {
                    JOptionPane.showMessageDialog(login2.this, "Log-in Successful!");
                    Dashboard Dash = new Dashboard();
                    Dash.setVisible(true);
                    login2.this.dispose();
                    SwingUtilities.getWindowAncestor(button5).dispose();

             } else {
                    JOptionPane.showMessageDialog(login2.this, "Invalid Username or password." +"\n               Try Again!!");

                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                dispose();
                new Dashboard();

            }
        });
    }


public static void main(String[] args) {
    new login2();
}
}
