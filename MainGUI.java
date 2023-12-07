import javax.swing.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
public class MainGUI extends JFrame{
    private final Font MainFont = new Font("Tactic Sans",Font.BOLD,20);
    JPanel MainPanel, ButtonPanel, TablePanel;
    JButton btnAdd,btnRetrieve,btnUpdate,btnDelete;
    JLabel MainLabel;
    private JTable recordTable;
    private DefaultTableModel tableModel;
    JFrame Frame;
    CRUD hr;

    public MainGUI() {
        hr = new CRUD();
        initialize();
    }

    public void initialize(){

        /* Labels */
        MainLabel = new JLabel("Product Management System");
        MainLabel.setFont(MainFont);



        /* Buttons */
        btnAdd = new JButton("ADD");
        btnAdd.setFont(MainFont);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                openProductOperationFrame(new AddProductFrame(hr));
            }
        });

        btnRetrieve = new JButton("RETRIEVE");
        btnRetrieve.setFont(MainFont);
        btnRetrieve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                openProductOperationFrame(new RetrieveProductFrame(hr, tableModel));
            }
        });

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setFont(MainFont);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                openProductOperationFrame(new UpdateProductFrame(hr, tableModel));
            }
        });

        btnDelete = new JButton("DELETE");
        btnDelete.setFont(MainFont);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        /* TABLE */
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Quantity");

        recordTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(recordTable);
        /* Pannels */

        TablePanel = new JPanel();
        TablePanel.setLayout(new GridLayout(1,1,1,1));
        TablePanel.setFocusable(false);
        TablePanel.add(tableScrollPane);

        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(1, 4, 1, 1));
        ButtonPanel.setFocusable(false);
        ButtonPanel.add(btnAdd);
        ButtonPanel.add(btnRetrieve);
        ButtonPanel.add(btnUpdate);
        ButtonPanel.add(btnDelete);
        

        MainPanel = new JPanel();
        MainPanel.setLayout(new BorderLayout());
        MainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        MainPanel.setOpaque(false);
        MainPanel.add(TablePanel, BorderLayout.CENTER);
        MainPanel.add(ButtonPanel,BorderLayout.NORTH);
        

        /* Pannels */
        Frame = new JFrame("Product Management System");
        Frame.setResizable(false);
        Frame.setSize(700,500);
        Frame.setLocationRelativeTo(null);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.add(MainPanel);
        Frame.setVisible(true);
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
    

    public static void main(String[]args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                new MainGUI();
            }
        });
    }
    
}
