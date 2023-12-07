import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;


public class RetrieveProductFrame extends ProductOperationFrame {
    // private JTextField idField;
    private CRUD hr;
    private DefaultTableModel tableModel;

    public RetrieveProductFrame(CRUD hr, DefaultTableModel tableModel) {
        this.hr = hr;
        this.tableModel = tableModel;
        initialize();
    }

    @Override
    protected void initialize() {
        setTitle("Search Product");
        setSize(300, 100);

        JPanel panel = new JPanel(new GridLayout(2, 2));
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
        
    }

    private void searchProduct() {
        
        String idInput = JOptionPane.showInputDialog("Enter Product ID:");

        
        if (idInput != null) {
            try {
                int id = Integer.parseInt(idInput);

                
                Record record = hr.findRecord(id);

                if (record != null) {
                    JOptionPane.showMessageDialog(this, "PID: "+record.getId()+"\nProduct Name: "+record.getProductName()+"\nQuantity: "+record.getQty(), "Record", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Product ID does not exist", "Not Found", JOptionPane.WARNING_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value for ID.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
