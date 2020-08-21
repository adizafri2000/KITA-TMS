import java.util.*;

public class Student extends Person {
    public ArrayList<Subject> subjectaken = new ArrayList <Subject>();
    
    Student (String fn, String ln){
        super (fn,ln);
    }
    void remSubject (String code){
        for (int i=0; i<subjectaken.size(); i++){
            if (subjectaken.get(i).getCode().equals(code))
            {
                subjectaken.remove(i);
                System.out.println("Subject : " +code+ "removed");
            }
    }
    }   
    
    void addSubject(String cd, char res){
        subjectaken.add(new Subject(cd,res)); 
    }
    
    void printTranscript (){
        for(Subject s : subjectaken)
                 System.out.println(s);
    }
    
    //Kacau 21/8/2020
   
    public String toString(){
        return ("Student name : " + getName());
    }
    
    public static void main (String[] args){
        Student a1 = new Student ("Ali", "Baba");
        System.out.println(a1.toString());
        a1.addSubject("ABC123", 'A');
        a1.addSubject("ABC123", 'A');
        //a1.printTranscript(a1);
        
    }


    //Adi edit
}
