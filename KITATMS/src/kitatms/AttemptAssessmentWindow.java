package kitatms;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class AttemptAssessmentWindow extends javax.swing.JFrame {
    
    static DBConnection con;
    private Course course;
    private ButtonGroup[] answerChoice;
    private String[] correctAnswers;
    private Trainee trainee;
    
    public AttemptAssessmentWindow(DBConnection con){
        this.con = con;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttemptAssessmentWindow().setVisible(true);
            }
        });
    }

    /**
     * Creates new form AttemptAssessment
     */
    private AttemptAssessmentWindow() {
        initComponents();
        setRadioButtonActionCommand();
        unfinishedWarningLabel.setVisible(false);
        answerChoice = new ButtonGroup[5];
        answerChoice[0].add(q1True);
        answerChoice[0].add(q1False);
        answerChoice[1].add(q2True);
        answerChoice[1].add(q2False);
        answerChoice[2].add(q3True);
        answerChoice[2].add(q3False);
        answerChoice[3].add(q4True);
        answerChoice[3].add(q4False);
        answerChoice[4].add(q5True);
        answerChoice[4].add(q5False);
    }
    
    private void setRadioButtonActionCommand(){
        q1True.setActionCommand("T");
        q1False.setActionCommand("F");
        q2True.setActionCommand("T");
        q2False.setActionCommand("F");
        q3True.setActionCommand("T");
        q3False.setActionCommand("F");
        q4True.setActionCommand("T");
        q4False.setActionCommand("F");
        q5True.setActionCommand("T");
        q5False.setActionCommand("F");
    }
    
    public void setCourse(Course c){
        course = c;
        try {
            setupQuestions();
        } catch (SQLException ex) {
            //Logger.getLogger(AttemptAssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setTrainee(Trainee t){
        trainee = t;
    }
    
    /**
     * Retreives the course's coressponding assessment questions and answers.
     * Questions are then displayed in the window.
     * @throws SQLException 
     */
    private void setupQuestions() throws SQLException{
        //question retrieval
        //format: select * from assessment where courseID='courseID';
        String courseID = course.getCourseID();
        
        String questionQuery = "select * from assessment where courseID='"+courseID+"';";
        String packedQuestions = con.retrieve(questionQuery, "assessmentQuestions").get(0);
        
        String[] questions = packedQuestions.split("$");
        question1Text.setText(questions[0]);
        question2Text.setText(questions[1]);
        question3Text.setText(questions[2]);
        question4Text.setText(questions[3]);
        question5Text.setText(questions[4]);
        
        String answerQuery = "select * from assessment where courseID='"+courseID+"';";
        String retrievedAnswers = con.retrieve(answerQuery, "assessmentAnswers").get(0);
        
        correctAnswers[0] = Character.toString(retrievedAnswers.charAt(0));
        correctAnswers[1] = Character.toString(retrievedAnswers.charAt(1));
        correctAnswers[2] = Character.toString(retrievedAnswers.charAt(2));
        correctAnswers[3] = Character.toString(retrievedAnswers.charAt(3));
        correctAnswers[4] = Character.toString(retrievedAnswers.charAt(4));
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
        submitButton = new javax.swing.JToggleButton();
        q1True = new javax.swing.JRadioButton();
        q1False = new javax.swing.JRadioButton();
        question1Text = new javax.swing.JTextField();
        question2Text = new javax.swing.JTextField();
        q2True = new javax.swing.JRadioButton();
        q2False = new javax.swing.JRadioButton();
        question3Text = new javax.swing.JTextField();
        q3True = new javax.swing.JRadioButton();
        q3False = new javax.swing.JRadioButton();
        question4Text = new javax.swing.JTextField();
        q4True = new javax.swing.JRadioButton();
        q4False = new javax.swing.JRadioButton();
        question5Text = new javax.swing.JTextField();
        q5True = new javax.swing.JRadioButton();
        q5False = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unfinishedWarningLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 15)); // NOI18N
        jLabel1.setText("  TSE2101 WORK ETHICS : Attempt course assessment");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(29, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Please answer the following questions: ");

        submitButton.setBackground(new java.awt.Color(204, 204, 204));
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        q1True.setBackground(new java.awt.Color(255, 255, 255));
        q1True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q1True.setText("True");
        q1True.setName("T"); // NOI18N

        q1False.setBackground(new java.awt.Color(255, 255, 255));
        q1False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q1False.setText("False");
        q1False.setName("F"); // NOI18N

        question1Text.setEditable(false);
        question1Text.setText("Work is tiring ");
        question1Text.setBorder(null);

        question2Text.setEditable(false);
        question2Text.setText("Work ethics is important");
        question2Text.setBorder(null);

        q2True.setBackground(new java.awt.Color(255, 255, 255));
        q2True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q2True.setText("True");
        q2True.setName("T"); // NOI18N

        q2False.setBackground(new java.awt.Color(255, 255, 255));
        q2False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q2False.setText("False");
        q2False.setName("F"); // NOI18N

        question3Text.setEditable(false);
        question3Text.setText("Respect each other is a good ethic");
        question3Text.setBorder(null);

        q3True.setBackground(new java.awt.Color(255, 255, 255));
        q3True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q3True.setText("True");
        q3True.setName("T"); // NOI18N

        q3False.setBackground(new java.awt.Color(255, 255, 255));
        q3False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q3False.setText("False");
        q3False.setName("F"); // NOI18N

        question4Text.setEditable(false);
        question4Text.setText("Work ethic varies by companies");
        question4Text.setBorder(null);

        q4True.setBackground(new java.awt.Color(255, 255, 255));
        q4True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q4True.setText("True");
        q4True.setName("T"); // NOI18N

        q4False.setBackground(new java.awt.Color(255, 255, 255));
        q4False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q4False.setText("False");
        q4False.setName("F"); // NOI18N

        question5Text.setEditable(false);
        question5Text.setText("Ethic come first");
        question5Text.setBorder(null);

        q5True.setBackground(new java.awt.Color(255, 255, 255));
        q5True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q5True.setText("True");
        q5True.setName("T"); // NOI18N

        q5False.setBackground(new java.awt.Color(255, 255, 255));
        q5False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q5False.setText("False");
        q5False.setName("F"); // NOI18N

        jLabel3.setText("1.");

        jLabel4.setText("2.");

        jLabel5.setText("3.");

        jLabel6.setText("4.");

        jLabel8.setText("5.");

        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("*please answer all questions");

        unfinishedWarningLabel.setForeground(new java.awt.Color(204, 0, 0));
        unfinishedWarningLabel.setText("You have not finished answering all questions");
        unfinishedWarningLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(29, 29, 29)
                        .addComponent(submitButton)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(question2Text, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(question1Text, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(question3Text, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(q3True)
                                        .addGap(18, 18, 18)
                                        .addComponent(q3False))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(q2True)
                                        .addGap(18, 18, 18)
                                        .addComponent(q2False))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(q1True)
                                        .addGap(18, 18, 18)
                                        .addComponent(q1False)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(question5Text, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(q5True)
                                .addGap(18, 18, 18)
                                .addComponent(q5False))
                            .addComponent(question4Text, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(q4True)
                                .addGap(18, 18, 18)
                                .addComponent(q4False)))
                        .addGap(50, 50, 50))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(unfinishedWarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(submitButton)
                        .addComponent(jLabel9))
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q1True)
                            .addComponent(q1False))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q2True)
                            .addComponent(q2False))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question3Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q3True)
                            .addComponent(q3False)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question4Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q4True)
                            .addComponent(q4False))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(question5Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q5True)
                            .addComponent(q5False))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(unfinishedWarningLabel)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        boolean completed = false;
        String[] submittedAnswers = new String[5];
        for(int i=0;i<5;i++){
            if (answerChoice[i].getSelection()==null){
                completed = false;
                break;
            }
            else{
                submittedAnswers[i] = answerChoice[i].getSelection().getActionCommand();
            }
        }
<<<<<<< Updated upstream
        //String assessmentID = 
        String query = "select * from assessment where courseID='"+course.getCourseID()+"';";
        ArrayList<String> correctAnswers = new ArrayList<>();
        ArrayList<String> questions = new ArrayList<>();
        try {
            questions = con.retrieve(query,"assessmentQuestions");
            correctAnswers = con.retrieve(query,"assessmentAnswers");
        } catch (SQLException ex) {
            Logger.getLogger(AttemptAssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
=======
>>>>>>> Stashed changes
        
        if (completed){
            Assessment assessment = new Assessment();
            assessment.setAnswers(correctAnswers);
            int marks = assessment.calculateMarks(submittedAnswers);
            
            String traineeID = trainee.accountID;
            assessment.generateAssessmentID(course);
            String assessmentID = assessment.getAssessmentID();
            
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
            LocalDateTime now = LocalDateTime.now();  
            String dateNow = dtf.format(now);

            //query format: insert into attempt values(accountID,assessmentID,marks,attempt date);
            String updateAttemptQuery = "insert into attempt values('"+traineeID+"','"+assessmentID+"',"+marks+",'"+dateNow+"');";
            try {
                System.out.println("Attempt update status: "+con.update(updateAttemptQuery));
            } catch (SQLException ex) {
                //Logger.getLogger(AttemptAssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            dispose();
            new AssessmentWindow(con);
        }
        else{
            unfinishedWarningLabel.setVisible(true);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            //java.util.logging.Logger.getLogger(AttemptAssessment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            //java.util.logging.Logger.getLogger(AttemptAssessment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            //java.util.logging.Logger.getLogger(AttemptAssessment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            //java.util.logging.Logger.getLogger(AttemptAssessment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AttemptAssessmentWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton q1False;
    private javax.swing.JRadioButton q1True;
    private javax.swing.JRadioButton q2False;
    private javax.swing.JRadioButton q2True;
    private javax.swing.JRadioButton q3False;
    private javax.swing.JRadioButton q3True;
    private javax.swing.JRadioButton q4False;
    private javax.swing.JRadioButton q4True;
    private javax.swing.JRadioButton q5False;
    private javax.swing.JRadioButton q5True;
    private javax.swing.JTextField question1Text;
    private javax.swing.JTextField question2Text;
    private javax.swing.JTextField question3Text;
    private javax.swing.JTextField question4Text;
    private javax.swing.JTextField question5Text;
    private javax.swing.JToggleButton submitButton;
    private javax.swing.JLabel unfinishedWarningLabel;
    // End of variables declaration//GEN-END:variables
}
