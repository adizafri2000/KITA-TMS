
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
    private Trainer trainer;
    private ArrayList<Trainee> traineeList;
    private ArrayList<String> traineeID;
    private DBConnection con;
    private String fileName;
    
    public Report(){}
    
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
            /*
            Required data:
            1. course name
            2. trainer name
            3. course start
            4. course end
            */
            Font font = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.NORMAL);
            
            Paragraph p = new Paragraph("Course Name\t: "+course.getCourseName(),font);
            p.setAlignment(Element.ALIGN_LEFT);
            d.add(p);
            
            p = new Paragraph("Trainer\t\t: "+course.getTrainer().getTrainerName(),font);
            d.add(p);
            
            p = new Paragraph("Start Date\t: "+course.getCourseName(),font);
            d.add(p);
            
            p = new Paragraph("End Date\t: "+course.getCourseName(),font);
            d.add(p);
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
        
       
    }
    
    
    
    public static void main(String[] args){
        try {
            String courseID = "TSN2201";
            String courseName = "Computer Networks";
            String trainerName = "Dr Kannan Ramakrishnan";
            Calendar startDate = new GregorianCalendar(2020,6,6);
            Calendar endDate = new GregorianCalendar(2020,9,9);
            
            String fileName = "reportsample.pdf";
            Document document = new Document();
            
            //Set the pdfWriter to output on the created document
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            
            document.open();
            
            //------------------------------------FIRST PAGE STARTS HERE-------------------------------------------------------------
            
            //Set the font
            Font font = new Font(Font.FontFamily.TIMES_ROMAN,30,Font.BOLD);
            
            //The font is passed as an argument so the text is written in specified font
            Paragraph paragraph = new Paragraph(courseID+" Course Report",font);
            
            //sets the alignment of the paragraph
            paragraph.setAlignment(Element.ALIGN_CENTER);
            
            document.add(paragraph);
            
            for(int i=0;i<29;i++){
                document.add(new Paragraph("\n"));
            }
            
            
            
            font = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.NORMAL);
            paragraph = new Paragraph("Course Name : "+courseName,font);
            paragraph.setAlignment(Element.ALIGN_JUSTIFIED);
            document.add(paragraph);
            
            
            paragraph = new Paragraph("Trainer     : "+trainerName,font);
            document.add(paragraph);
            
            SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            fmt.setCalendar(startDate);
            String dateFormatted = fmt.format(startDate.getTime());
            
            paragraph = new Paragraph("Start Date  : "+dateFormatted,font);
            document.add(paragraph);
            
            fmt.setCalendar(endDate);
            dateFormatted = fmt.format(endDate.getTime());
            
            paragraph = new Paragraph("End Date    : "+dateFormatted,font);
            document.add(paragraph);
            
            //------------------------------------FIRST PAGE ENDS HERE-------------------------------------------------------------
            document.newPage();
            
            //++++++++++++++++++++++++++++++++++++SECOND PAGE STARTS HERE+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            
            
            font = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.UNDERLINE);
            paragraph = new Paragraph("List of Trainees and Dates of Passes (if Applicable)",font);
            document.add(paragraph);
            document.add(new Paragraph("\n\n"));
            
            font = new Font(Font.FontFamily.TIMES_ROMAN,18,Font.NORMAL);
            
            
            //creation of table with cells and headers
            PdfPTable table = new PdfPTable(4);
            
            //testing data
            String[] traineeID = new String[]{"1181101286","1181101148","1181101272","1181101256"};
            String[] marks = new String[]{"5","5","3","-"};
            String[] pass = new String[]{"2020-08-21","2020-10-01","-","-"};
            
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
            for(int i=0;i<traineeID.length;i++){
                table.addCell(Integer.toString(i+1));
                table.addCell(traineeID[i]);
                table.addCell(marks[i]);
                table.addCell(pass[i]);
            }
            
            /*
            table.addCell("Added 1st");
            table.addCell("Added 2nd");
            table.addCell("Added 3rd");
            table.addCell("Added 4th");
            table.addCell("Added 5th");
            table.addCell("Added 6th");
            */
            
            document.add(table);
            
            
            //++++++++++++++++++++++++++++++++++++SECOND PAGE STARTS HERE+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            document.close();
            
            File file = new File(fileName);
            
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (IOException ex) {
                //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error");
            }
            
            System.out.println("Finished.");
        } catch (FileNotFoundException | DocumentException ex) {
            //Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }
    }
    
    
}
