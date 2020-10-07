package kitatms;

import java.util.*;
import java.io.*;

public class ViewSchedule{
    private static String[][] schedule = new String[10][4];
    private ArrayList<String> courseIDList = new ArrayList<>();
    private ArrayList<String> courseNameList = new ArrayList<>();
    private ArrayList<String> courseStartList = new ArrayList<>();
    private ArrayList<String> courseEndList = new ArrayList<>();
    private static ViewSchedule s = new ViewSchedule();
    
    public void setSchedule(){
       
        
        //DISPLAY RELATED MAKLUMAT ABOUT THE COURSE SCHEDULE GUNA 4 ARRAYLIST NI
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
        
        
        for(int i=0;i<courseIDList.size();i++){
            System.out.printf("%s (%s) : %s to %s \n",courseNameList.get(i),courseIDList.get(i),courseStartList.get(0),courseEndList.get(i));
        }
    }
    
    public void displaySchedule(){
        
        schedule[0][0] = "Course ID";
        schedule[0][1] = "Course Name";
        schedule[0][2] = "Course Start";
        schedule[0][3] = "Course End";
        
        for(int i = 1; i<4; i++){
            for (int e=0 ; e < courseIDList.size(); e++){
                schedule[i][0] = courseIDList.get(e);
                System.out.println(schedule[i][0]);
            }
        }
        for(int i = 1; i<4; i++){
            for (int e=0 ; e < courseNameList.size(); e++){
                schedule[i][1] = courseNameList.get(e);
                System.out.println(schedule[i][1]);
            }
        }
        for(int i = 1; i<4; i++){
            for (int e=0 ; e < courseStartList.size(); e++){
                schedule[i][2] = courseStartList.get(e);
                System.out.println(schedule[i][2]);
            }
        }
        for(int i = 1; i<4; i++){
            for (int e=0 ; e < courseEndList.size(); e++){
                schedule[i][3] = courseEndList.get(e);
                System.out.println(schedule[i][3]);
            }
        }
        
        /*for(int i = 0; i < 10; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(schedule[i][j]);
            }
        }*/
        
    }
    public static void main(String[] args){
        s.setSchedule();
        s.displaySchedule();
        System.out.print("\n\n\n");
        
        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(schedule[i][j] + "  |  ");
            }
            System.out.println();
        }
    }
}