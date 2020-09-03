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
public class Trainer extends Account{
    public String trainerName;
    
    public Trainer(String username, String password, String accountType, String name){
        super(username,password,"1");
        this.trainerName = name;
    }
    public String getTrainerName(){
        return trainerName;
    }
}
