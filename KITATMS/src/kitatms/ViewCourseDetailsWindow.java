package kitatms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static kitatms.CourseReportWindow.con;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ViewCourseDetailsWindow extends javax.swing.JFrame {
    
    static DBConnection con;
    private Account acc;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private ArrayList<String> courseIDList,traineeIDList,assessmentQuestionList,assessmentAnswerList,learningMaterialList;
    String courseName,courseStart,courseEnd;
    
    public ViewCourseDetailsWindow(DBConnection con,Account acc){
        this.con = con;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCourseDetailsWindow(acc).setVisible(true);
            }
        });
    }

    /**
     * Creates new form Viewcoursedetails
     */
    private ViewCourseDetailsWindow(Account acc) {
        this.acc = acc;
        courseIDList = loadCourses();
        initComponents();
        noCourseLabel.setVisible(false);
        if(courseIDList.isEmpty()){
            noCourseLabel.setVisible(true);
            jTable1.setEnabled(false);
            jTable1.setVisible(false);
        }
        buildTable();
        fillTable();
    }
    
    private ArrayList<String> loadCourses(){
        try {
            String query = "select * from course where accountID='"+acc.username+"';";
            return con.retrieve(query, "courseID");
        } catch (SQLException ex) {
            //Logger.getLogger(CourseReportWindow.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Course Report Window: Error in loading courses.");
        }
        return new ArrayList<>();
    }
    
    private void buildTable(){
        jTable1.setModel(tableModel);
        tableModel.addColumn("Course ID");
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Start Date");
        tableModel.addColumn("End Date");
        tableModel.addColumn("Learning Materials");
        tableModel.addColumn("Trainees");
        tableModel.addColumn("Assessment Questions");
        tableModel.addColumn("Assessment Answers");
    }
    
    /**
     * FIlls the JTable with necessary data.
     * Every course will contain at least 5 rows.
     * On the 1st row of each course, all data is displayed. ArrayList data take the 1st (.get(0)) item.
     * On the 2nd row until trainee length, only traineeID, assessmentquestion and assessmentanswers are displayed.
     * On the 6th row until trainee length, only traineeIDs are displayed.
     */
    private void fillTable(){
        String query;
        for(int i=0;i<courseIDList.size();i++){
            try {
                String courseID = courseIDList.get(i);
                query = "Select * from course where courseID='"+courseID+"';";
                
                courseName = con.retrieve(query,"courseName").get(0);
                courseStart = con.retrieve(query,"courseStart").get(0);
                courseEnd = con.retrieve(query,"courseEnd").get(0);
                
                query = "Select * from enrollment where courseID='"+courseID+"';";
                traineeIDList = con.retrieve(query, "accountID");
                
                query = "Select * from assessment where courseID='"+courseID+"';";
                String questions = con.retrieve(query, "assessmentQuestions").get(0);
                System.out.println(questions);
                String[] temp = questions.split("\\$");
                
                assessmentQuestionList = new ArrayList<>();
                assessmentAnswerList = new ArrayList<>();
                
                System.out.println("Viewing splitted questions:");
                for(String s:temp){
                    System.out.println(s);
                    assessmentQuestionList.add(s);
                }
                
                String answers = con.retrieve(query, "assessmentAnswers").get(0);
                for(int n=0;n<5;n++){
                    assessmentAnswerList.add(Character.toString(answers.charAt(n)));
                }
                
                query = "Select * from learningMaterial where courseID='"+courseID+"';";
                learningMaterialList = con.retrieve(query, "learningMaterialName");
                
                int[] arraylength = new int[]{learningMaterialList.size(),traineeIDList.size(),5};
                int totalRows;
                
                totalRows = arraylength[0];
                for(int l=1;l<arraylength.length;l++){
                    if(totalRows<arraylength[l]){
                        totalRows = arraylength[l];
                    }
                }
                
                if(learningMaterialList.size()!=totalRows){
                    int left = totalRows - learningMaterialList.size();
                    for(int q = 0;q<left;q++){
                        learningMaterialList.add(" ");
                    }
                }
                
                if(traineeIDList.size()!=totalRows){
                    int left = totalRows - traineeIDList.size();
                    for(int q = 0;q<left;q++){
                        traineeIDList.add(" ");
                    }
                }
                
                if(5!=totalRows){
                    int left = totalRows - 5;
                    for(int q = 0;q<left;q++){
                        assessmentQuestionList.add(" ");
                        assessmentAnswerList.add(" ");
                    }
                }
                
                
                
                
                for(int j=0;j<totalRows;j++){
                    if(j==0){
                        tableModel.addRow(new Object[]{courseID,courseName,courseStart,courseEnd,learningMaterialList.get(0),traineeIDList.get(0),assessmentQuestionList.get(0),assessmentAnswerList.get(0)});
                    }
                    else{
                        tableModel.addRow(new Object[]{" "," "," "," ",learningMaterialList.get(j),traineeIDList.get(j),assessmentQuestionList.get(j),assessmentAnswerList.get(j)});
                    }
                }
                
                
            } catch (SQLException ex) {
                //Logger.getLogger(ViewCourseDetailsWindow.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel23 = new javax.swing.JLabel();
        jScrollBar2 = new javax.swing.JScrollBar();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        noCourseLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabel23.setText("jLabel23");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel7.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        jLabel7.setText("  Course Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setText("Back to home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        noCourseLabel.setForeground(new java.awt.Color(0, 0, 0));
        noCourseLabel.setText("You have not created any courses. ");

        jTable1.setModel(jTable1.getModel());
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            jTable1.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(homeButton)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(noCourseLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(noCourseLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(homeButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new TrainerHomeWindow(con,acc);
    }//GEN-LAST:event_homeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel noCourseLabel;
    // End of variables declaration//GEN-END:variables
}
