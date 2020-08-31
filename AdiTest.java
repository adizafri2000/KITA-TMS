import com.itextpdf.text.Document;

public class AdiTest {
    public static void main(String[] args) {
        // creation of the document with a certain size and certain margins
    Document document = new Document(PageSize.A4, 50, 50, 50, 50);
    try {
    // creation of the different writers
    HtmlWriter.getInstance(document , System.out);
    PdfWriter.getInstance(document , new FileOutputStream("text.pdf"));
    // we add some meta information to the document
    document.addAuthor("Bruno Lowagie"); 
    document.addSubject("This is the result of a Test."); 
    // we open the document for writing
    document.open(); 
    document.add(new Paragraph("Hello world"));
    } catch(DocumentException de) {
    System.err.println(de.getMessage());
    }
    document.close();
    }
}