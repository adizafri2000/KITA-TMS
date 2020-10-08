package kitatms;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

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
    private Account trainee;
    private boolean canAttempt,passed;
    
    public AttemptAssessmentWindow(DBConnection con,Account trainee,Course course,boolean canAttempt,boolean passed){
        this.con = con;
        this.trainee = trainee;
        this.course = course;
        this.canAttempt = canAttempt;
        this.passed = passed;
        
        if(passed){
            System.out.printf("%s has passed %s course and cannot attempt its assessment.\n",trainee.username,course.getCourseID());
        }
        else{
            if(canAttempt){
                System.out.printf("%s has not passed %s course and can attempt its assessment.\n",trainee.username,course.getCourseID());    
            }
            else{
                System.out.printf("%s has not passed %s course and cannot attempt its assessment.\n",trainee.username,course.getCourseID());
            }
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                if(passed){
                    JOptionPane.showMessageDialog(null,"You have already passed this course.");
                    dispose();
                }
                else{
                    if(!canAttempt){
                        JOptionPane.showMessageDialog(null,"You have not finished studying this course's materials yet.");
                        dispose();
                    }
                    else{
                        new AttemptAssessmentWindow(trainee,course,canAttempt,passed).setVisible(true);
                    }
                }
                
            }
        });
    }

    /**
     * Creates new form AttemptAssessment
     */
    private AttemptAssessmentWindow(Account trainee,Course course,boolean canAttempt,boolean passed) {
        this.trainee = trainee;
        this.course = course;
        this.canAttempt = canAttempt;
        this.passed = passed;
        initComponents();
        setRadioButtonActionCommand();
        unfinishedWarningLabel.setVisible(false);
        answerChoice = new ButtonGroup[5];

        for(int i=0;i<5;i++){
            answerChoice[i] = new ButtonGroup();
        }

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


        setupQuestions();
            
        
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
    }
    
    public void setTrainee(Account t){
        trainee = t;
    }
    
    /**
     * Retrieves the course's corresponding assessment questions and answers.
     * Questions are then displayed in the window.
     * @throws SQLException 
     */
    private void setupQuestions(){
        try {
            //question retrieval
            //format: select * from assessment where courseID='courseID';
            String courseID = course.getCourseID();
            System.out.println(courseID);
            
            String questionQuery = "select * from assessment where courseID='"+courseID+"';";
            String packedQuestions = con.retrieve(questionQuery, "assessmentQuestions").get(0);
            System.out.println(packedQuestions);
            
            String[] questions = new String[5];
            questions = packedQuestions.split("\\$");
            for(String s:questions){
                System.out.println(s);
            }
            
            question1.setText(questions[0]);
            question2.setText(questions[1]);
            question3.setText(questions[2]);
            question4.setText(questions[3]);
            question5.setText(questions[4]);
            
            String answerQuery = "select * from assessment where courseID='"+courseID+"';";
            String retrievedAnswers = con.retrieve(answerQuery, "assessmentAnswers").get(0);
            System.out.println(retrievedAnswers);
            
            correctAnswers = new String[5];
            correctAnswers[0] = Character.toString(retrievedAnswers.charAt(0));
            correctAnswers[1] = Character.toString(retrievedAnswers.charAt(1));
            correctAnswers[2] = Character.toString(retrievedAnswers.charAt(2));
            correctAnswers[3] = Character.toString(retrievedAnswers.charAt(3));
            correctAnswers[4] = Character.toString(retrievedAnswers.charAt(4));
        } catch (SQLException ex) {
            //Logger.getLogger(AttemptAssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        submitButton = new javax.swing.JToggleButton();
        q1True = new javax.swing.JRadioButton();
        q1False = new javax.swing.JRadioButton();
        q2True = new javax.swing.JRadioButton();
        q2False = new javax.swing.JRadioButton();
        q3True = new javax.swing.JRadioButton();
        q3False = new javax.swing.JRadioButton();
        q4True = new javax.swing.JRadioButton();
        q4False = new javax.swing.JRadioButton();
        q5True = new javax.swing.JRadioButton();
        q5False = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unfinishedWarningLabel = new javax.swing.JLabel();
        question1 = new javax.swing.JLabel();
        question2 = new javax.swing.JLabel();
        question3 = new javax.swing.JLabel();
        question4 = new javax.swing.JLabel();
        question5 = new javax.swing.JLabel();

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

        q2True.setBackground(new java.awt.Color(255, 255, 255));
        q2True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q2True.setText("True");
        q2True.setName("T"); // NOI18N

        q2False.setBackground(new java.awt.Color(255, 255, 255));
        q2False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q2False.setText("False");
        q2False.setName("F"); // NOI18N

        q3True.setBackground(new java.awt.Color(255, 255, 255));
        q3True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q3True.setText("True");
        q3True.setName("T"); // NOI18N

        q3False.setBackground(new java.awt.Color(255, 255, 255));
        q3False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q3False.setText("False");
        q3False.setName("F"); // NOI18N

        q4True.setBackground(new java.awt.Color(255, 255, 255));
        q4True.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q4True.setText("True");
        q4True.setName("T"); // NOI18N

        q4False.setBackground(new java.awt.Color(255, 255, 255));
        q4False.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        q4False.setText("False");
        q4False.setName("F"); // NOI18N

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

        question1.setText("Question 1");

        question2.setText("Question 2");

        question3.setText("Question 3");

        question4.setText("Question 4");

        question5.setText("Question 5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(unfinishedWarningLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(submitButton)
                .addGap(58, 58, 58))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(0, 484, Short.MAX_VALUE))
                            .addComponent(question3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(question2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(question1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(question4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(q4True)
                                        .addGap(18, 18, 18)
                                        .addComponent(q4False))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(q5True)
                                        .addGap(18, 18, 18)
                                        .addComponent(q5False)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(question5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(question1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q1True)
                    .addComponent(q1False))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(question2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q2True)
                    .addComponent(q2False))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(question3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q3True)
                    .addComponent(q3False))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(question4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q4True)
                    .addComponent(q4False))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(question5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q5True)
                    .addComponent(q5False))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unfinishedWarningLabel)
                    .addComponent(submitButton))
                .addGap(6, 6, 6))
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
        System.out.println("Submit button clicked!");
        boolean completed = true;
        String[] submittedAnswers = new String[5];
        for(int i=0;i<5;i++){
            if (answerChoice[i].getSelection()==null){
                completed = false;
                System.out.println("Trainee failed to answer all questions.");
                break;
            }
            else{
                submittedAnswers[i] = answerChoice[i].getSelection().getActionCommand();
                System.out.printf("%d. %s\n",i+1,submittedAnswers[i]);
            }
        }
        System.out.println("Submitted answers calculated");
        
        if (completed){
            try {
                unfinishedWarningLabel.setVisible(false);
                for(String s:submittedAnswers){
                    System.out.println(s);
                }
                
                Assessment assessment = new Assessment();
                assessment.setAnswers(correctAnswers);
                int marks = assessment.calculateMarks(submittedAnswers);
                
                String traineeID = trainee.username;
                assessment.generateAssessmentID(course);
                String assessmentID = assessment.getAssessmentID();
                
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDateTime now = LocalDateTime.now();
                String dateNow = dtf.format(now);
                System.out.printf("%s attempted %s on %s, Marks = %d/5\n",trainee.username,assessmentID,dateNow,marks);
                
                String query = "select * from attempt where assessmentID='"+assessmentID+"' and accountID='"+trainee.username+"';";
                
                if(con.retrieve(query,"accountID").isEmpty()){
                    System.out.println("Record does not exist, inserting new record.");
                    query = "insert into attempt values('"+traineeID+"','"+assessmentID+"',"+marks+",'"+dateNow+"');";
                    con.update(query);
                }
                else{
                    System.out.println("Record exists, updating record.");
                    query = "update kitatms.attempt set attemptMarks="+marks+",attemptDate='"+dateNow+"' where accountID='"+trainee.username+"' and assessmentID='"+assessmentID+"';";
                    con.update(query);
                }
                dispose();
            } catch (SQLException ex) {
                //Logger.getLogger(AttemptAssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
                //Logger.getLogger(AttemptAssessmentWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            unfinishedWarningLabel.setVisible(true);
        }
    }//GEN-LAST:event_submitButtonActionPerformed


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
    private javax.swing.JLabel question1;
    private javax.swing.JLabel question2;
    private javax.swing.JLabel question3;
    private javax.swing.JLabel question4;
    private javax.swing.JLabel question5;
    private javax.swing.JToggleButton submitButton;
    private javax.swing.JLabel unfinishedWarningLabel;
    // End of variables declaration//GEN-END:variables
}
