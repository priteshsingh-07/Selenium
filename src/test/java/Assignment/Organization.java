package Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import commonUtils.PropertyFileUtil;

public class Organization {
	
	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		PropertyFileUtil putil = new PropertyFileUtil();
		
		//TO read data from property file
		String browser=putil.getDataFromPropertyFile("Browser");
		String url=putil.getDataFromPropertyFile("Url");
		String username=putil.getDataFromPropertyFile("Username");
		String password=putil.getDataFromPropertyFile("Password");
		
		//TO LAUNCH THE BROWSER
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		//To apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//To launch application
		driver.get(url);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		//TO click on organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("org5");
		driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
		driver.findElement(By.name("assigned_group_id")).click();
		driver.findElement(By.xpath("//option[text()='Support Group']")).click();
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(2000);
		WebElement account = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver); 
		a.moveToElement(account);
		a.perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}