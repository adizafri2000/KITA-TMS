
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitatms;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adiza
 */
public class Report {
    private Course course;
    private Account trainer;
    private ArrayList<Account> traineeList;
    private ArrayList<String> traineeID;
    private DBConnection con;
    private String fileName;
    
    public Report(){
        traineeID = new ArrayList<>();
    }
    
    public void setFileName(){
        fileName = course.getCourseID();
        fileName+="Report.pdf";
    }
    
    public void setConnection(DBConnection con){
        this.con = con;
    }
    
    public void setCourse(Course c){
        course = c;
    }
    
    public void setTrainer(Account t){
        trainer = t;
    }
    
    public void setTraineeID(Course c){
        try {
            String courseID = c.getCourseID();
            System.out.println(courseID+" in setTraineeID()");
            
            String query = "select * from enrollment where courseID='"+courseID+"';";
            query = "SELECT * FROM kitatms.enrollment where courseID='"+courseID+"';";
            traineeID = new ArrayList<>();
            traineeID = con.retrieve(query, "accountID");
            
            for(String s:traineeID){
                System.out.println(s);
            }
            
        } catch (SQLException ex) {
            //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("REPORT CLASS: ERROR IN SETTRAINEEID()");
        }
    }
    
    public Course getCourse(){
        return course;
    }
    
    public Account getTrainer(){
        return trainer;
    }
    
    /**
     * Generates the report of the course.
     * A report is in .pdf format, has a cover page, and
     * at least one page showing list of enrolled trainees with their
     * latest assessment marks and dates of passes.
     */
    public void generateReport(){
        try {
            Document document = new Document();
            
            try {
                //Set the pdfWriter to output on the created document
                PdfWriter.getInstance(document, new FileOutputStream(fileName));
            } catch (DocumentException ex) {
                //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            document.open();
            createCoverPage(document);
            document.newPage();
            createContents(document);
            
            document.close();
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void createTitle(Document d){
        try {
            Font font = new Font(Font.FontFamily.TIMES_ROMAN,30,Font.BOLD);
            String title = course.getCourseID();
            title+=" Course Report";
            Paragraph p = new Paragraph(title,font);
            p.setAlignment(Element.ALIGN_CENTER);
            d.add(p);
        } catch (DocumentException ex) {
            //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Details of course written on cover page
     */
    private void createDetails(Document d){
        try {
            for(int i=0;i<29;i++){
                d.add(new Paragraph("\n"));
            }
            /*
            Required data:
            1. course name
            2. trainer name
            3. course start
            4. course end
            */
            Font font = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.NORMAL);
            
            String courseName,courseStart,courseEnd,query;
            
            query = "select * from course where courseID='"+course.getCourseID()+"';";
            try {
                courseName = con.retrieve(query, "courseName").get(0);
                courseStart = con.retrieve(query, "courseStart").get(0);
                courseEnd = con.retrieve(query, "courseEnd").get(0);


                Paragraph p = new Paragraph("Course Name\t: "+courseName,font);
                p.setAlignment(Element.ALIGN_LEFT);
                d.add(p);

                p = new Paragraph("Trainer ID\t\t: "+trainer.username,font);
                d.add(p);

                p = new Paragraph("Start Date\t: "+courseStart,font);
                d.add(p);

                p = new Paragraph("End Date\t: "+courseEnd,font);
                d.add(p);
            } catch (SQLException ex) {
                //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("REPORT CLASS: ERROR IN CREATEDETAILS()");
            }

        } catch (DocumentException ex) {
            //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Creates the cover page of this report.
     * A cover page would contain:
     * <ol>
     * <li> Report title </li>
     * <li> Course Name</li>
     * <li> Trainer's Name</li>
     * <li> Course Starting Date</li>
     * <li> Course End Date</li>
     * </ol>
     */
    private void createCoverPage(Document d){
        createTitle(d);
        createDetails(d);
    }
    
    /**
     * Creates the contents of the report.
     * A report would contain the list of enrolled trainees with their
     * latest assessment marks and dates of passes, if applicable. All
     * of this data is displayed in a table.
     * The structure of the 1st page of this section is:
     * <ol>
     * <li>Title</li>
     * <li>Table</li>
     * </ol>
     */
    private void createContents(Document d){
        try {
            /*
            Required Data:
            1. ArrayList of trainees IDs
            2. Arraylist of assessment attempt marks corresponding to (1)
            3. Arraylist of course passing dates (2[i]==5)
            */
            
            //Font for page title first
            Font font = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.UNDERLINE);
            Paragraph p = new Paragraph("List of Trainees and Dates of Passes (if Applicable)",font);
            p.setAlignment(Element.ALIGN_LEFT);
            d.add(p);
            d.add(new Paragraph("\n\n\n"));
            
            //creation of table with cells and headers
            PdfPTable table = new PdfPTable(4);
            
            //testing data
            //String[] traineeID = new String[]{"1181101286","1181101148","1181101272","1181101256"};
            ArrayList<String> marks, pass;
            String query;
            marks = new ArrayList<>();
            pass = new ArrayList<>();
            
            for(int i=0;i<traineeID.size();i++){
                String ID = traineeID.get(i);
                String assessmentID = "A"+course.getCourseID();
                System.out.printf("Checking if %s attempted %s\n",ID,assessmentID);
                
                query = "select * from attempt where accountID='"+ID+"' and assessmentID='"+assessmentID+"';";
                
                try {
                    if (con.retrieve(query,"accountID").isEmpty()){
                        marks.add("No attempts");
                        pass.add("-");
                    }
                    else{
                        String mark = con.retrieve(query,"attemptMarks").get(0);
                        marks.add(mark);
                        if (mark.equals("5")){
                            pass.add(con.retrieve(query,"attemptDate").get(0));
                        }
                        else{
                            pass.add("-");
                        }
                    }
                } catch (SQLException ex) {
                    //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            
            //Title of column header
            PdfPCell c1 = new PdfPCell(new Phrase("No."));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("ID"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Latest Assessment Marks"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Date of Pass"));
            table.addCell(c1);
            
            table.setHeaderRows(1);
            
            /*
            inserts cells into the table
            cells are added by rows
            since there are 3 columns created in this table,
            added cells will fill in each column of a row sequentially,
            before proceeding to the next row.
            */
            for(int i=0;i<traineeID.size();i++){
                table.addCell(Integer.toString(i+1));
                table.addCell(traineeID.get(i));
                table.addCell(marks.get(i));
                table.addCell(pass.get(i));
            }
            
            /*
            table.addCell("Added 1st");
            table.addCell("Added 2nd");
            table.addCell("Added 3rd");
            table.addCell("Added 4th");
            table.addCell("Added 5th");
            table.addCell("Added 6th");
            */
            
            d.add(table);
            
        } catch (DocumentException ex) {
            //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
}
