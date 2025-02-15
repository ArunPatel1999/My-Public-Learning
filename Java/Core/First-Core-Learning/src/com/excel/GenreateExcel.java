package com.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GenreateExcel {

	static void generateExcel(List<Employee> orders) throws IOException {

		Workbook workbook = new XSSFWorkbook();
		FileOutputStream fileout = new FileOutputStream("D:\\Download\\Excel.xls");

		int rows = orders.size();

		DataFormat dataFormat = workbook.createDataFormat();
		CellStyle dateStyle = workbook.createCellStyle();
		dateStyle.setDataFormat(dataFormat.getFormat("DDDD, MMMM, DD, YYYY"));
	
		Sheet sheet = workbook.createSheet();

		sheet.setColumnWidth(0, 12 * 256);
		sheet.setColumnWidth(1, 10 * 256);
		sheet.setColumnWidth(2, 17 * 256);
		sheet.setColumnWidth(3, 35 * 256);

		List<String> header = new LinkedList<>();
		header.add("Name");
		header.add("Email");
		header.add("Mobile");
		header.add("Gst Number");
		header.add("Address");
		header.add("Bank Account");

		int cloums = header.size();
		Row row = sheet.createRow(0);
		Cell cell;
		for (int i = 0; i < cloums; i++) {
			cell = row.createCell(i);
			cell.setCellValue(header.get(i));
		}

		int i=1;
		for (int r = 0; r < rows; r++) {
			Employee emp = orders.get(r);
			row = sheet.createRow(i++);
			for (int c = 0; c < cloums; c++) {
				cell = row.createCell(c);
				if (c == 0) {
					cell.setCellValue((String) emp.getName());
				} else if (c == 1) {
					cell.setCellValue((String) emp.getEmail());
				} else if (c == 2) {
					cell.setCellValue((String) emp.getMobile());
				} else if (c == 3) {
					cell.setCellValue((String) emp.getGstNumber());
			   }  else if (c == 4) {
					cell.setCellValue((String) emp.getAddress());
			   } else if (c == 5) {
					cell.setCellValue((String) emp.getBankAccount());
			   }
			}	
		}

		workbook.write(fileout);
		workbook.close();

	}

	public static void main(String[] args) throws IOException {
		List<Employee> list = new LinkedList<>();
		long a = System.nanoTime();
		System.out.println("start");
		
		for (int i = 0; i < 1000; i++) {
			list.add(new Employee("Name_"+i,"Email_"+i,"Mobile_"+i,"GstNumber_"+i,"Address_"+i,"BankAccoutn_"+i));
		}
		generateExcel(list);
		long b = System.nanoTime();
		System.out.println("time : " + (b - a));
	}

}
