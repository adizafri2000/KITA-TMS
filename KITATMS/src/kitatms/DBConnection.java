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
    private String password = "Pizz@1181101286";
    private final String DBNAME = "KITATMS";
    private Connection con;
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
    /*public DBConnection(){
        while (true){
            try{
                File readPW = new File(saveFile);
                Scanner fInput = new Scanner(readPW);
                password = fInput.nextLine();
                if(isConnectedMySQL()){
                    if(isConnectedDB()){
                        System.out.println("Database ready to use for program");
                    }
                    else{
                        //setupDB()
                    }
                }
                else{
                    
                }
            }catch (FileNotFoundException e){
                
            }catch (IOException e){
                
            }
        }
    }*/
    public DBConnection(){
        
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
    
    /**
     * This method checks if user is currently connected to KITA-TMS official database
     * DB/Schema name: "KITATMS"
     * @return true is successful connection, false otherwise
     */
    public boolean isConnectedDB(){
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
    
    /**
     * This method setups KITA-TMS official database for its overall program in
     * implementing a database as a data storage.
     * @throws SQLException 
     */
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
    
    /**
     * This method, in conjunction with setupDB(), creates all the tables involved in
     * KITA-TMS's database implementation.
     * A total of 10 tables are created after invoking this method:
     * Account, Trainer, Trainee, Course, Enrollment, Report, LearningMaterial,
     * Assessment, View, Attempt, Report
     */
    public void setupTables(){
        try (Statement stat = con.createStatement()) {
                String account = "create table account(\n" +
"	accountID varchar(10) primary key not null unique,\n" +
"    accountType int not null\n" +
");";
                
                String trainer = "create table trainer(\n" +
"	trainerName varchar(50) not null,\n" +
"    accountID varchar(10) not null unique references account(accountID)\n" +
");";
                
                String trainee = "create table trainee(\n" +
"	traineeName varchar(50) not null,\n" +
"    accountID varchar(10) not null unique references account(accountID)\n" +
");";
                
                String course = "create table course(\n" +
"	courseID varchar(7) primary key not null unique,\n" +
"    courseName varchar(50) not null,\n" +
"    courseStart Date not null,\n" +
"    courseEnd Date not null,\n" +
"    accountID varchar(10) not null unique references account(accountID)\n" +
");";
                
                String enrollment = "CREATE TABLE `kitatms`.`enrollment` (\n" +
"  `accountID` VARCHAR(10) NOT NULL,\n" +
"  `courseID` VARCHAR(7) NOT NULL,\n" +
"  PRIMARY KEY (`accountID`, `courseID`),\n" +
"  UNIQUE INDEX `accountID_UNIQUE` (`accountID` ASC) VISIBLE,\n" +
"  UNIQUE INDEX `courseID_UNIQUE` (`courseID` ASC) VISIBLE,\n" +
"  CONSTRAINT `accountID`\n" +
"    FOREIGN KEY (`accountID`)\n" +
"    REFERENCES `kitatms`.`account` (`accountID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"  CONSTRAINT `courseID`\n" +
"    FOREIGN KEY (`courseID`)\n" +
"    REFERENCES `kitatms`.`course` (`courseID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);";
                
                String report = "create table report(\n" +
"	reportID varchar(13) primary key not null unique,\n" +
"	courseID varchar(7) not null unique references course(courseID)\n" +
");";
                
                String learningmaterial = "create table learningmaterial(\n" +
"	learningmaterialID varchar(10) primary key not null unique,\n" +
"    learningmaterialName varchar(50) not null,\n" +
"    courseID varchar(7) not null unique references course(courseID)\n" +
");";
                
                String assessment = "create table assessment(\n" +
"	assessmentID varchar(8) primary key not null unique,\n" +
"    assessmentQuestions mediumtext not null,\n" +
"    assessmentAnswers varchar(5) not null,\n" +
"    courseID varchar(7) not null unique references course(courseID)\n" +
");";
                
                String view = "CREATE TABLE `kitatms`.`view` (\n" +
"  `learningmaterialID` VARCHAR(10) NOT NULL,\n" +
"  `accountID` VARCHAR(10) NOT NULL,\n" +
"  `viewstatus` VARCHAR(1) NULL,\n" +
"  UNIQUE INDEX `learningmaterialID_UNIQUE` (`learningmaterialID` ASC) VISIBLE,\n" +
"  UNIQUE INDEX `accountID_UNIQUE` (`accountID` ASC) VISIBLE,\n" +
"    FOREIGN KEY (`learningmaterialID`)\n" +
"    REFERENCES `kitatms`.`learningmaterial` (`learningmaterialID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"    FOREIGN KEY (`accountID`)\n" +
"    REFERENCES `kitatms`.`account` (`accountID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);";
                
                String attempt = "CREATE TABLE `kitatms`.`attempt` (\n" +
"  `accountID` VARCHAR(10) NOT NULL,\n" +
"  `assessmentID` VARCHAR(8) NOT NULL,\n" +
"  `attemptMarks` INT NOT NULL,\n" +
"  `attemptDate` DATE NOT NULL,\n" +
"  PRIMARY KEY (`accountID`, `assessmentID`),\n" +
"  INDEX `assessmentID_idx` (`assessmentID` ASC) VISIBLE,\n" +
"    FOREIGN KEY (`accountID`)\n" +
"    REFERENCES `kitatms`.`trainee` (`accountID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"    FOREIGN KEY (`assessmentID`)\n" +
"    REFERENCES `kitatms`.`assessment` (`assessmentID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);";
                
                
                stat.executeUpdate(account);
                stat.executeUpdate(trainer);
                stat.executeUpdate(trainee);
                stat.executeUpdate(course);
                stat.executeUpdate(enrollment);
                stat.executeUpdate(report);
                stat.executeUpdate(learningmaterial);
                stat.executeUpdate(assessment);
                stat.executeUpdate(view);
                stat.executeUpdate(attempt);
            
        } catch (SQLException ex) {
            Logger.getLogger(DB2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setupEverything(){
        try {
            setupDB();
            setupTables();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * This method inserts dummy data into KITA-TMS database for testing purposes.
     */
    //public void dummyData(){}
}

