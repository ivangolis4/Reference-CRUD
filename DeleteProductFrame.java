import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProductFrame extends ProductOperationFrame {
    private JTextField idField;
    private CRUD hr;

    public DeleteProductFrame(CRUD hr) {
        this.hr = hr;
    }

    @Override
    protected void initialize() {
        setTitle("Delete Product");
        setSize(300, 100);

        JPanel panel = new JPanel(new GridLayout(2, 2));

        panel.add(new JLabel("Product ID:"));
        idField = new JTextField();
        panel.add(idField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProduct();
            }
        });
        panel.add(deleteButton);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
    }

    @Override
    protected void onFrameClosed() {
        // You can perform any cleanup or additional actions when the frame is closed.
    }

    private void deleteProduct() {
        int id = Integer.parseInt(idField.getText());
        hr.delete(id);
        JOptionPane.showMessageDialog(this, "Product deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        dispose(); // Close the frame after deleting the product
    }
}

