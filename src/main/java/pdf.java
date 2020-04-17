import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class pdf {

    public static boolean verifyPDFContent(String reqTextInPDF) throws IOException{

        PDDocument doc = PDDocument.load(new File("test.pdf"));
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(doc);
        doc.close();
        System.out.println(text);
        foo(text, reqTextInPDF);
        return text.contains(reqTextInPDF);

    }

    public static void foo(String text2, String reqTextInPDF2){

        int numNeedles = 0;

        int pos = text2.indexOf(reqTextInPDF2);

        while(pos >= 0 ){

            pos = pos + 1;
            numNeedles = numNeedles + 1;
            pos = text2.indexOf(reqTextInPDF2,pos);

        }

        System.out.println("the num of " +reqTextInPDF2+ " = " +numNeedles);
    }


    public static void main( String [] args) throws IOException{
        System.out.println(verifyPDFContent("Display image size options"));
    }
}