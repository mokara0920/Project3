import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

public class SetupSystemConfigUI {
    public JFrame view;

    public JButton btnReturn = new JButton("Return to Admin Home");
    public JButton btnApply = new JButton("Apply");

    public JLabel label = new JLabel("I do not know what to put here.\n" +
            "We were not given any instructions");

    public SetupSystemConfigUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Setup System Configuration");
        view.setSize(600, 400);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Setup System Configuration");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel line = new JPanel();
        line.add(label);
        view.getContentPane().add(line);


        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnReturn);
        panelButtons.add(btnApply);

        view.getContentPane().add(panelButtons);
    }

    public void run() {
        view.setVisible(true);
    }

}
