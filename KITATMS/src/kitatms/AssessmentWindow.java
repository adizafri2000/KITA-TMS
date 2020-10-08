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
    private JTable table = new JTable();
    
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
        jLabel4 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        noEnrollmentLabel = new javax.swing.JLabel();

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

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("*Click [Start] to attempt assessment");

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setText("Back to home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("jLabel2");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel8.setText("jLabel8");

        jButton1.setText("Start");

        noEnrollmentLabel.setForeground(new java.awt.Color(0, 0, 0));
        noEnrollmentLabel.setText("You are currently not enrolled to any courses");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(homeButton)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(noEnrollmentLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel5)
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel6)
                                        .addGap(57, 57, 57)
                                        .addComponent(jLabel8)))
                                .addGap(72, 72, 72)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(21, 21, 21)
                .addComponent(noEnrollmentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
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

    private void setupTable(){
        setupCourseIDList();
        JTable table = new JTable();
        for(int i=0;i<1;i++){
            addRow(courseIDList.get(i));
        }
        
    }
    
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
        jLabel2.setText(courseName);
        jLabel5.setText(courseID);
        jLabel6.setText(marks);
        jLabel8.setText(attemptDate);
        
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
        jButton1 = startButton;
        
        //DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       // model.addRow(new Object[]{courseName,courseID,marks,attemptDate,startButton});
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel noEnrollmentLabel;
    // End of variables declaration//GEN-END:variables
}
