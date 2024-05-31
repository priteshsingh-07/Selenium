package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class DWSBaseClass  {
	

	WebDriver driver;//globalization
		@BeforeSuite
		public void beforeSuit() 
		{
			System.out.println("Connecting to the DataBase");
		}
		
		@BeforeTest
		public void beforetTest() 
		{
			System.out.println("Pre-condition for test runner");
		}
		
		@Parameters({"url","username","password"})
		@BeforeClass
		public void beforeClass(String url,String username,String password) 
		{
			//launch the browser
		    driver = new ChromeDriver();
			//maximize window
			driver.manage().window().maximize();
			//implicitly wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.navigate().to(url);
		}
		
		@Parameters({"url","username","password"})
		@BeforeMethod
		public void beforeMethod(String url,String username,String password) 
		{
			//Login user
			driver.findElement(By.className("ico-login")).click();
			driver.findElement(By.id("Email")).sendKeys(username);
			driver.findElement(By.id("Password")).sendKeys(password);
			driver.findElement(By.cssSelector("input[value='Log in']")).click();
		}
		
		@AfterMethod
		public void afterMethod() 
		{	
			driver.findElement(By.className("ico-logout")).click();
		}
		
		@AfterClass
		public void afterClass()
		{			
			driver.close();
		}
		
		@AfterTest
		public void afterTest() 
		{
			System.out.println("Post Conditions for test runner");
		}
		
		@AfterSuite
		public void afterSuit() 
		{
			System.out.println("Disconnect for database");
		}		
}