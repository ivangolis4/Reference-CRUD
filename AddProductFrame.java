import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AddProductFrame extends ProductOperationFrame {
    private JTextField idField, qtyField, nameField;
    private CRUD hr;

    public AddProductFrame(CRUD hr) {
        this.hr = hr;
    }

    @Override
    protected void initialize() {
        setTitle("Add Product");
        setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Product ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Quantity:"));
        qtyField = new JTextField();
        panel.add(qtyField);

        panel.add(new JLabel("Product Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });
        panel.add(addButton);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
    }

    @Override
    protected void onFrameClosed() {
        // You can perform any cleanup or additional actions when the frame is closed.
    }

    private void addProduct() {
        int id = Integer.parseInt(idField.getText());
        int qty = Integer.parseInt(qtyField.getText());
        String name = nameField.getText();
        Record record = new Record(id, qty, name);
        hr.add(record);
        JOptionPane.showMessageDialog(this, "Product added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Close the frame after adding the product
    }
}

