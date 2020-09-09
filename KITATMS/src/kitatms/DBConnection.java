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
    //private String password = "Pizz@1181101286";
    private String password;
    //private String password = "";         //password kau tukar sini pastu comment atas
    private final String DBNAME = "KITATMS";
    private Connection con;
    private final String saveFile = "dbrootpassword.txt";
    
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
     * Checks existence of db root password file
     * @return true if password save file exists
     */
    public boolean fileExists(){
        File pwFile = new File(saveFile);
        return (pwFile.exists());
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
        File pwFile = new File(saveFile);
        Scanner input = new Scanner(pwFile);
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
"  UNIQUE INDEX `learningmaterialID_UNIQUE` (`learningmaterialID` ASC) VISIBLE,\n" +
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
    /**
     * This method inserts dummy data into KITA-TMS database for testing purposes.
     */
    public void insertDummyData(){
        try (Statement stat = con.createStatement()) {
            // error probably sebab string length is way too long
                //SQL Insert query
                stat.execute("INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('0123456789', '1', 'dummytrainer1');\n");
                String dbop = "INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('0123456789', '1', 'dummytrainer1');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1234567890', '1', 'dummytrainer2');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('2345678901', '1', 'dummytrainer3');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181101286', '2', 'adi');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181101148', '2', 'zam');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181101256', '2', 'hadya');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181101272', '2', 'wahafizah');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100008', '2', 'student08');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100009', '2', 'student09');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100010', '2', 'student10');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100011', '2', 'student11');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100012', '2', 'student12');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100013', '2', 'student13');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100014', '2', 'student14');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100015', '2', 'student15');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100016', '2', 'student16');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100017', '2', 'student17');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100018', '2', 'student18');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100019', '2', 'student19');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100020', '2', 'student20');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100021', '2', 'student21');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100022', '2', 'student22');\n" +
"INSERT INTO `kitatms`.`account` (`accountID`, `accountType`, `accountPassword`) VALUES ('1181100023', '2', 'student23');";
                stat.execute(dbop);
                
                dbop = "INSERT INTO `kitatms`.`trainer` (`trainerName`, `accountID`) VALUES ('Yagami Hikari', '0123456789');\n" +
"INSERT INTO `kitatms`.`trainer` (`trainerName`, `accountID`) VALUES ('Nathan Freihofer', '1234567890');\n" +
"INSERT INTO `kitatms`.`trainer` (`trainerName`, `accountID`) VALUES ('Izara Aishah', '2345678901');";
                stat.execute(dbop);
                
                dbop = "INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Adi Zafri Bin Mohd Tahir', '1181101286');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Mohamad Zamfirdaus Bin Mohd Saberi', '1181101148');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Hadya Ayeisha Binti Marzuki', '1181101256');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Nur Wahafizah Binti Ahmadi', '1181101272');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Brooke Monk', '1181100008');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Bella Poarch', '1181100009');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Jeff Mancuso', '1181100010');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Orimoto Izumi', '1181100011');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Jabami Yumeko', '1181100012');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Yumemite Yumemi', '1181100013');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Matsuda Takato', '1181100014');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Jung Yerin', '1181100015');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Heinz Doofenshmirtz', '1181100016');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Eugene Krabs', '1181100017');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Phil Swift', '1181100018');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Seth Rollins', '1181100019');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Brock Lesnar Jr', '1181100020');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Ronald Weasley', '1181100021');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Chris Sutherland', '1181100022');\n" +
"INSERT INTO `kitatms`.`trainee` (`traineeName`, `accountID`) VALUES ('Zoe LaVerne', '1181100023');";
                stat.execute(dbop);
                
                dbop = "INSERT INTO `kitatms`.`course` (`courseID`, `courseName`, `courseStart`, `courseEnd`, `accountID`) VALUES ('PSP5521', 'Introduction to Digital Systems', '2020-10-05', '2020-11-01', '2345678901');\n" +
"INSERT INTO `kitatms`.`course` (`courseID`, `courseName`, `courseStart`, `courseEnd`, `accountID`) VALUES ('PPZ2290', 'Introduction to Physics', '2020-10-14', '2020-11-13', '1234567890');";
                stat.execute(dbop);
                
                dbop = "INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181101286', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100012', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100017', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181101148', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100019', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100011', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100014', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100015', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100018', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100016', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181101272', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100008', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100022', 'PPZ2290');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100009', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100020', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100022', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100017', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100016', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100012', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181101286', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100015', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181100021', 'PSP5521');\n" +
"INSERT INTO `kitatms`.`enrollment` (`accountID`, `courseID`) VALUES ('1181101272', 'PSP5521');";
                stat.execute(dbop);
                
                System.out.println("Dummy data successfully inserted into program database.");
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

