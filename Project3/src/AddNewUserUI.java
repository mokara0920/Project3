import javax.swing.*;
import java.awt.*;

public class AddNewUserUI {
    public JFrame view;

    public JButton btnReturn = new JButton("Return to Admin Home");
    public JButton btnAddUser = new JButton("Add User");

    public JLabel username = new JLabel("Username");
    public JLabel password = new JLabel("Password");
    public JLabel fullname = new JLabel("Full Name");
    public JLabel usertype = new JLabel("User Type");

    public JTextField txtUsername = new JTextField(20);
    public JTextField txtPassword = new JTextField(20);
    public JTextField txtFullname = new JTextField(20);
    public JTextField txtUsertype = new JTextField(20);

    public AddNewUserUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Add New User");
        view.setSize(600, 400);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Add New User");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel line1 = new JPanel();
        line1.add(username);
        line1.add(txtUsername);
        view.getContentPane().add(line1);


        JPanel line2 = new JPanel();
        line2.add(password);
        line2.add(txtPassword);
        view.getContentPane().add(line2);


        JPanel line3 = new JPanel();
        line3.add(fullname);
        line3.add(txtFullname);
        view.getContentPane().add(line3);


        JPanel line4 = new JPanel();
        line4.add(usertype);
        line4.add(txtUsertype);
        view.getContentPane().add(line4);


        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnReturn);
        panelButtons.add(btnAddUser);

        view.getContentPane().add(panelButtons);

    }

    public void run() {
        view.setVisible(true);
    }

}
