/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.sql.SQLException;

/**
 *
 * @author adiza
 */
public class KITATMS {

    /**^
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        System.out.println("Adi was here");
        DBConnection tester = new DBConnection();
        System.out.println(tester.readPassword());
        /*System.out.println(tester.isConnectedMySQL());
        System.out.println(tester.isConnectedDB());
        if(!tester.isConnectedDB()){
            tester.setupDB();
            System.out.println(tester.isConnectedDB());
            tester.setupTables();
        }
        System.out.println("Program ended. View KITATMS schema in MySQL for re-checking.");*/
        //tester.clearData();
    }

}
