/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class AssessmentWindow extends javax.swing.JFrame {

    static DBConnection con;
    private Account trainee = new Account();
    private ArrayList<String> courseIDList = new ArrayList<>();
    private DefaultTableModel dtm = new DefaultTableModel();
    
    public AssessmentWindow(DBConnection con,Account acc){
        this.con = con;
        this.trainee = acc;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssessmentWindow(acc).setVisible(true);
            }
        });
    }
        
    /**
     * Creates new form Assessment
     */
    private AssessmentWindow(Account acc) {
        trainee = acc;
        System.out.println("Assessment Window, username: "+trainee.username);
        this.setupCourseIDList();
        initComponents();
        this.addRow(this.courseIDList.get(0));
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
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel3 = new javax.swing.JLabel();
        instructionLabel = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        noEnrollmentLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(529, 42));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        jLabel1.setText("ASSESSMENT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 382, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Please complete the course assessment: ");

        instructionLabel.setForeground(new java.awt.Color(102, 102, 102));
        instructionLabel.setText("*Click [Start] to attempt assessment");

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setText("Back to home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        noEnrollmentLabel.setForeground(new java.awt.Color(0, 0, 0));
        noEnrollmentLabel.setText("You are currently not enrolled to any courses");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(instructionLabel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(noEnrollmentLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeButton)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructionLabel)
                .addGap(18, 18, 18)
                .addComponent(noEnrollmentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(homeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new TraineeHomeWindow(con,trainee);
    }//GEN-LAST:event_homeButtonActionPerformed


    
    private void addRow(String courseID){
        //column 1 = course Name
        //column 2 = course ID
        //column 3 = marks (IF ATTEMPTED PREVIOUSLY)
        //column 4 = attempt date (IF ATTEMPTED PREVIOUSLY)
        //column 5 = start button
        String courseName, attemptDate, marks;
        courseName = attemptDate = marks = " ";
        
        String courseNameQuery = "select * from course where courseID='"+courseID+"';";
        try {
            courseName = con.retrieve(courseNameQuery, "courseName").get(0);
        } catch (SQLException ex) {
            //Logger.getLogger(AssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean hasAttempted = true;
        try {
            ArrayList<String> checker = con.retrieve("select * from attempt where accountID='"+trainee.username+"';","accountID");
            if(checker.isEmpty())
                hasAttempted = false;
        } catch (SQLException ex) {
            //Logger.getLogger(AssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(hasAttempted){
            try {
                marks = con.retrieve("select * from attempt where accountID='"+trainee.username+"';", "attemptMarks").get(0);
                attemptDate = con.retrieve("select * from attempt where accountID='"+trainee.username+"';", "attemptDate").get(0);
            } catch (SQLException ex) {
                //Logger.getLogger(AssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            marks = "-";
            attemptDate = "-";
        }
        //jLabel2.setText(courseName);
        //jLabel5.setText(courseID);
        //jLabel6.setText(marks);
        //jLabel8.setText(attemptDate);
        
        Course course = new Course();
        course.setCourseID(courseID);
        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                AttemptAssessmentWindow AAW = new AttemptAssessmentWindow(con,trainee,course);
                AAW.setCourse(course);
                AAW.setTrainee(trainee);
            }
        });
    }
    
    /**
     * Retrieves all enrolled course's course ID for this trainee
     */
    private void setupCourseIDList(){
        String traineeID = trainee.username;
        
        String query = "Select * from enrollment where accountID='"+traineeID+"';";
        try {
            courseIDList = con.retrieve(query, "courseID");
            System.out.println("Enrolled courses:");
            for(String s:courseIDList){
                System.out.println(s);
            }
        } catch (SQLException ex) {
            //Logger.getLogger(AssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTrainee(){
        //trainee = t;
        System.out.println("Usename: "+trainee.username);
        setupCourseIDList();
        addRow(courseIDList.get(0));
    }
    
    private void buildTable(){
        jTable1.setModel(dtm);
        tableModel.addColumn("Course ID");
        tableModel.addColumn("Learning Material");
        tableModel.addColumn("View Status");
        tableModel.addColumn("View");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel instructionLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel noEnrollmentLabel;
    // End of variables declaration//GEN-END:variables
}
