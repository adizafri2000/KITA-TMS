/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private String courseStart;
    
    /**End date of this course*/
    private String courseEnd;
    
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
            ArrayList<Trainee> courseParticipants, String coureStart, String courseEnd){
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
    public Course(String courseID, String courseName,String coureStart, String courseEnd){
        this.courseID = courseID;
        this.courseName = courseName;     
        this.courseStart = coureStart;
        this.courseEnd = courseEnd;
    }
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
    
    /**
     * Returns the starting date of this course in the format YYYY-MM-DD
     * @return course starting date
     */
    public String getCourseStart(){
        return courseStart;
    }
    
    /**
     * Returns the end date of this course in the format YYYY-MM-DD
     * @return course end date
     */
    public String getCourseEnd(){
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
    
    /**
     * Sets the course start date. <p>
     * HINT: USE GREGORIAN CALENDAR TO CREATE A CALENDAR (DATE) OBJECT <p>
     * e.g course.setCourseStart(new GregorianCalendar(2010,2,15));
     * @param courseStart 
     */
    public void setCourseStart(String courseStart){
        this.courseStart = courseStart;
    }
    
    /**
     * Sets the course start date. <p>
     * HINT: USE GREGORIAN CALENDAR TO CREATE A CALENDAR (DATE) OBJECT <p>
     * e.g course.setCourseEnd(new GregorianCalendar(2010,2,15));
     * @param courseEnd 
     */
    public void setCourseEnd(String courseEnd){
        this.courseEnd = courseEnd;  
    }
    
    /**
     * Returns a String representation of course start date
     * @return course start date in "YYYY-MM-DD"
     */
    public String printCourseStart(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(courseStart);
    }
    
    /**
     * Returns a String representation of course end date
     * @return course start date in "YYYY-MM-DD"
     */
    public String printCourseEnd(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(courseEnd);
    }
}
