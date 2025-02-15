package com.test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.excel.Employee;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;


public class IN_PDF_1000000 {

	public static void main(String[] args) throws IOException {
		List<Employee> list = new LinkedList<>();
		long a = System.nanoTime();
		System.out.println("start");
		for (int i = 0; i < 1000; i++) {
			list.add(new Employee("Name_"+i,"Email_"+i,"Mobile_"+i,"GstNumber_"+i,"Address_"+i,"BankAccoutn_"+i));
		}
		generatePDF(list);
		long b = System.nanoTime();
	
		System.out.println("time : " + (b - a));
	}

	private static void generatePDF(List<Employee> list) throws IOException {
	
		PdfWriter writer = new PdfWriter("D:\\Download\\test.pdf");
		PdfDocument pdf = new PdfDocument(writer);
		Document doc = new Document(pdf);
		
		float[] pointColumnWidths1 = new float[] { 100, 100, 150, 400 };
		Table table1 = new Table(pointColumnWidths1);
		table1.setTextAlignment(TextAlignment.CENTER);
		table1.setMarginTop(5);

		PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
		
		Cell cell = new Cell();
		cell.add(new Paragraph().add(new Text("Id").setFont(bold).setFontSize(10.5F)))
				.setBackgroundColor(Color.DARK_GRAY, 0.5F);
		table1.addCell(cell);

		cell = new Cell();
		cell.add(new Paragraph().add(new Text("Name").setFont(bold).setFontSize(10.5F)))
				.setBackgroundColor(Color.DARK_GRAY, 0.5F);
		table1.addCell(cell);

		cell = new Cell();
		cell.add(new Paragraph().add(new Text("Address").setFont(bold).setFontSize(10.5F)))
				.setBackgroundColor(Color.DARK_GRAY, 0.5F);
		table1.addCell(cell);
		
		cell = new Cell();
		cell.add(new Paragraph().add(new Text("Date").setFont(bold).setFontSize(10.5F)))
				.setBackgroundColor(Color.DARK_GRAY, 0.5F);
		table1.addCell(cell);
		
		
		for (int i=0; i<list.size();i++ ) {

			Employee orderItem = list.get(i);
			
			cell = new Cell();
			cell.add(new Paragraph().add(new Text("" + orderItem.getEmail()).setFontSize(10)));
			table1.addCell(cell);	
			
			cell = new Cell();
			cell.add(new Paragraph().add(new Text("" + orderItem.getName()).setFontSize(10)));
			table1.addCell(cell);
			
			cell = new Cell();
			cell.add(new Paragraph().add(new Text("" + orderItem.getAddress()).setFontSize(10)));
			table1.addCell(cell);

			cell = new Cell();
			cell.add(new Paragraph().add(new Text("" + orderItem.getAddress
						()).setFontSize(10)));
			table1.addCell(cell);
			System.out.println(i++);

		
	}
		doc.add(table1);
		doc.close();
		
		
	}
	
	
}
