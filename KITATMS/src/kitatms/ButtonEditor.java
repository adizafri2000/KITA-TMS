/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import com.itextpdf.text.DocumentException;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author adiza
 */
public class ButtonEditor extends DefaultCellEditor{
    protected JButton btn;
    private String lbl;
    private Boolean clicked;
    private DBConnection con;
    private Account acc;
    private String courseID;
    private Course course;
    
    //Window 1 is for View Learning Materials, window 2 is for Assessment Window
    private int window;

    /**
     * Window 1 is for View Learning Materials window to open Learning Materials.
     * @param txt
     * @param window 
     */
    public ButtonEditor(JTextField txt, DBConnection con,Account acc,String fileName) {
        
        super(txt);
        this.con = con;
        this.acc = acc;
        Course c = new Course();
        c.setCourseID(courseID);
        System.out.printf("BUTTON EDITOR CLASS: %s viewing material of %s\n",acc.username,fileName);
        
        btn=new JButton();
        btn.setOpaque(true);
        
        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    fireEditingStopped();
                    File file = new File(fileName);

                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Error");
                    }

                    System.out.println("Finished.");
                }
            }
        );

    }
    
    public ButtonEditor(JTextField txt, DBConnection con,Account acc,Course course){
        super(txt);
        this.con = con;
        this.acc = acc;
        this.course = course;
        System.out.printf("BUTTON EDITOR CLASS: %s attempting assessment of %s\n",acc.username,course.getCourseID());
        
        btn=new JButton();
        btn.setOpaque(true);
        
        //WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                    fireEditingStopped();
                    new AttemptAssessmentWindow(con,acc,course);
                }
            }
        );
    }
        

    //OVERRIDE A COUPLE OF METHODS
    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
    boolean selected, int row, int col) {

        //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
        lbl=(obj==null) ? "":obj.toString();
        btn.setText(lbl);
        clicked=true;
        return btn;
    }

    //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if(clicked)
        {
            //SHOW US SOME MESSAGE
            //JOptionPane.showMessageDialog(btn, lbl+" Clicked");
        }
        //SET IT TO FALSE NOW THAT ITS CLICKED
        clicked=false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {

        //SET CLICKED TO FALSE FIRST
        clicked=false;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        // TODO Auto-generated method stub
        super.fireEditingStopped();
    }
}
