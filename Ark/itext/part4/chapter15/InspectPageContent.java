/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package part4.chapter15;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import part1.chapter03.MovieTemplates;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.parser.PdfContentReaderTool;

public class InspectPageContent {

	public static final String RESULT = "results/part4/chapter15/calendar_info.txt";
	
	public void inspectPdf(String pdf, String txt) throws IOException {
		PrintWriter out = new PrintWriter(new FileOutputStream(txt));
		PdfContentReaderTool.listContentStream(new File(pdf), out);
		out.flush();
		out.close();
	}
	public static void main(String[] args) throws IOException, DocumentException {
		new MovieTemplates().createPdf(MovieTemplates.RESULT);
		new InspectPageContent().inspectPdf(MovieTemplates.RESULT, RESULT);
	}
}
