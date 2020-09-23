/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kitatms;

import java.awt.event.ActionEvent;

/**
 *
 * @author User
 */
public class SignUp_Login extends javax.swing.JFrame {
    
    static DBConnection con;
    
    public SignUp_Login(DBConnection con){
        this.con = con;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp_Login().setVisible(true);
            }
        });
        
    }

    /** Creates new form Login_Form */
    private SignUp_Login() {
        initComponents();
        jTextField1.setEditable(false);
        jTextField3.setEditable(false);
        jTextField4.setEditable(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        accountpasswordPasswordField = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        traineeSignupButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        trainerSignupButton = new javax.swing.JButton();
        usernameTextField = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setForeground(new java.awt.Color(51, 51, 51));
        jTextField1.setText("Fill in your username and password :");
        jTextField1.setBorder(null);
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 61, 230, 20));

        accountpasswordPasswordField.setBackground(new java.awt.Color(255, 255, 255));
        accountpasswordPasswordField.setForeground(new java.awt.Color(102, 102, 102));
        accountpasswordPasswordField.setText("Password");
        accountpasswordPasswordField.setBorder(null);
        jPanel3.add(accountpasswordPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 200, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, -1));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 200, -1));

        traineeSignupButton.setText("Sign up as Trainee");
        traineeSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traineeSignupButtonActionPerformed(evt);
            }
        });
        jPanel3.add(traineeSignupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 200, -1));

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel3.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 200, -1));

        trainerSignupButton.setText("Sign up as Trainer");
        trainerSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerSignupButtonActionPerformed(evt);
            }
        });
        jPanel3.add(trainerSignupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 200, -1));

        usernameTextField.setForeground(new java.awt.Color(102, 102, 102));
        usernameTextField.setText("Username");
        usernameTextField.setBorder(null);
        jPanel3.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 200, 31));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(51, 51, 51));
        jTextField3.setText("Please login :");
        jTextField3.setBorder(null);
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 160, 20));

        jTextField4.setForeground(new java.awt.Color(51, 51, 51));
        jTextField4.setText("You have successfully created a trainer/trainee account ! ");
        jTextField4.setBorder(null);
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 31));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setText("KITA logo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonActionPerformed

    private void trainerSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerSignupButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trainerSignupButtonActionPerformed

    private void traineeSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traineeSignupButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_traineeSignupButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField accountpasswordPasswordField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton traineeSignupButton;
    private javax.swing.JButton trainerSignupButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

}