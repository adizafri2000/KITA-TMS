/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;

/**
 *
 * @author adiza
 */
public class Assessment {
    private String assessmentID;
    private String assessmentName;
    private Course course;
    private String[] questions = new String[5];
    private String[] answers = new String[5];
    private int marks;
    
    public Assessment(){}
    
    public void generateAssessmentID(Course course){
        String ID = "A"+(course.getCourseID());
        assessmentID = ID;
    }
    
    public void setCourse(Course course){
        this.course = course;
    }
    
    public void setQuestions(String[] questions){
        this.questions = questions;
    }
    
    public void setAnswers(String[] answers){
        this.answers = answers;
    }
    
    public void setMarks(int m){
        marks = m;
    }
    
    public int calculateMarks(String[] submittedAnswers){
        int total = 0;
        for(int i=0;i<5;i++){
            if (submittedAnswers[i].equals(answers[i]))
                ++total;
        }
        return total;
    }
    
    public String getAssessmentID(){
        return assessmentID;
    }
    
    public String getAssessmentName(){
        return assessmentName;
    }
    
    public Course getCourse(){
        return course;
    }
    
    public String[] getQuestions(){
        return questions;
    }
    
    public String[] getAnswers(){
        return answers;
    }
    
    public int getMarks(){
        return marks;
    }
}
