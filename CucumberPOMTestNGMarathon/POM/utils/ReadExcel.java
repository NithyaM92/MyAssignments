package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static String[][] readExcel(String fileName) throws IOException {
		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+fileName+".xlsx");
		XSSFSheet wSheet = wBook.getSheetAt(0); 
		int rowCount = wSheet.getLastRowNum();
		System.out.println(rowCount);
		int columnCount = wSheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);
		String data[][] = new String[rowCount][columnCount];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = wSheet.getRow(i);
			for (int j = 0; j < columnCount; j++) {
			    String stringCellValue = row.getCell(j).getStringCellValue();
			    System.out.println(stringCellValue);
			    data[i-1][j] = stringCellValue;
				
			}
			
		}
		wBook.close();
		return data;
		

	}



}
