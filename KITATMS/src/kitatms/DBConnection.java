/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DBConnection class synchronizes team members' connection to a MySQL database.
 * Class serves the following:
 *  1. Establish/Check connectivity of user to MySQL service.
 *  2. Establish/Check connectivity to program's specified database.
 *  3. Create program's specified database should end-users do not have it in their devices.
 *  4. Create and execute MySQL query statements.
 * @author adiza
 */
public class DBConnection {
    
    private final String username = "root";
    private String password;
    private final String DBNAME = "KITATMS";
    Connection con;
    private final String saveFile = "password.txt";
    
    /**
     * DBConnection constructor only ensures that the program successfully connects to KITATMS database schema in 
     * the user's MySQL local instance.
     * 
     * DBConnection algorithm:
     *  1. Program checks existence of password.txt to retrieve password.
     *      True : Proceeds to step 2.
     *      False: Program requests db password from user. Repeat until 'true' case reached. CARRY FLAG 1.
     * 
     *  2. Program checks if MySQL can be connected to local instance (root db) with the password.
     *      True : 
     *          CARRY FLAG 1: Program saves the password in a .txt file so users do not need to re-enter password.
     *          ELSE        : Proceeds to step 3.
     *      False: Program asks for another password from the user until 'true' case is reached.
     * 
     *     *** NO MORE SAVE FILE password.txt CONFIGURATION/ACCESS FROM HERE ***
     * 
     *  3. Program checks if the program's official database, KITATMS, is present in the MySQL local instance.
     *      True : OVERALL CONNECTIVITY SUCCESSFUL.
     *      False: Program setups the database schema KITATMS in the user's MySQL local instance. Rechecks to ensure 'true' 
     *             case is reached.
     */
    public DBConnection(){
        while(true){
            try{
                File file = new File(saveFile);
                Scanner input = new Scanner(file);
                setPassword(input.nextLine());
                if(isConnectedMySQL()){
                    if (isConnectedDB()){
                        System.out.println("Successful connection to KITATMS database.");
                        break;
                    }
                    else
                        setupDB();
                }
                else{
                    try {
                        FileWriter fw = new FileWriter(saveFile);
                        System.out.println("");
                    } catch (IOException ex) {
                        Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (FileNotFoundException e){
                System.out.println("No save file found.");
            }
        }
        
        /*
        public class ReadFile {
            static int[][] testData = new int[8][7];
          public static void main(String[] args) {
            try {
              File myObj = new File("dataText.txt");
              Scanner myReader = new Scanner(myObj);
              int i = 0;
              int j = 0;
              while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] gg = myReader.nextLine().split("\n");
                String[] kk = new String[7];
                for (String s:gg)
                System.out.println(gg);
              }
              myReader.close();
            } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              //e.printStackTrace();
            }
          }
        }
        */
    }
    
    public void setPassword(String p){
        this.password = p;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPasswowrd(){
        return password;
    }
    
    /**
     * Checks whether user can connect to a MySQL service
     * @return true is successful connection, false otherwise
     */
    public boolean isConnectedMySQL(){
        try {
            System.out.println("Establishing connecetion to MySQL...");
            con  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/?serverTimezone=UTC", //URL
                username,password);
            return true;
            
        }
        catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean isConnectedDB(){
        if (isConnectedMySQL()){
            try {
                System.out.println("Establishing connecetion to official program database...");
                con  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/KITATMS?serverTimezone=UTC", //URL
                    username,password);
                return true;

            }
            catch (SQLException ex) {
                return false;
            }
        }
        else{
            System.out.println("Official program database does not exist.");
            return false;
        }
    }
    
    public void setupDB() throws SQLException{
        con  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/?serverTimezone=UTC", //URL
                username,password);
        
        try (Statement stat = con.createStatement()) {
                //SQL Insert query
                String dbop = "CREATE DATABASE KITATMS;";
                stat.executeUpdate(dbop);
                System.out.println("Database KITATMS successfully created.");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
