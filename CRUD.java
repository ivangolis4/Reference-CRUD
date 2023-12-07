import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;



public class CRUD {
    private LinkedList<Record> list;

    public CRUD() {
        list = new LinkedList<>();
    }

    public Record findRecord(int idNumber) {
        for (Record l : list) {
            if (l.getId() == idNumber) {
                return l;
            }
        }
        return null;
    }

    public void add(Record record) {
        if (!find(record.getId())) {
            list.add(record);
        } else {
            // Print statement
            System.out.println("Record already exists in the Record list");
        }
    }

    public boolean find(int idNumber) {
        for (Record l : list) {
            if (l.getId() == idNumber) {
                System.out.println(l);
                return true;
            }
        }
        return false;
    }

    public void delete(int recIdNumber) {
        Record recordDel = null;

        for (Record ll : list) {
            if (ll.getId() == recIdNumber) {
                recordDel = ll;
            }
        }

        if (recordDel == null) {
            System.out.println("Invalid record Id");
        } else {
            list.remove(recordDel);
            System.out.println("Successfully removed record from the list");
        }
    }

      

    public void update(int id, Record updatedRecord) {
        if (find(id)) {
            Record rec = findRecord(id);
            rec.setId(updatedRecord.getId());
            rec.setProductName(updatedRecord.getProductName());
            rec.setQty(updatedRecord.getQty());
            System.out.println("Record Updated Successfully");
        } else {
            System.out.println("Record Not Found in the Product list");
        }
    }

    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list has no records\n");
        }

        for (Record record : list) {
            System.out.println(record.toString());
        }
    }

    public List<Record> getList() {
        return list;
    }

    
}

class UpdateProductFrame extends JFrame {
    private CRUD hr;
    private MainGUI mainGUI;
    private JTextField idField, nameField, qtyField;
    private DefaultTableModel tableModel;
    private LinkedList<Record> lists;
    public UpdateProductFrame(CRUD hr, DefaultTableModel tableModel) {
        this.hr = hr;
        this.tableModel = tableModel;
        

        setTitle("Update Product");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        String idInput = JOptionPane.showInputDialog("Enter Product ID:");
        int id = Integer.parseInt(idInput);

        
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
