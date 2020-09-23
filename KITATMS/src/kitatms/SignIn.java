package kitatms;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.sql.SQLException;


public class SignIn{
        DBConnection con = new DBConnection();
	private static Scanner x;

	public boolean register(String username, String password, String password2, String accType) throws SQLException{
                
		boolean success = true;
		String tempUsername = "";
                //Account tempAcc;
                if("1".equals(accType)){
                    //tempAcc = new Trainer(username,  password,  accType, username );
                    success = con.update("INSERT INTO kitatms.account (accountID,accountType,accountPassword) VALUES ('11111111',1,'hello2');");
                }
                if("2".equals(accType)){
                    
                    //tempAcc = new Trainer(username,  password,  accType, username );
                    success = con.update("INSERT INTO kitatms.account (accountID,accountType,accountPassword) VALUES ('zamencem',1,'hello2');");
                }             
                
		return success;
	} 
}