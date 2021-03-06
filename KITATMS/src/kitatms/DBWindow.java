/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

/**
 *
 * @author adiza
 */
public class DBWindow extends javax.swing.JFrame {
    

    static DBConnection con;
    /**
     * Creates new form DBWindow
     * @param con
     */
    public DBWindow(DBConnection con) {
        this.con = con;
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DBWindow().setVisible(true);
            }
        });
    }
    
    public DBWindow() {
        initComponents();
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVisible(false);
        clearDBButton.setVisible(false);
        clearDBButton.setEnabled(false);
        insertDataButton.setVisible(false);
        insertDataButton.setEnabled(false);
        continueButton.setVisible(false);
        continueButton.setEnabled(false);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outerPanel = new javax.swing.JPanel();
        borderPanel = new javax.swing.JPanel();
        contentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        passwordSubmitButton = new javax.swing.JButton();
        messageLabel = new javax.swing.JLabel();
        clearDBButton = new javax.swing.JButton();
        insertDataButton = new javax.swing.JButton();
        continueButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MySQL Setup Window");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setResizable(false);

        outerPanel.setBackground(new java.awt.Color(0, 204, 204));

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Enter the root account password to your MySQL local instance server");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jPasswordField1.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setForeground(new java.awt.Color(0, 0, 0));

        passwordSubmitButton.setBackground(new java.awt.Color(204, 255, 255));
        passwordSubmitButton.setForeground(new java.awt.Color(0, 0, 0));
        passwordSubmitButton.setText("Submit");
        passwordSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordSubmitButtonActionPerformed(evt);
            }
        });

        messageLabel.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(255, 51, 51));
        messageLabel.setText("INCORRECT PASSWORD");
        messageLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        messageLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        messageLabel.setName(""); // NOI18N

        clearDBButton.setBackground(new java.awt.Color(204, 255, 255));
        clearDBButton.setForeground(new java.awt.Color(0, 0, 0));
        clearDBButton.setText("Clear Database");
        clearDBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDBButtonActionPerformed(evt);
            }
        });

        insertDataButton.setBackground(new java.awt.Color(204, 255, 255));
        insertDataButton.setForeground(new java.awt.Color(0, 0, 0));
        insertDataButton.setText("Insert Testing Data");
        insertDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertDataButtonActionPerformed(evt);
            }
        });

        continueButton.setBackground(new java.awt.Color(204, 255, 255));
        continueButton.setForeground(new java.awt.Color(0, 0, 0));
        continueButton.setText("Continue to KITATMS");
        continueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(passwordSubmitButton)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(clearDBButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(insertDataButton)
                .addGap(18, 18, 18)
                .addComponent(continueButton)
                .addGap(26, 26, 26))
            .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(112, 112, 112)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordSubmitButton))
                .addGap(18, 18, 18)
                .addComponent(messageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearDBButton)
                    .addComponent(insertDataButton)
                    .addComponent(continueButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout borderPanelLayout = new javax.swing.GroupLayout(borderPanel);
        borderPanel.setLayout(borderPanelLayout);
        borderPanelLayout.setHorizontalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        borderPanelLayout.setVerticalGroup(
            borderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(borderPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout outerPanelLayout = new javax.swing.GroupLayout(outerPanel);
        outerPanel.setLayout(outerPanelLayout);
        outerPanelLayout.setHorizontalGroup(
            outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outerPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(borderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        outerPanelLayout.setVerticalGroup(
            outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outerPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(borderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordSubmitButtonActionPerformed
        messageLabel.setVisible(true);
        messageLabel.setText(" ");
        
        String password = String.valueOf(jPasswordField1.getPassword());
        //password = zamPASSWORD;
        jPasswordField1.setText("");
        System.out.printf("Password entered: %s.\n",password);
        con.setPassword(password);
        System.out.println("New password set.");
        messageLabel.setText("Validating password ...");
        if(!con.isConnectedMySQL()){
            System.out.println("Not connected.");
            messageLabel.setForeground(Color.RED);
            messageLabel.setText("INCORRECT PASSWORD");
        }
        else{
            System.out.println("Connected.");
            messageLabel.setForeground(Color.GREEN);
            messageLabel.setText("Database successfully connected.");
            if(!con.isConnectedDB()){
                try {
                    messageLabel.setText("Program database not found. Establishing program database...");
                    con.setupDB();
                } catch (SQLException ex) {
                    Logger.getLogger(DBWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            jPasswordField1.setEnabled(false);
            jPasswordField1.setVisible(false);
            passwordSubmitButton.setVisible(false);
            passwordSubmitButton.setEnabled(false);
            clearDBButton.setVisible(true);
            clearDBButton.setEnabled(true);
            insertDataButton.setVisible(true);
            insertDataButton.setEnabled(true);
            continueButton.setVisible(true);
            continueButton.setEnabled(true);
            messageLabel.setText("Program database created and successfully connected.");
        }
        
    }//GEN-LAST:event_passwordSubmitButtonActionPerformed

    private void clearDBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDBButtonActionPerformed
        con.clearData();
        messageLabel.setText("Program database successfully cleared.");
        clearDBButton.setVisible(false);
        clearDBButton.setEnabled(false);
        insertDataButton.setVisible(false);
        insertDataButton.setEnabled(false);
        continueButton.setVisible(false);
        continueButton.setEnabled(false);
        passwordSubmitButton.setVisible(true);
        passwordSubmitButton.setEnabled(true);
        jPasswordField1.setEnabled(true);
        jPasswordField1.setVisible(true);
    }//GEN-LAST:event_clearDBButtonActionPerformed

    private void insertDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertDataButtonActionPerformed
        if(con.dataFileExists()){
            try {
                con.insertDummyData();
                messageLabel.setText("Dummy data successfully inserted into database.");
            } catch (FileNotFoundException ex) {
                System.out.println("Data insertion unsuccessful");
                messageLabel.setText("Dummy data insertion failed.");
            }
        }
        else{
            messageLabel.setText("Dummy data not found in device.");
        }
        
        insertDataButton.setVisible(false);
        insertDataButton.setEnabled(false);
    }//GEN-LAST:event_insertDataButtonActionPerformed

    private void continueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueButtonActionPerformed
        dispose();
        new SignUp_LoginWindow(con);
    }//GEN-LAST:event_continueButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borderPanel;
    private javax.swing.JButton clearDBButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton continueButton;
    private javax.swing.JButton insertDataButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JPanel outerPanel;
    private javax.swing.JButton passwordSubmitButton;
    // End of variables declaration//GEN-END:variables
}
