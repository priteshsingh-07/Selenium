package DatadrivenTesting;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	@Test
	
	public void readData() throws EncryptedDocumentException, IOException {
		
		File path = new File("E:\\Selenium\\Framework\\Logincredential1.xlsx");
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		
		String gmail1 = sheet.getRow(0).getCell(0).toString();
		String pass = sheet.getRow(1).getCell(0).toString();
		String gmail2 = sheet.getRow(2).getCell(0).toString();
		String pass2 = sheet.getRow(3).getCell(0).toString();
		
		System.out.println("gmail:"+gmail1);
		System.out.println("pass:"+pass);
		System.out.println("gmail2:"+gmail2);
		System.out.println("pass:"+pass);
	}
}

