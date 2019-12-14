import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomeUI {
    public JFrame view;

    public JButton btnSetupSystemConfiguration = new JButton("Setup System Configuration");
    public JButton btnAddNewUser = new JButton("Add New User");
    public JButton btnRemoveUser = new JButton("Remove User");

    public AdminHomeUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Admin Home");
        view.setSize(600, 400);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Admin Home");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnSetupSystemConfiguration);
        panelButtons.add(btnAddNewUser);
        panelButtons.add(btnRemoveUser);

        view.getContentPane().add(panelButtons);


        btnSetupSystemConfiguration.addActionListener(
                new ActionListener() {
                    //@Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        SetupSystemConfigUI ui = new SetupSystemConfigUI();
                        ui.run();
                    }
                });
        btnAddNewUser.addActionListener(
                new ActionListener() {
                    //@Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        AddNewUserUI ui = new AddNewUserUI();
                        ui.run();
                    }
                });
        btnRemoveUser.addActionListener(
                new ActionListener() {
                    //@Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        RemoveUserUI ui = new RemoveUserUI();
                        ui.run();
                    }
                });

    }
}
