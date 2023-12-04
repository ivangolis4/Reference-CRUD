import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchProductFrame extends ProductOperationFrame {
    private JTextField idField;
    private CRUD hr;

    public SearchProductFrame(CRUD hr) {
        this.hr = hr;
    }

    @Override
    protected void initialize() {
        setTitle("Search Product");
        setSize(300, 100);

        JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Product ID:"));
        idField = new JTextField();
        panel.add(idField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchProduct();
            }
        });
        panel.add(searchButton);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
    }

    @Override
    protected void onFrameClosed() {
        // You can perform any cleanup or additional actions when the frame is closed.
    }

    private void searchProduct() {
        int id = Integer.parseInt(idField.getText());
        if (!hr.find(id)) {
            JOptionPane.showMessageDialog(this, "Product ID does not exist", "Not Found", JOptionPane.WARNING_MESSAGE);
        }
    }
}
