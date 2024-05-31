package DatadrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderBasic {
	@Test(dataProvider = "login")
	public void receiver(String username , String password) throws InterruptedException
	{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://demowebshop.tricentis.com/");
	driver.findElement(By.className("ico-login")).click();
	driver.findElement(By.id("Email")).sendKeys(username);	
	driver.findElement(By.id("Password")).sendKeys(password);
	driver.findElement(By.id("RememberMe")).click();
	driver.findElement(By.cssSelector("input[value='Log in']")).click();
	Thread.sleep(2000);
	driver.close();
}
    @DataProvider(name="login")
    public Object [][] sender() throws EncryptedDocumentException, IOException
    {
 
    	return DataProviderutility.dwsLogin();   
    }
}