package Vtigercrm;


import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;
@Listeners(ListenerImplementation.class)
public class OrganizationsTest extends BaseClass {

	//PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	
	@Test
	public void CreateOrganizationTest() throws IOException, EncryptedDocumentException{
		
	//To read data from Excel File
	String ORGNAME = eutil.getDataFromExcelFile("Organizations", 1, 1);
	String GROUP = eutil.getDataFromExcelFile("Organizations", 2, 1);
	
	//Click on Organization
	driver.findElement(By.linkText("Organizations")).click();
	
	//Click on Create Organization..(+)
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	
	//Enter Organization Name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	
	//In AssignedTo Click on Group
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the dropdown select Support group
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	wutil.handledropdown(dropdown, GROUP);
	
	//Click on Save Button
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	
	
	
}
}