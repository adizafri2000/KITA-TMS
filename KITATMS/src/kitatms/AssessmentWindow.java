/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author adiza
 */
public class AssessmentWindow extends javax.swing.JFrame {

    /**
     * Creates new form AssessmentWindow
     */
    public AssessmentWindow() {
        //JTableHeader header = assessmentListTable.getTableHeader();
        //header.setBackground(Color.WHITE);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        windowTitleLabel = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        homeButton = new javax.swing.JButton();
        instruction1Label = new javax.swing.JLabel();
        instruction2Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        assessmentListTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topPanel.setBackground(new java.awt.Color(0, 204, 204));

        windowTitleLabel.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        windowTitleLabel.setForeground(new java.awt.Color(0, 0, 0));
        windowTitleLabel.setText("ASSESSMENT");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(windowTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addGap(462, 462, 462))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(windowTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        homeButton.setBackground(new java.awt.Color(255, 255, 255));
        homeButton.setForeground(new java.awt.Color(5, 55, 255));
        homeButton.setText("Back to home");
        homeButton.setBorder(null);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        instruction1Label.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        instruction1Label.setForeground(new java.awt.Color(0, 0, 0));
        instruction1Label.setText("Please complete the course assessment:");

        instruction2Label.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        instruction2Label.setForeground(new java.awt.Color(178, 178, 178));
        instruction2Label.setText("*Click [Start] to attempt assessment");

        assessmentListTable.setBackground(new java.awt.Color(255, 255, 255));
        assessmentListTable.setForeground(new java.awt.Color(0, 0, 0));
        assessmentListTable.setToolTipText("");
        assessmentListTable.setFocusable(false);
        assessmentListTable.setGridColor(new java.awt.Color(255, 255, 255));
        assessmentListTable.setRowMargin(3);
        assessmentListTable.setRowSelectionAllowed(false);
        assessmentListTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        assessmentListTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(assessmentListTable);
        assessmentListTable.getAccessibleContext().setAccessibleName("");
        assessmentListTable.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(instruction2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instruction1Label))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(40, 40, 40))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(instruction1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instruction2Label)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(homeButton)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_homeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AssessmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssessmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssessmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssessmentWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssessmentWindow().setVisible(true);
            }
        });
    }
    
    private void updateAssessmentTable(String query){
        
    }
    
    public void addRow(ArrayList<String> data){
        DefaultTableModel model = (DefaultTableModel)assessmentListTable.getModel();
        String courseName = data.get(0);
        String courseID =  data.get(1);
        String result = data.get(3);
        String attemptDate = data.get(4);
        JButton startButton = new JButton("Start");
        startButton.setBackground(Color.white);
        startButton.setForeground(new java.awt.Color(5, 55, 255));
        
        Object[] newRow = {courseName,courseID,result,attemptDate,startButton};
        
        model.addRow(newRow);
    }
    
    private ArrayList<String> assessmentID;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assessmentListTable;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton homeButton;
    private javax.swing.JLabel instruction1Label;
    private javax.swing.JLabel instruction2Label;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel windowTitleLabel;
    // End of variables declaration//GEN-END:variables
}