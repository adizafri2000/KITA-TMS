package kitatms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ViewLearningMaterialWindow extends javax.swing.JFrame {
    
    static DBConnection con;
    private Account acc;
    private ArrayList<String> courseIDList;
    private JTable jTable2;
    
    public ViewLearningMaterialWindow(DBConnection con,Account acc){
        this.con = con;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLearningMaterialWindow(acc).setVisible(true);
            }
        });
    }

    /**
     * Creates new form ViewLearningMaterial
     */
    private ViewLearningMaterialWindow(Account acc) {
        this.acc = acc;
        System.out.println("View Learning Materials Window, account: "+acc.username);
        initComponents();
        getCourseIDList();
        buildTable();
    }
    
    /** Retrieves a list of courses enrolled into for this trainee.*/
    private void getCourseIDList(){
        try {
            String query = "Select * from enrollment where accoutID='"+acc.username+"';";
            query = "SELECT * FROM kitatms.enrollment where accountID='"+acc.username+"';";
            courseIDList = con.retrieve(query, "CourseID");
            
            for(String s:courseIDList) System.out.printf("Course ID: %s\n",s);
        } catch (SQLException ex) {
            //Logger.getLogger(ViewLearningMaterialWindow.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("View Learning Materials Window: Error in getCourseIDList()");
        }
    }
    
    private void buildTable(){
        String courseID,learningMaterialName,viewStatus,query;
        JButton viewButton = new JButton("View Material");
        ArrayList<String> learningMaterialIDList;
        int row = 1;
        
        //COLUMN HEADERS
        //String columnHeaders[]={"Course ID","Learning Material","View Status","View"};
        //CREATE OUR TABLE AND SET HEADER
        //JTable table=new JTable(data,columnHeaders);


        
        DefaultTableModel tableModel = new DefaultTableModel();
        jTable1.setModel(tableModel);


        
        tableModel.addColumn("Course ID");
        tableModel.addColumn("Learning Material");
        tableModel.addColumn("View Status");
        tableModel.addColumn("View");

        
        
        /*
            One row in the table is in the format:
                CourseID    |   LearningMaterialName    |   ViewStatus  |   Button for Viewing Material
                (string)            (string)                (string)        (JButton)
        */
        
        //Iterate through all the courses enrolled by the trainee
        for(int i=0;i<courseIDList.size();i++){
            try {
                
                //Set the CourseID of column 0
                courseID = courseIDList.get(i);
                
                query = "Select * from learningmaterial where courseID='"+courseID+"';";
                learningMaterialIDList = con.retrieve(query,"learningMaterialID");
                
                for(String s:learningMaterialIDList) System.out.printf("Learning Material ID: %s\n",s);
                
                //Iterate through all the Learning Materials uploaded into a course
                for(int j=0;j<learningMaterialIDList.size();j++){
                    
                    //Set the LearningMaterialName of column 1
                    query = "Select * from learningmaterial where learningMaterialID='"+learningMaterialIDList.get(j)+"';";
                    learningMaterialName = con.retrieve(query, "learningMaterialName").get(0);
                    
                    query = "Select * from view where accountID='"+acc.username+"' and learningmaterialID='"+learningMaterialIDList.get(j)+"';";
                    if(con.retrieve(query, "viewstatus").size()>0)
                        viewStatus = "Viewed";
                    else viewStatus = "Not Viewed";
                    
                    String label = "View                    \n"+learningMaterialIDList.get(j)+acc.username;
                    tableModel.addRow(new Object[]{courseID,learningMaterialName,viewStatus,label});
                    row++;
                    
                    
                    //SET CUSTOM EDITOR TO TEAMS COLUMN
                    //jTable1.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JTextField(),con,acc,learningMaterialName));
                    //jTable1.getCo
                    
                    jTable1.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer2());
                    jTable1.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor2(new JCheckBox(),con));
                }
                
                //SET CUSTOM RENDERER TO TEAMS COLUMN
                //jTable1.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
                
            } catch (SQLException ex) {
                //Logger.getLogger(ViewLearningMaterialWindow.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("View Learning Materials Window: Error in buildTable()");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        windowNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(544, 17));
        jPanel2.setMinimumSize(new java.awt.Dimension(544, 17));
        jPanel2.setPreferredSize(new java.awt.Dimension(529, 42));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        homeButton.setText("Back to home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        windowNameLabel.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        windowNameLabel.setText("LEARNING MATERIALS");

        jTable1.setModel(jTable1.getModel());
        jTable1.setRowSelectionAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(windowNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 101, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton)
                .addGap(19, 19, 19))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(windowNameLabel)
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(homeButton)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new TraineeHomeWindow(con,acc);
    }//GEN-LAST:event_homeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel windowNameLabel;
    // End of variables declaration//GEN-END:variables
}
