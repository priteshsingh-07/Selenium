package DatadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShopperStack {
	@Test
	public void login() throws InterruptedException, IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./ConfigFile\\Shopperstack.Properties");
		prop.load(fis);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get(url);
		Thread.sleep(2000);
		
		driver.findElement(By.className("loginBtn")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("Email")).sendKeys(username);	
		Thread.sleep(2000);
		
		driver.findElement(By.id("Password")).sendKeys(password);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Login']")).click();
	}
}
