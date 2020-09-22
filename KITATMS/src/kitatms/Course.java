/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Course object translates to real courses where a Trainer creates and enrolls Trainees into it
 * @author adiza
 */
public class Course {
    
    /**Unique ID of this course */
    private String courseID;
    
    /**Name of this course */
    private String courseName;
    
    /**The trainer who creates this course */
    private Trainer trainer;
    
    /**List of Trainees who are enrolled in this course*/
    private ArrayList<Trainee> courseParticipants;
    
    /**Starting date of this course*/
    private Calendar courseStart;
    
    /**End date of this course*/
    private Calendar courseEnd;
    
    /**
     * Constructs a new Course object
     * @param courseID
     * @param courseName
     * @param trainer Creator of this course
     * @param courseParticipants List of Trainees enrolled
     * @param coureStart
     * @param courseEnd 
     */
    public Course(String courseID, String courseName, Trainer trainer,
            ArrayList<Trainee> courseParticipants, Calendar coureStart, Calendar courseEnd){
        this.courseID = courseID;
        this.courseName = courseName;
        this.trainer = trainer;
        this.courseParticipants = courseParticipants;
        this.courseStart = coureStart;
        this.courseEnd = courseEnd;        
    }
    
    /**
     * Empty constructor for course object
     */
    public Course(){}
    
    /**
     * Returns this course's ID
     * @return 
     */
    public String getCourseID(){
        return courseID;
    }
    
    public String getCourseName(){
        return courseName;
    }
    
    public Trainer getTrainer(){
        return trainer;
    }
    
    public ArrayList<Trainee> getCourseParticipants(){
        return courseParticipants;
    }
    
    public Calendar getCourseStart(){
        return courseStart;
    }
    
    public Calendar getCourseEnd(){
        return courseEnd;
    }
    
    public void setCourseID(String courseID){
        this.courseID = courseID;
    }
    
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    
    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
    }
    
    public void setCourseParticipants(ArrayList<Trainee> courseParticipants){
        this.courseParticipants = courseParticipants;
    }
    
    public void setCourseStart(Calendar courseStart){
        this.courseStart = courseStart;
    }
    
    public void setCourseEnd(Calendar courseEnd){
        this.courseEnd = courseEnd;  
    }
    
    
    public void printCourseStart(){
        //System.out.println(courseStart.toString());
        //String real = courseStart.getDisplayName(Calendar.YEAR, Calendar.LONG, Locale.JAPAN);
        //System.out.println(real);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(courseStart.getTime()));
    }
    
    public static void main(String[] args){
        Course c = new Course();
        c.printCourseStart();
    }
}
