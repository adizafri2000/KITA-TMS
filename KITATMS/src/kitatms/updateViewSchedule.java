import java.util.*;
import java.io.*;

public class ViewSchedule{
    private static String[][] schedule = new String[5][4];
    private static ArrayList<String> courseIDList = new ArrayList<>();
    private ArrayList<String> courseNameList = new ArrayList<>();
    private ArrayList<String> courseStartList = new ArrayList<>();
    private ArrayList<String> courseEndList = new ArrayList<>();
    private static ViewSchedule s = new ViewSchedule();
    
    public void setSchedule(){
       
        
        //DISPLAY RELATED MAKLUMAT ABOUT THE COURSE SCHEDULE GUNA 4 ARRAYLIST NI
        courseIDList.add("Course ID");
        courseNameList.add("Course Name");
        courseStartList.add("Course Start");
        courseEndList.add("Course End");
        
        courseIDList.add("TSN2201");
        courseNameList.add("Computer Networks");
        courseStartList.add("2020-03-21");
        courseEndList.add("2020-10-05");
        
        courseIDList.add("PSP1123");
        courseNameList.add("Introduction to Programming");
        courseStartList.add("2020-03-25");
        courseEndList.add("2020-04-05");
        
        courseIDList.add("MPU5541");
        courseNameList.add("Human Anthropology");
        courseStartList.add("2020-03-01");
        courseEndList.add("2020-10-30");
        
        courseIDList.add("PET3352");
        courseNameList.add("Engineering for Graduates");
        courseStartList.add("2020-04-21");
        courseEndList.add("2020-12-05");
        
    }
    
    public void displaySchedule(){
        
        /*schedule[0][0] = "Course ID";
        schedule[0][1] = "Course Name";
        schedule[0][2] = "Course Start";
        schedule[0][3] = "Course End";*/
        
        for(int e=0 ; e < courseIDList.size(); e++){
            
                schedule[e][0] = courseIDList.get(e);
                
            
        }
        System.out.println();
        for(int e=0 ; e < courseNameList.size(); e++){
            
                schedule[e][1] = courseNameList.get(e);
                
            
        }
        
        for(int e=0 ; e < courseStartList.size(); e++){
            
                schedule[e][2] = courseStartList.get(e);
                
            
        }
       
        for(int e=0 ; e < courseEndList.size(); e++){
            
                schedule[e][3] = courseEndList.get(e);
                
            
        }
        
        /*s.setSchedule();
        s.displaySchedule();
        
        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(schedule[i][j] + "  |  ");
            }
            System.out.println();
        }*/
        
    }
    public static void main(String[] args){
        s.setSchedule();
        s.displaySchedule();
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(schedule[i][j] + "  |  ");
            }
            System.out.println();
        }
    }
}