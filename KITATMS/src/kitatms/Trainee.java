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
public class Trainee extends Account{
    public String traineeName;
    
    public Trainee(String username, String password, String accountType, String name){
        super(username,password,"2");
        this.traineeName = name;
    }
    public String getTraineeName(){
        return traineeName;
    }
}
