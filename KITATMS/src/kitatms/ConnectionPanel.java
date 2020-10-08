/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

public class ConnectionPanel extends JFrame{

    public ConnectionPanel(){

        Object[][] licData = {{"License 1", "0.0.0.0", "connect", "disconnect", ""},{"License 2", "123.123.123", "", "", ""},{"License 3", "42.23.4", "connect", "disconnect", "delete"}};

        ConnTableModel licConnModel = new ConnTableModel(licData);

        this.setLayout(new MigLayout("", "[grow]", "[][grow][][][][][][][grow][][][][][]"));
        this.setSize(new Dimension(500, 300));
        JLabel lblLicenses = new JLabel("Licenses");
        this.add(lblLicenses, "cell 0 0,growx");

        JTable licenseTable = new JTable(licConnModel);
        licenseTable.setTableHeader(null);

        new ButtonColumn2(licenseTable, 2, 0);
        new ButtonColumn2(licenseTable, 3, 0);
        new ButtonColumn2(licenseTable, 2, 2);
        new ButtonColumn2(licenseTable, 3, 2);
        new ButtonColumn2(licenseTable, 4, 2);

        JScrollPane scrollPaneLic = new JScrollPane();
        scrollPaneLic.setViewportView(licenseTable);
        this.add(scrollPaneLic, "cell 0 1 1 6,grow");
    }
    
    public static class ConnTableModel extends AbstractTableModel {
        Object[][] data;

        public ConnTableModel(Object[][] data){
            this.data = data;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return data[0].length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) { 
            if(columnIndex == 2 || columnIndex == 3 || columnIndex == 4) {
                return true;
            } else {
                return false;
            }
        }   
    }
    
    class ButtonColumn2 extends AbstractCellEditor
    implements TableCellRenderer, TableCellEditor, ActionListener
    {
        JTable table;
        JButton editButton;
        JButton renderButton;
        String text;
        int showRow;

        public ButtonColumn2(JTable table, int column, int showRow) {
            super();
            this.table = table;
            this.showRow = showRow;
            renderButton = new JButton();

            editButton = new JButton();
            editButton.setFocusPainted( false );
            editButton.addActionListener( this );

            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(column).setCellRenderer( this );
            columnModel.getColumn(column).setCellEditor( this );
        }

        @Override
        public Object getCellEditorValue() {
             return text;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            fireEditingStopped();

            if(text.equals("connect")){
                System.out.println("conn");
            }else if(text.equals("disconnect")){
                System.out.println("disc");
            }
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean selected, int row,
                int column) {
            if(row == showRow){
             text = (value == null) ? "" : value.toString();
                editButton.setText( text );
                return editButton;
            }else{
                return null;
            }
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean hasFocus,
                int row, int column) {
            if (hasFocus) {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            } else if (selected) {
                renderButton.setForeground(table.getSelectionForeground());
                 renderButton.setBackground(table.getSelectionBackground());
            } else {
                renderButton.setForeground(table.getForeground());
                renderButton.setBackground(UIManager.getColor("Button.background"));
            }

            renderButton.setText((value == null) ? "" : value.toString());
            if(row == showRow) {
                return renderButton;
            } else {
                return null;
            }
        }

    }
}
    

    
