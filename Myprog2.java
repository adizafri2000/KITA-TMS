import java.util.ArrayList;
import java.util.Scanner;

public class Myprog2
{
    public static void main(String[] args){ 
        Scanner input = new Scanner(System.in);
        Employee Employee1 = new Employee("Bob","Male",114);
        Employee Employee2 = new Employee("Thomas","Male");
        System.out.println(Employee1.toString());
        System.out.println(Employee2.toString());
    }
}