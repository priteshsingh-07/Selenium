package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ShopperStack {

	WebDriver driver;
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("Connecting to the DataBase");
	}
	@BeforeTest
	public void beforetTest() {
		System.out.println("Pre-condition for test runner");
	}
	@BeforeClass
	public void beforeClass() {
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to("https://www.shoppersstack.com/");
	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		//Login user
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginBtn")));
		driver.findElement(By.id("loginBtn")).click();
		driver.findElement(By.id("Email")).sendKeys("priteshbayas8099@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("Pritesh@8099");
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}
	@AfterMethod
	public void afterMethod() {
		
		driver.findElement(By.className("ico-logout"));
	}
	
	@AfterClass
	public void afterClass() {
		
		driver.close();
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Post Conditions for test runner");
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("Disconnect for database");
	}
	
}