package kitatms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BACA NI DULU!!!!
 * 
 * Function createConnection():
 * URL Format: 
 * jdbc:mysql://localhost:3306/DATABASENAME?serverTimezone=UTC
 * Pastu include db username (root) and password
 * 
 * 
 * Function jButton1ActionPerformed():
 * In the end, dia extract 3 data: int id, String name, String role
 * Data extracted from jTextField dalam GUI Window
 * MAKE SURE TO INPUT DATA LIKE:
 * INTEGER<space>STRING<space>STRING
 *   (id)        (name)       (role)
 * 
 * Any other forms of spacing between perkataan is accepted as data for the next entry;
 * i.e Data: "123 Bob Zainal Goalkeeper"
 * Data extracted:
 * id = 123
 * name = Bob
 * Role = Zainal
 * 
 * 
 * @author adiza
 */
public class DB2 extends javax.swing.JFrame {

    Connection con;
    public DB2() {
        initComponents();
        createConnection();
    }
    
    /**
     * Establishes a connection to a database
     */
    void createConnection(){
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Establishing connecetion");
            con  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC",     //URL goes here
                "root",     //db username
                "Pizz@1181101286");         //db username password

            
            System.out.println("Database successfully connected");
        } /*catch (ClassNotFoundException ex) {
            Logger.getLogger(DBstudies.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Taktau apa function atas ni*/
        catch (SQLException ex) {
            Logger.getLogger(DBstudies.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*url format:
        connector:database_software://connection_location:DBport/DBname
        */
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Inputs = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Insert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label.setText("Add new team member");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Inputs, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            //receives anything in the text field
            String all = Inputs.getText();
            ArrayList<String> arguments = new ArrayList<>(Arrays.asList(all.split(" ")));
            int StudentID = Integer.parseInt(arguments.get(0));
            String Role = arguments.get(2);
            String name = arguments.get(1);
            //SQL Insert query
            try (Statement stat = con.createStatement()) {
                //SQL Insert query
                String dbop = "INSERT INTO TEAMMEMBERS VALUES("
                        +StudentID
                        +",'"+name+"',"
                        +"'"+Role+"');";
                stat.execute(dbop);
                label.setText(name+" successfully added into database.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DB2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Inputs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel label;
    // End of variables declaration//GEN-END:variables
}
