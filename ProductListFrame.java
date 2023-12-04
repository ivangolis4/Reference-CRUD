import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ProductListFrame extends ProductOperationFrame {
    private JTable recordTable;
    private DefaultTableModel tableModel;
    private CRUD hr;

    public ProductListFrame(CRUD hr) {
        this.hr = hr;
    }

    @Override
    protected void initialize() {
        setTitle("Product List");
        setSize(600, 400);

        // Table setup
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Quantity");

        recordTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(recordTable);
        getContentPane().add(tableScrollPane, BorderLayout.CENTER);

        displayRecords();
    }

    @Override
    protected void onFrameClosed() {
        // You can perform any cleanup or additional actions when the frame is closed.
    }

    private void displayRecords() {
        List<Record> records = hr.getList();
        tableModel.setRowCount(0);
        for (Record record : records) {
            Object[] rowData = {record.getId(), record.getProductName(), record.getQty()};
            tableModel.addRow(rowData);
        }
    }
}

