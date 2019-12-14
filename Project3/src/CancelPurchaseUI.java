import javax.swing.*;
import java.awt.*;

public class CancelPurchaseUI {
    public JFrame view;

    public JButton btnReturn = new JButton("Return to Customer Home");
    public JButton btnRemovePurchase = new JButton("Remove Purchase");

    public JLabel purchaseID = new JLabel("PurchaseID");
    public JLabel Name = new JLabel("Name");
    public JLabel price = new JLabel("Price");
    public JLabel quantity = new JLabel("Quantity");

    public JTextField txtPurchaseID = new JTextField(20);
    public JTextField txtName = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtQuantity = new JTextField(20);

    public CancelPurchaseUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Remove Purchase");
        view.setSize(600, 400);

        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Remove Purchase");

        title.setFont (title.getFont ().deriveFont (24.0f));
        view.getContentPane().add(title);

        JPanel line1 = new JPanel();
        line1.add(purchaseID);
        line1.add(txtPurchaseID);
        view.getContentPane().add(line1);


        JPanel line2 = new JPanel();
        line2.add(Name);
        line2.add(txtName);
        view.getContentPane().add(line2);


        JPanel line3 = new JPanel();
        line3.add(price);
        line3.add(txtPrice);
        view.getContentPane().add(line3);


        JPanel line4 = new JPanel();
        line4.add(quantity);
        line4.add(txtQuantity);
        view.getContentPane().add(line4);


        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnReturn);
        panelButtons.add(btnRemovePurchase);

        view.getContentPane().add(panelButtons);

    }

    public void run() {
        view.setVisible(true);
    }
}
