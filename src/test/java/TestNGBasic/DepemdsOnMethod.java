package TestNGBasic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DepemdsOnMethod {
	
	@Test(priority = 3)
	public void createAccount() 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.chennaisuperkings.com/");
		System.out.println("Account has been Created");	
	}
	
	@Test(priority = 0,dependsOnMethods = "createAccount")
	public void modifiedAccount() 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.royalchallengers.com/");
		System.out.println("Account has been  Modified");	
	}
	
	@Test(priority = 2)
	public void deleteAccount() 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		System.out.println("Account has been Deleted");	
	}
}
