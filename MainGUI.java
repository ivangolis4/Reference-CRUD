import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private CRUD hr;
    private JFrame frame;
    private JTable recordTable;
    private DefaultTableModel tableModel;

    public MainGUI() {
        hr = new CRUD();
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Product Management System");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel inputPanel = new JPanel();
        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);

        JLabel idLabel = new JLabel("Product ID:");
        inputPanel.add(idLabel);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openProductOperationFrame(new AddProductFrame(hr));
            }
        });
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openProductOperationFrame(new DeleteProductFrame(hr));
            }
        });
        inputPanel.add(deleteButton);

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openProductOperationFrame(new UpdateProductFrame(hr, null));
            }
        });
        inputPanel.add(updateButton);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openProductOperationFrame(new SearchProductFrame(hr));
            }
        });
        inputPanel.add(searchButton);


        // Table setup
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Quantity");

        recordTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(recordTable);
        frame.getContentPane().add(tableScrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    protected void openProductOperationFrame(UpdateProductFrame updateProductFrame) {
    }

    private void openProductOperationFrame(ProductOperationFrame productOperationFrame) {
        productOperationFrame.setVisible(true);
        productOperationFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                displayRecords();
            }
        });
    }

    void displayRecords() {
        tableModel.setRowCount(0);
        for (Record record : hr.getList()) {
            Object[] rowData = {record.getId(), record.getProductName(), record.getQty()};
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainGUI();
            }
        });
    }
}

