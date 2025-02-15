package com.excel;

import java.io.FileOutputStream;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Test2 {

	public static void main(String[] args) throws Exception {

		System.out.println("whole program starts " + java.time.LocalDateTime.now());

		List<Employee> list = new LinkedList<>();
		for (int i = 0; i < 1000; i++) {
			list.add(new Employee("Name_"+i,"Email_"+i,"Mobile_"+i,"GstNumber_"+i,"Address_"+i,"BankAccoutn_"+i));
		}

		long a = System.nanoTime();

		try (
				// Workbook workbook = new XSSFWorkbook(); FileOutputStream fileout = new
				// FileOutputStream("Excel.xlsx")
				// Workbook workbook = new SXSSFWorkbook(); FileOutputStream fileout = new
				// FileOutputStream("Excel.xlsx")
				Workbook workbook = new XSSFWorkbook();
				FileOutputStream fileout = new FileOutputStream("D:\\Download\\test.xls");) {

			int rows = 100000;
			if (workbook instanceof HSSFWorkbook)
				rows = 100000;

			Object[][] data = new Object[rows][4];
			data[0] = new Object[] { "id", "Date", "name", "address" };
			for (int i = 1; i < rows; i++) {
				Employee emp = list.get(i);
				data[i] = new Object[] { emp.getAddress(), emp.getBankAccount(), emp.getName(), emp.getAddress() };
			}

			System.out.println("jfd");
			DataFormat dataFormat = workbook.createDataFormat();
			CellStyle dateStyle = workbook.createCellStyle();
			dateStyle.setDataFormat(dataFormat.getFormat("DDDD, MMMM, DD, YYYY"));
			CellStyle numberStyle = workbook.createCellStyle();
			numberStyle.setDataFormat(dataFormat.getFormat("#,##0.00 \" Coins\""));

			Sheet sheet = workbook.createSheet();

			sheet.setColumnWidth(0, 12 * 256);
			sheet.setColumnWidth(1, 35 * 256);
			sheet.setColumnWidth(2, 17 * 256);
			sheet.setColumnWidth(3, 10 * 256);

			
			 for (int r = 0; r < data.length; r++) {
				    Row row = sheet.createRow(r);
				    for (int c = 0; c < data[0].length; c++) {
				     Cell cell = row.createCell(c);
				     if (r == 0) cell.setCellValue((String)data[r][c]);
				     if (r > 0 && c == 0) {
				      cell.setCellValue((Integer)data[r][c]);
				     } else if (r > 0 && c == 1) {
				      cell.setCellValue((GregorianCalendar)data[r][c]);
				      cell.setCellStyle(dateStyle);
				     } else if (r > 0 && c == 2) {
				    	 cell.setCellValue((String)data[r][c]);
				     } else if (r > 0 && c == 3) {
				    	 cell.setCellValue((String)data[r][c]);
				     }
				    }
				    System.out.println("row : " + r);
				   }

			System.out.println("write starts " + java.time.LocalDateTime.now());
			workbook.write(fileout);
			System.out.println("write ends " + java.time.LocalDateTime.now());

			if (workbook instanceof SXSSFWorkbook)
				((SXSSFWorkbook) workbook).dispose();
		}
		long b = System.nanoTime();
		System.out.println(b-a);
		System.out.println("whole program ends " + java.time.LocalDateTime.now());

	}
}