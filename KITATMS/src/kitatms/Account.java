/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

/**
 *
 * @author zamfirdaus
 */
public class Account {
    public String accountID;
    public String username;
    public String password;
    public String accountType;
    
    public Account(String username, String password, String accountType){
        this.username = username;
        this.password = password;
        this.accountType = accountType;
    } 

    Account() {
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String name){
        this.username = name;
    }
    public String getAccountType(String name){
        return accountType;
    }
    
    public void setAccountID(){
        this.accountID = username;
    }
    
    public String getAccountID(){
        return accountID;
    }
    
    
}
