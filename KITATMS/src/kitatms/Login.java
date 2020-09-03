/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;
import java.util.*;
import java.io.File;  // Import the File class


public class Login{
	
	private static Scanner x;

	public boolean verifyUser(String username, String password, String filepath){
		String tempUsername = username;
		String tempPassword = password;
		boolean found = false;
		
		try{
			x = new Scanner(new File(filepath));
			x.useDelimiter("[,\n]");
		
			while(x.hasNext() && !found){
				tempUsername = x.next();
				tempPassword = x.next();
				
				if(tempUsername.trim().equals(username) && tempPassword.trim().equals(password)){
					found = true;
				}
					
			}
			return found;
		}
		catch(Exception e){
		}
		return found;
	} 
	public void doVerify(){
	    
	}
}