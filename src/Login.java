package src;
import java.util.*;
import java.io.File;  // Import the File class


public class Login{
	
	private static Scanner x;

	public boolean verifyLogin(String username, String password, String filepath){
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
            System.out.println("tak jumpa file tu wey!");
		}
        return found;
        
	} 
	public void doVerify(){
	    
	}
}