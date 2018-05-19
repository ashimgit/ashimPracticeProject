package itext.prac1;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class ItextPrac1Main {
	public static void main(String[] args) {
		Document doc = new Document();
		try {
			PdfWriter writer=PdfWriter.getInstance(doc, new FileOutputStream("D:\\STUDY\\myPdf.pdf"));
			doc.open();
			doc.add(new Paragraph("This is my new PDF Learning using ITEXT"));
			doc.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
