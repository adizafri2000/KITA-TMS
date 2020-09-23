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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    private Connection con;
    private File saveFile;
    private final String saveFileName = "dbrootpassword.txt";
    private File dummyDataFile;
    private final String dummyDataFileName = "ERDDataInsertion.txt";
    
    /*
    1. check file exist
        T: proceed 2.
        F: create new file. getPassword() and writePassword(). to 3.
    2. check file contains password
        T: proceed 3
        F: getPassword and writePassword(). to 3
    3. check connection using password
        T: passed all. ready for use
        F: getPassword() and writePassword(). retry 3.
    
    
    */
    public DBConnection(){
        this.password = " ";
    }
    
    /**
     * Checks existence of one of the files
     * @param f
     * @param name
     * @return true if password save file exists
     */
    public boolean fileExists(File f,String name){
        f = new File(name);
        return (f.exists());
    }
    
    public void createPWFile(){
        try {
            FileWriter myWriter = new FileWriter(saveFile);
            //getPassword()
            //writePassword()
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    /*
    try {
            FileWriter myWriter = new FileWriter("dataText.txt");
            for (int i=0;i<8;i++){
                for (int j=0;j<7;j++){
                    myWriter.write(data[i][j]);
                    myWriter.write("\t");
                }
                myWriter.write("\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    */
    
    public boolean readPassword(){
        try{
        saveFile = new File(saveFileName);
        Scanner input = new Scanner(saveFile);
        if(input.hasNext())
            return true;
        else
            return false;
        } catch (FileNotFoundException e){
            return false;
        }
    }
    
    public void writePassword(String p){
        setPassword(p);
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
     * Creates and connects users to a MySQL service
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
     * This method creates and checks if user is currently connected to KITA-TMS official database
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
     * Retrieves data from the database.
     * @param query The SQL query line to be executed
     * @param column The column name of the table holding the data
     * @return an ArrayList of Strings containing the desired data to be retrieved
     * @throws SQLException 
     */
    public ArrayList<String> retrieve(String query,String column) throws SQLException{
        ArrayList<String> dataList = new ArrayList<>();
        try(Statement stat = con.createStatement()){
            ResultSet rs = stat.executeQuery(query);
            while(rs.next()){
                String data = rs.getString(column);         
                dataList.add(data);
            }
        }catch(SQLException e){
            System.out.println("Data retrieval failed, returning empty ArrayList.");
        }
        
        System.out.println("No errors during retrieval.");
        return dataList;
    }
    
    /**
     * Updates the database with given query line
     * @param query
     * @return true if update action is successful
     * @throws SQLException 
     */
    public boolean update(String query) throws SQLException{
        try (Statement stat = con.createStatement()) {
                stat.execute(query);
                System.out.println("Database successfully updated.");
                return true;
            
        } catch (SQLException ex) {
            System.out.println("Database update failed.");
            return false;
        }
    }
    
    /**
     * This method setups KITA-TMS official database for its overall program in
     * implementing a database as a data storage.
     * @throws SQLException 
     */
    public void setupDB() throws SQLException{
        
        try (Statement stat = con.createStatement()) {
                //SQL Insert query
                String dbop = "CREATE DATABASE KITATMS;";
                stat.executeUpdate(dbop);
                System.out.println("Database KITATMS successfully created.");
                if(isConnectedDB())
                    setupTables();
            
        } catch (SQLException ex) {
            //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);\
            System.out.println("Database creation failed.");
        }
    }
    
    /**
     * This method, in conjunction with setupDB(), creates all the tables involved in
     * KITA-TMS's database implementation.A total of 10 tables are created after invoking this method:
 Account, Trainer, Trainee, Course, Enrollment, Report, LearningMaterial,
 Assessment, View, Attempt, Report
     * @throws java.sql.SQLException
     */
    public void setupTables() throws SQLException{
        try (Statement stat = con.createStatement()) {
                String account = "create table account(\n" +
"	accountID varchar(10) primary key not null unique,\n" +
"    accountType int not null,\n" +
"	accountPassword varchar(15) not null\n" +
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
"    accountID varchar(10) not null references account(accountID)\n" +
");";
                
                String enrollment = "CREATE TABLE `kitatms`.`enrollment` (\n" +
"  `accountID` VARCHAR(10) NOT NULL,\n" +
"  `courseID` VARCHAR(7) NOT NULL,\n" +
"  PRIMARY KEY (`accountID`, `courseID`),\n" +
"    FOREIGN KEY (`accountID`)\n" +
"    REFERENCES `kitatms`.`account` (`accountID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION,\n" +
"    FOREIGN KEY (`courseID`)\n" +
"    REFERENCES `kitatms`.`course` (`courseID`)\n" +
"    ON DELETE NO ACTION\n" +
"    ON UPDATE NO ACTION);";
                
                String report = "create table report(\n" +
"	reportID varchar(13) primary key not null unique,\n" +
"	courseID varchar(7) not null references course(courseID)\n" +
");";
                
                String learningmaterial = "create table learningmaterial(\n" +
"	learningmaterialID varchar(10) primary key not null unique,\n" +
"    learningmaterialName varchar(50) not null,\n" +
"    courseID varchar(7) not null references course(courseID)\n" +
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
                System.out.println("10 program database tables succesfully created.");
            
        } catch (SQLException ex) {
            //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Database tables' setup failed.");
        }
    }

    
    /**
     * Clears all data and tables in program database
     */
    public void clearData(){
        try (Statement stat = con.createStatement()) {
                //SQL Insert query
                String dbop = "DROP SCHEMA KITATMS;";
                stat.executeUpdate(dbop);
                System.out.println("Program database successfully cleared.");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean dataFileExists(){
        return fileExists(dummyDataFile,dummyDataFileName);
    }
    
    public boolean passwordFileExists(){
        return fileExists(saveFile,saveFileName);
    }
    
    /**
     * This method inserts dummy data into KITA-TMS database for testing purposes.
     * @throws java.io.FileNotFoundException
     */
    public void insertDummyData() throws FileNotFoundException{
        try (Statement stat = con.createStatement()) {
                //SQL Insert query
                Scanner reader = new Scanner(new File(dummyDataFileName));
                while(reader.hasNext()){
                    stat.execute(reader.nextLine());
                }
                System.out.println("Data successfuly inserted into program database.");
            
        } catch (SQLException ex) {
            //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);\
            System.out.println("Database creation failed.");
        }
    }
}    