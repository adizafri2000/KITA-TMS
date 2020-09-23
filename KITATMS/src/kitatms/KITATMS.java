/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * !!!!!!! PLEASE BACA NI DULU !!!!!!!!!!!!! Ni akan jadi the real main class,
 * so every other file should be a class file. Whatever lah.\ So in main class,
 * benda ni akan ada apa2 necessary objects created from classes kita, and also
 * windows (GUI) yang kita buat. untuk senangkan testing kat sini, since kita 4
 * orang, each of us ada fx sendiri in this main class. So nak test apa2, just
 * edit in your own functions specified below, and comment out if ada nama fx
 * orang lain in the main(). Check example.
 *
 * @author adiza
 */
public class KITATMS {

    DBConnection con = new DBConnection();

    /**
     * ^
     *
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        KITATMS program = new KITATMS();
        program.adiTest();
        //program.zamTest();
        //program.hadyaTest();
        //program.wahaTest();
    }

    public void adiTest() throws SQLException {

        // TODO code application logic here
        System.out.println("Adi was here");
        DBWindow dbwindow = new DBWindow(con);
    }

    public void zamTest() {
        LoginSignUpGUI loginSignUpGUI = new LoginSignUpGUI();
    }

    public void hadyaTest() {

    }

    public void wahaTest() {

    }
    
    public void validateDatabase(){
        DBWindow dbvalidation = new DBWindow();
    }
    
    public void signUp(){
        
    }
    
    public void logIn(){
        
    }
    
    public void addCourse(){
        
    }
    
    public void uploadLearningMaterials(){
        
    }
    
    public void setAssessment(){
        
    }
    
    public void enrollTrainees(){
        
    }
    
    public void generateCourseReport(){
        
    }
    
    public void viewCourseSchedule(){
        
    }
    
    public void viewLearningMaterial(){
        
    }
    
    public void attemptCourseAssessment(){
        
    }
}
