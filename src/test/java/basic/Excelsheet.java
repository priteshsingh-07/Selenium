package basic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import commonUtils.ExcelUtil;

public class Excelsheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		// To read data from Excel File
		
		
		// Step 1 : crete object of FileInputStream class
		/*FileInputStream fis = new FileInputStream("src\\test\\resources\\data1.xlsx");
		
		// Step 2 : Call create (Inputstream)
		Workbook wb = WorkbookFactory.create(fis);
		
		// step 3 : Call getSheet(String name)
		Sheet sh =  wb.getSheet("Organization");
		
		// step 4 : Call getRow(int rownm)
		Row rw = sh.getRow(2);
		
		// Step 5 : getCell (int cellnum)
		Cell c1 = rw.getCell(1);
		
		// step 6 : Call getStringCellvalue()
		String data = c1.getStringCellValue();
		
		System.out.println(data);*/
		
		ExcelUtil eutil = new ExcelUtil();
		String s = eutil.getDataFromExcelFile("Organization",1,1);
		System.out.println(s);
		
		
		
		
		
		

	}

}
