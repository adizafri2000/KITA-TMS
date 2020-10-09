package kitatms;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class CourseReportWindow extends javax.swing.JFrame {
    
    static DBConnection con;
    private Account acc;
    private ArrayList<String> courseIDList;
    
    public CourseReportWindow(DBConnection con,Account acc){
        this.con = con;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseReportWindow(acc).setVisible(true);
            }
        });
    }
        

    /**
     * Creates new form CourseReport
     */
    private CourseReportWindow(Account acc) {
        this.acc = acc;
        courseIDList = loadCourses();
        
        String[] data = new String[courseIDList.size()];
        
        for(int i=0;i<courseIDList.size();i++){
            data[i] = courseIDList.get(i);
            System.out.println(data[i]);
        }
        
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel(data);
        
        initComponents();
        noCourseLabel.setVisible(false);
        successLabel.setVisible(false);
        failedLabel.setVisible(false);
        
        jComboBox1.setModel(dcbm);
        
        if(courseIDList.size()==0){
            noCourseLabel.setVisible(true);    
            jComboBox1.setEnabled(false);
            jComboBox1.setVisible(false);
            generateReportButton.setEnabled(false);
            generateReportButton.setVisible(false);
            noCourseLabel.setVisible(false);
        }
        
    }
    
    /**
     * Retrieves all the courses created by this trainer.
     * @return 
     */
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
    
    /**
     * The actual method that generates a course report with a given course ID
     * @param courseID 
     */
    private void createReport(String courseID){
        Report report = new Report(); //Logger.getLogger(CourseReportWindow.class.getName()).log(Level.SEVERE, null, ex);
        report.setConnection(con);
        report.setTrainer(acc);
        Course course = new Course();
        course.setCourseID(courseID);
        report.setCourse(course);
        report.setTraineeID(course);
        report.setFileName();
        report.generateReport();
        
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
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        homeButton = new javax.swing.JButton();
        generateReportButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        noCourseLabel = new javax.swing.JLabel();
        successLabel = new javax.swing.JLabel();
        failedLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(529, 42));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        jLabel1.setText("Course report");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
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

        jLabel2.setText("Click generate report to get course report : ");

        jLabel6.setText("[]");

        homeButton.setBackground(new java.awt.Color(204, 204, 204));
        homeButton.setText("Back to home");
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        generateReportButton.setText("Generate Report");
        generateReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateReportButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(jComboBox1.getModel());

        noCourseLabel.setForeground(new java.awt.Color(0, 0, 0));
        noCourseLabel.setText("You have not created any courses");

        successLabel.setForeground(new java.awt.Color(51, 255, 51));
        successLabel.setText("Report file saved successfully");

        failedLabel.setForeground(new java.awt.Color(255, 51, 51));
        failedLabel.setText("Failed to save report file");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateReportButton)
                .addGap(186, 186, 186))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 624, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(505, 505, 505)
                        .addComponent(homeButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noCourseLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(failedLabel)
                                .addComponent(successLabel)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateReportButton)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(noCourseLabel)
                .addGap(2, 2, 2)
                .addComponent(failedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(successLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(homeButton))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 654, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new TrainerHomeWindow(con,acc);
    }//GEN-LAST:event_homeButtonActionPerformed

    private void generateReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateReportButtonActionPerformed
        String courseID = (String)jComboBox1.getSelectedItem();
        createReport(courseID);
        String fileName = courseID+"Report.pdf";
        File file = new File(fileName);
        Path source = Paths.get(file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = chooser.showOpenDialog(this);
        Path target;
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                target = Paths.get(chooser.getSelectedFile().getAbsolutePath());
                String newPath = target.toString()+"\\"+fileName;
                target = Paths.get(newPath);
                
                System.out.println("You chose to open this directory: " +
                        target);
                
                Path temp = Files.move(source,target);
                if(temp != null)
                {
                    System.out.println("File renamed and moved successfully");
                    successLabel.setVisible(true);
                    failedLabel.setVisible(false);
                }
                else
                {
                    System.out.println("Failed to move the file"); 
                    failedLabel.setVisible(true);
                    successLabel.setVisible(false);
                }
            } catch (IOException ex) {
                Logger.getLogger(CourseReportWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("Failed to move the file"); 
                    failedLabel.setVisible(true);
                    successLabel.setVisible(false);
        }
    }//GEN-LAST:event_generateReportButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel failedLabel;
    private javax.swing.JButton generateReportButton;
    private javax.swing.JButton homeButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel noCourseLabel;
    private javax.swing.JLabel successLabel;
    // End of variables declaration//GEN-END:variables
}
