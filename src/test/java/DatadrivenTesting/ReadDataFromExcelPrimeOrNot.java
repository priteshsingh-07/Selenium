package DatadrivenTesting;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcelPrimeOrNot {
	@Test
	public void PrimeNo() throws EncryptedDocumentException, IOException {
		    //path of the file
			File path=new File("E:\\Selenium\\Framework\\Logincredential1.xlsx");
			FileInputStream fis=new FileInputStream(path);
			
			//trasfer the control to workbook
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet=wb.getSheet("Sheet3");
			
			int row=sheet.getPhysicalNumberOfRows();
			int column=sheet.getRow(0).getPhysicalNumberOfCells();
			
			
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<column;j++)
				{
					String s1=sheet.getRow(i).getCell(j).toString();
					double valD = Double.parseDouble(s1);
					int val = (int)valD;
					if(isPrime(val)) 
					{
						System.out.println(val+" is prime");
					}
					else 
					{
						System.out.println(val+" is not prime");
					}
				}
			}
}
	 static boolean isPrime(int n) 
	 {
		 if(n<=1) {
		 return false;
	 }
	   for(int i=2;i<n;i++) 
		{
		   if(n%i==0) 
		 {
			return false;
		 }
		}
		 return true;
}
}
