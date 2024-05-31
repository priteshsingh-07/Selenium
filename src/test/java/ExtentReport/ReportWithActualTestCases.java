package ExtentReport;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.BaseClass.BaseClassDWS;

import POM.DwsLoginPage;
@Listeners(com.crm.listnersCode.GenerateExtentReport.class)
public class ReportWithActualTestCases extends BaseClassDWS {
	@Test
public void dwsLoginCorrect() {
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		DwsLoginPage dws = new DwsLoginPage(driver);
		dws.username("admin01@gmail.com");
		dws.password("admin01");
		dws.login();
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	@Test
	public void dwsLoginwrong() {
		
		driver.get("https://demowebshop.tricentis.com/login");
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		DwsLoginPage dws = new DwsLoginPage(driver);
		dws.username("admin01@gmail.com");
		dws.password("admin02");
		dws.login();
		driver.findElement(By.xpath("//a[text()='Log out']")).click();
		
	}
	
	@Test(dependsOnMethods = "dwsLoginwrong")
	public void redbus()
	{	
		driver.get("https://www.redbus.in/");
		assertEquals("Hii", "bye");
	}

}
