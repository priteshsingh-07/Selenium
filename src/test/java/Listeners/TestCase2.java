package Listeners;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ReadDataFromExternal.ReadFileUtility;
import com.crm.listnersCode.BaseClass;
@Listeners(com.crm.listnersCode.DWSListeners.class)

public class TestCase2 extends BaseClass
	{
	@Test
	public void giftcard() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
	    driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
	//	File path=new File("E:\\Selenium\\dwsLog2.xlsx");
	//	FileInputStream fis=new FileInputStream(path);
	//	Workbook wb=WorkbookFactory.create(fis);
	//	Sheet sheet=wb.getSheet("Sheet1");
	    
	//	String data=sheet.getRow(row).getCell(cell).toString();
    //	String rname=sheet.getRow(0).getCell(0).toString();
    //	String remail=sheet.getRow(1).getCell(0).toString();
    //	String sname=sheet.getRow(2).getCell(0).toString();
    //	String smail=sheet.getRow(3).getCell(0).toString();
    //	String input=sheet.getRow(4).getCell(0).toString();
		
		String rname = ReadFileUtility.fileRead("Sheet1", 0, 0);
		String remail = ReadFileUtility.fileRead("Sheet1", 1, 0);
		String sname = ReadFileUtility.fileRead("Sheet1", 2, 0);
		String smail = ReadFileUtility.fileRead("Sheet1", 3, 0);
		String input = ReadFileUtility.fileRead("Sheet1", 4, 0);
		
	    driver.findElement(By.xpath("//input[@id='giftcard_1_RecipientName']")).sendKeys(rname);
	    Thread.sleep(1000);
	    driver.findElement(By.cssSelector("input[class='recipient-email']")).sendKeys(remail);
	    driver.findElement(By.cssSelector("input[class='sender-name']")).sendKeys(sname);
	    driver.findElement(By.cssSelector("input[class='sender-email']")).sendKeys(smail);
	    driver.findElement(By.cssSelector("input[class='qty-input']")).clear();
	    driver.findElement(By.cssSelector("input[class='qty-input']")).sendKeys(input);
	    driver.findElement(By.id("add-to-cart-button-1")).click();	
	}
}