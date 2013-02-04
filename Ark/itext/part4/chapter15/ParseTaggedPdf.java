/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package part4.chapter15;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.TaggedPdfReaderTool;

public class ParseTaggedPdf {

	public static final String RESULT = "17-30.pdf";
	public static final String RESOURCE = "17-30.xml";
    /**
     * Creates a PDF file using a previous example,
     * then parses the document.
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
        throws IOException, DocumentException, SAXException, ParserConfigurationException {
        //StructuredContent.main(args);
    	TaggedPdfReaderTool reader = new TaggedPdfReaderTool();
    	reader.convertToXml(new PdfReader(RESULT), new FileOutputStream(RESOURCE));
    }
}
