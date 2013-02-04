/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package part2.chapter08;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import bru.LocationTextExtractionStrategyEx;
import bru.LocationTextExtractionStrategyEx.TextChunk;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;

import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTextArray;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PushbuttonField;

import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.TextMarginFinder;



import part2.chapter07.Advertisement;

public class ReplaceIcon {
    public static final String RESOURCE = "resources/img/iia2.jpg";
    public static final String RESULT_OLD = "results/part2/chapter08/advertisement2.pdf";
    public static final String RESULT = "resources/img/testPdf.pdf";
    public static final String RESULT1 = "resources/img/testPdf1.pdf";
    public static void main(String[] args) throws SQLException, DocumentException, IOException {
        //Advertisement.main(args);
        new ReplaceIcon().manipulatePdf(RESULT, RESULT1);
    }
    
   
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(src);
        
        
       
       PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        
        LocationTextExtractionStrategyEx finder = parser.processContent(1, new LocationTextExtractionStrategyEx());
        
        //System.out.println(finder.getResultantText());
        
        List<TextChunk> textChunks = finder.getLocationalResult(); 
       
        
        
        
        Document document = new Document();
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(dest));
		document.open();
		PdfContentByte canvas = writer.getDirectContent();
		
		for (TextChunk textChunk : textChunks){
		
		BaseFont bf = BaseFont.createFont();
		canvas.beginText();
		// line 1
		canvas.setFontAndSize(bf, 8);
		canvas.moveText(textChunk.getStartLocation().get(0), textChunk.getStartLocation().get(1));
		canvas.moveTextWithLeading(0, -24);
		canvas.setCharacterSpacing(textChunk.getCharSpaceWidth());
		
		canvas.showText(textChunk.getText());
		 System.out.println(textChunk.getText() + " ( "+textChunk.getStartLocation().get(0)+","+textChunk.getStartLocation().get(1)+" )");
		canvas.endText();
        }
		document.close();
    }
}
