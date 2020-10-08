/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 * @version 1.0 11/09/98
 */
public class JButtonTableExample extends JFrame {

  public JButtonTableExample() {
    super("JButtonTable Example");

    DefaultTableModel dm = new DefaultTableModel();
    dm.setDataVector(new Object[][] { { "button 1", "foo" },
        { "button 2", "bar" } }, new Object[] { "Button", "String" });

    JTable table = new JTable(dm);
    table.getColumn("Button").setCellRenderer(new ButtonRenderer2());
    //table.getColumn("Button").setCellEditor(
      //  new ButtonEditor2(new JCheckBox()));
    JScrollPane scroll = new JScrollPane(table);
    getContentPane().add(scroll);
    setSize(400, 100);
    setVisible(true);
  }
}
/**
 * @version 1.0 11/09/98
 */

class ButtonRenderer2 extends JButton implements TableCellRenderer {

  public ButtonRenderer2() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}

/**
 * @version 1.0 11/09/98
 */

class ButtonEditor2 extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;
  private DBConnection con;

  public ButtonEditor2(JCheckBox checkBox,DBConnection con) {
    super(checkBox);
    this.con = con;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
          try {
              //
              //
              String lmID = label.substring(label.length()-20,label.length()-10);
              String tID = label.substring(label.length()-10);
              String showthis = tID+" viewing "+lmID;
              //JOptionPane.showMessageDialog(button, showthis + ": Ouch!");
              String query = "select * from learningMaterial where learningMaterialID='"+lmID+"';";
              String fileName = con.retrieve(query,"learningMaterialName").get(0);
              File file = new File(fileName);
              Desktop desktop = Desktop.getDesktop();
              try {
                  query = "select * from view where accountID='"+tID+"' and learningMaterialID = '"+lmID+"';";
                  if(con.retrieve(query, "viewstatus").isEmpty()){
                      System.out.printf("%s has not viewed %s\n",tID,lmID);
                      query = "insert into view values('"+lmID+"','"+tID+"','V');";
                      con.update(query);
                  }
                  else{
                      System.out.printf("%s has already viewed %s\n",tID,lmID);
                  }
                  desktop.open(file);
              } catch (IOException ex) {
                  //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println("Error");
              }
              // System.out.println(label + ": Ouch!");
          } catch (SQLException ex) {
              //Logger.getLogger(ButtonEditor2.class.getName()).log(Level.SEVERE, null, ex);
          }
        // System.out.println(label + ": Ouch!");
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}

class ButtonEditor3 extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;
  private DBConnection con;
  private boolean canAttempt,passed;

  public ButtonEditor3(JCheckBox checkBox,DBConnection con,boolean canAttempt,boolean passed) {
    super(checkBox);
    this.con = con;
    this.canAttempt = canAttempt;
    this.passed = passed;
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
        String cID = label.substring(label.length()-19,label.length()-12); //Logger.getLogger(ButtonEditor2.class.getName()).log(Level.SEVERE, null, ex);
        // System.out.println(label + ": Ouch!");
        String tID = label.substring(label.length()-12,label.length()-2);
        String showthis = tID+" attempting "+cID;
        JOptionPane.showMessageDialog(button, showthis + ": Ouch!");
        
        canAttempt = label.charAt(label.length()-2)=='f' ? false : true;
        passed = label.charAt(label.length()-1)=='f' ? false : true;
        
        Course course = new Course();
        course.setCourseID(cID);
        Account acc = new Account();
        acc.setUsername(tID);
        System.out.printf("At ButtonEditor3.getCellEditorValue(): %s from %s course (Can attempt: %s,Has passed: %s)\n",acc.username,course.getCourseID(),canAttempt,passed);
        new AttemptAssessmentWindow(con,acc,course,canAttempt,passed);
    }
    isPushed = false;
    return new String(label);
  }

  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}
