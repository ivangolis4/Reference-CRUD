import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProductFrame extends JFrame {
    private CRUD hr;
    private MainGUI mainGUI;
    private JTextField idField, nameField, qtyField;

    public UpdateProductFrame(CRUD hr, MainGUI mainGUI) {
        this.hr = hr;
        this.mainGUI = mainGUI;

        setTitle("Update Product");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel idLabel = new JLabel("Product ID:");
        idField = new JTextField();
        JLabel nameLabel = new JLabel("Product Name:");
        nameField = new JTextField();
        JLabel qtyLabel = new JLabel("Quantity:");
        qtyField = new JTextField();

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProduct();
            }
        });

        panel.add(idLabel);
        panel.add(idField);
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(qtyLabel);
        panel.add(qtyField);
        panel.add(updateButton);

        add(panel);
        setVisible(true);
    }

    private void updateProduct() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int qty = Integer.parseInt(qtyField.getText());

            Record updatedRecord = new Record(id, qty, name);
            hr.update(id, updatedRecord);

            mainGUI.displayRecords();
            JOptionPane.showMessageDialog(this, "Product updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Close the frame after successful update
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for ID and Quantity.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
