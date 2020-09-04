package kitatms;

import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;


public class SignIn{
	private static Scanner x;

	public boolean register(String username, String password, String password2, String filepath, String accType){
		boolean success = false;
		String tempUsername = "";
                if(accType=="1"){
                    Account tempAcc = new Trainer(username,  password,  accType, username );
                }
                if(accType=="2"){
                    Account tempAcc = new Trainer(username,  password,  accType, username );
                }
                
		try{
			Writer output;
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");	
			while(x.hasNext()){
				tempUsername = x.next();
				
				if(tempUsername.trim().equals(username)){
					return false;
				}					
			}
			if(password != password2){
				return false;
			}
			if(username == "" || password=="" || username == null || password==null){
				return false;
			}
			else{
				output = new BufferedWriter(new FileWriter(filepath, true));
				output.append("\n"+username+","+password+","+accType);
				output.close();
				/*
				fileWrite.write(username+","+password);
				fileWrite.close();
				*/
				success=true;
			}
		}
		catch(Exception e){
			
		}
		return success;
	} 
}