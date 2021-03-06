/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kitatms;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SignUp_LoginWindow extends javax.swing.JFrame {
    
    static DBConnection con;
    
    public SignUp_LoginWindow(DBConnection con){
        this.con = con;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp_LoginWindow().setVisible(true);
            }
        });
        
    }

    /** Creates new form Login_Form */
    private SignUp_LoginWindow() {
        initComponents();
        //jTextField1.setEditable(false);
        //jTextField3.setEditable(false);
        //jTextField4.setEditable(false);S
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
        accountpasswordPasswordField = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        traineeSignupButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        trainerSignupButton = new javax.swing.JButton();
        usernameTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

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

        accountpasswordPasswordField.setForeground(new java.awt.Color(102, 102, 102));
        accountpasswordPasswordField.setToolTipText("");
        accountpasswordPasswordField.setBorder(null);
        accountpasswordPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountpasswordPasswordFieldActionPerformed(evt);
            }
        });
        jPanel3.add(accountpasswordPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 200, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 190, -1));

        traineeSignupButton.setBackground(new java.awt.Color(204, 204, 204));
        traineeSignupButton.setText("Sign up as Trainee");
        traineeSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traineeSignupButtonActionPerformed(evt);
            }
        });
        jPanel3.add(traineeSignupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 200, -1));

        loginButton.setBackground(new java.awt.Color(204, 204, 204));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        jPanel3.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 200, -1));

        trainerSignupButton.setBackground(new java.awt.Color(204, 204, 204));
        trainerSignupButton.setText("Sign up as Trainer");
        trainerSignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerSignupButtonActionPerformed(evt);
            }
        });
        jPanel3.add(trainerSignupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, -1));

        usernameTextField.setForeground(new java.awt.Color(102, 102, 102));
        usernameTextField.setBorder(null);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        jPanel3.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 200, 31));

        jLabel2.setText("Fill in your username and password ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 230, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 190, -1));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jLabel1.setText("username:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, 20));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 13)); // NOI18N
        jLabel5.setText("password:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 20));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setPreferredSize(new java.awt.Dimension(318, 263));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jLabel4.setText("TRAINING MANAGEMENT SYSTEM");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 100)); // NOI18N
        jLabel3.setText("KITA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
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
        String username = usernameTextField.getText();
        String password = String.valueOf(accountpasswordPasswordField.getPassword());
        boolean flag = false;
        String accType = "";
        Account acc = new Account();
        ArrayList<String> usernameList = new ArrayList<String>();
        ArrayList<String> passwordList = new ArrayList<String>();
        ArrayList<String> accTypeList = new ArrayList<String>();
        
        if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
			jLabel2.setText("Please fill in username and password");
	}
        else{
            try{
            usernameList = con.retrieve("SELECT * FROM kitatms.account;","accountID");
            passwordList = con.retrieve("SELECT * FROM kitatms.account;","accountPassword");
            accTypeList = con.retrieve("SELECT * FROM kitatms.account;","accountType");
            } catch (SQLException ex) {
                        //Logger.getLogger(SignUp_LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            for(int i = 0; i < usernameList.size(); i++) {   
                //System.out.print(houseAddress.get(i));
                if(usernameList.get(i).equals(username) && passwordList.get(i).equals(password)){
                    flag = true;
                    accType = accTypeList.get(i);
                    acc = new Account(usernameList.get(i), passwordList.get(i), accTypeList.get(i));
                    
                }
            }  
            if(flag==true){
                if(accType.equals("1")){
                    System.out.println(acc.username);
                    dispose();
                    new TrainerHomeWindow(con,acc);
                }
                if(accType.equals("2")){
                    dispose();
                    TraineeHomeWindow twh = new TraineeHomeWindow(con,acc);
                    //twh.setWelcome();
                    //twh.setAccount(acc);
                }
            }
            else{
                jLabel2.setText("Wrong username or password");
            }
        }
        
        
        
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void trainerSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainerSignupButtonActionPerformed
        // TODO add your handling code here:
        String username = usernameTextField.getText();
        String password = String.valueOf(accountpasswordPasswordField.getPassword());
        boolean flag = false;
        String message = "";
        if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
                        message = "Please fill in username and password";
			jLabel2.setText(message);
		}
        else if(username.length()!=10){
            message = "username length must be 10";
            jLabel2.setText(message);
        }
	else{  
            try {
                    //con.update("INSERT INTO kitatms.account (accountID,accountType,accountPassword) VALUES ('real',1,'messi');");
                    flag = con.update("INSERT INTO kitatms.account (accountID,accountType,accountPassword) VALUES ('"+username+"',1,'"+password+"');");
                
                
                } catch (SQLException ex) {
                    //Logger.getLogger(SignUp_LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
	    		    if(flag==true){
                                message = "You are now registered as a trainer!";
	    		    	jLabel2.setText(message);
                                String query = "insert into trainer values('"+username+"');";
                                try {
                                    con.update(query);
                                } catch (SQLException ex) {
                                    Logger.getLogger(SignUp_LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                                }
			    }
			    else{
                                message = "Username is taken";
			    	jLabel2.setText(message);
			    }
        }
    }//GEN-LAST:event_trainerSignupButtonActionPerformed

    private void traineeSignupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traineeSignupButtonActionPerformed
        // TODO add your handling code here:
        String username = usernameTextField.getText();
        String password = String.valueOf(accountpasswordPasswordField.getPassword());
        boolean flag = false;
        SignUp sign = new SignUp(con);
        String message = "";
        
        if(username.equals("")|| username.equals(null) || password.equals("")|| password.equals(null)){
			message = "Please fill in username and password";
			jLabel2.setText(message);
	}
        else if(username.length()!=10){
            message = "username length must be 10";
            jLabel2.setText(message);
        }
        else{
            try {
                flag = con.update("INSERT INTO kitatms.account (accountID,accountType,accountPassword) VALUES ('"+username+"',2,'"+password+"');");
            } catch (SQLException ex) {
                //Logger.getLogger(SignUp_LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(flag==true){
                message = "You are now registered as a trainee!";
	    		    	jLabel2.setText(message);
                String query = "insert into trainee values('"+username+"');";
                try {
                    con.update(query);
                } catch (SQLException ex) {
                    Logger.getLogger(SignUp_LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                 message = "Username is taken";
		jLabel2.setText(message);
            }
        }
        
        
    }//GEN-LAST:event_traineeSignupButtonActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void accountpasswordPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountpasswordPasswordFieldActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_accountpasswordPasswordFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField accountpasswordPasswordField;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton loginButton;
    private javax.swing.JButton traineeSignupButton;
    private javax.swing.JButton trainerSignupButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

}
