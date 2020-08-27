package dbstudies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BACA NI DULU!!!
 * 
 * Function createConnection():
 * Remember to set ikut korang punya URL and password
 * 
 * Before buat query punya part, MAKE SURE table is already created in database
 * Once created, boleh create a query String, or ubah query2 bawah ni ikut table masing2
 * 
 * After query is created, program executes query. Then, kita kena specify the data in which column of the table yang kita nak
 * eg.
 * 1. TABLE CATS ada COLUMN NAME and COLUMN AGE
 * 2. QUERY SELECTS ALL from TABLE CATS
 * 3. Code (KITA) specify yang kita nak NAME of orang2 terlibat dalam TABLE CATS
 * 4. PROGRAM retrieves ALL from COLUMN NAME only from TABLE CATS
 * 
 * So, data from only one column is printed. Multiple data retrieval nanti kita explore.
 * @author adiza
 */
public class DBstudies {
    
    public static void main(String[] args){
        //System.out.println("Project build is too long...");
        DBstudies dbProject2 = new DBstudies();
        dbProject2.createConnection();
    }
    
    void createConnection(){
        
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Establishing connecetion");
            Connection con  = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test1?serverTimezone=UTC", //URL
                "root",     //db username
                "Pizz@1181101286");     //password
            
            Statement stat = con.createStatement();
            //QUERY STRINGS
            String s1 = "SELECT * FROM TEAMMEMBERS";
            String s2 = "SELECT * FROM CATS";
            String s3 = "SELECT * FROM TEAMMEMBERS WHERE Name like 'A%'";
            //get learning material file name
            String s4 = "SELECT * FROM LEARNING_MATERIALS";
            String s5 = "SELECT * FROM LEARNING_MATERIALS where learning_materials_id='ABC2501'";
            String FILE_FIELD_NAME = "learning_materials_filename";
            //QUERY ENDS
            
            ResultSet rs = stat.executeQuery(s2);
            while(rs.next()){
                //TABLE COLUMN NAME GOES HERE 
                String column = "name";
                
                String name = rs.getString(column);         
                System.out.println(name);
            }
            
            System.out.println("Database successfully connected");
        } /*catch (ClassNotFoundException ex) {
            Logger.getLogger(DBstudies.class.getName()).log(Level.SEVERE, null, ex);
        } 
        Taktau apa function atas ni*/
        catch (SQLException ex) {
            Logger.getLogger(DBstudies.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*url format:
        connector:database_software://connection_loaction:DBport/DBname
        */
    }
    
    /*void connectFile(){
        File file = new File(fileName);

        try {
            Desktop desktop = Desktop.getDesktop();

            // Open a file using the default program for the file type. In the example 
            // we will launch a default registered program to open a text file. For 
            // example on Windows operating system this call might launch a notepad.exe 
            // to open the file.
            desktop.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

}
