
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import com.itextpdf.text.Document;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adiza
 */
public class Report {
    private Course course;
    private Trainer trainer;
    private ArrayList<Trainee> traineeList;
    private ArrayList<String> traineeID;
    private DBConnection con;
    
    public Report(){}
    
    public void setConnection(DBConnection con){
        this.con = con;
    }
    
    public void setCourse(Course c){
        course = c;
    }
    
    public void setTrainer(Trainer t){
        trainer = t;
    }
    
    public void setTraineeID(Course c) throws SQLException{
        String courseID = c.getCourseID();
        String query = "select * from enrollment where courseID='"+courseID+"';";
        traineeID = con.retrieve(query, "accountID;");
    }
    
    public void setTraineeList(ArrayList<Trainee> t){
        traineeList = t;
    }
    
    public Course getCourse(){
        return course;
    }
    
    public Trainer getTrainer(){
        return trainer;
    }
    
    public void generateReport(){
        //itextpdf document generation here
    }
    
    
}
