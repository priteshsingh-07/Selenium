package Vtigercrm;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.ListenerImplementation;
import commonUtils.WebDriverUtil;
@Listeners(ListenerImplementation.class)
public class ContactTest extends BaseClass {
	
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	
	@Test
	public void CreateContactTest() throws EncryptedDocumentException, IOException {
		
		//To read data from Excel File
String FIRSTNAME = eutil.getDataFromExcelFile("Contacts", 1, 1);
String LASTNAME = eutil.getDataFromExcelFile("Contacts", 2, 1);
String GROUP = eutil.getDataFromExcelFile("Contacts", 3, 1);

		
		//Click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

		//Click on Create Contact..(+)
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//Enter Firstname
		driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);

		//Enter Lastname
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//Click on Group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//Select team selling in the drop down
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		wutil.handledropdown(dropdown, GROUP);

		//Click on + in Organization name
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//To transfer the control from Parent window to child window
		wutil.switchTowindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		//Enter Organization name in search tf
		driver.findElement(By.id("search_txt")).sendKeys("Org5");
		
		//Click on Search now button
		driver.findElement(By.name("search")).click();
		
		//Click on Organization name
		driver.findElement(By.id("1")).click();
		
		//To transfer the control from child window to Parent window
		wutil.switchTowindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
	//Click on Save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
	}
	}