package kitatms;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.sql.SQLException;
import static kitatms.SignUp_LoginWindow.con;


public class SignUp{
        DBConnection con = new DBConnection();
	private static Scanner x;
        
        
        public SignUp(DBConnection con){
            this.con = con;
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    //new SignUp_LoginWindow().setVisible(true);
                }
            });
        }
        

	public boolean register(String username,String accType, String password) throws SQLException{
                
		boolean success = false;
                //Account tempAcc;
                if("1".equals(accType)){
                    success = con.update("INSERT INTO kitatms.account (accountID,accountType,accountPassword) VALUES ('"+username+"',1,'"+password+"');");
                }
                if("2".equals(accType)){ 
                    success = con.update("INSERT INTO kitatms.account (accountID,accountType,accountPassword) VALUES ('"+username+"',2,'"+password+"');");
                }             
                
		return success;
	} 
}