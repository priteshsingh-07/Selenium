package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver =  new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.name("username")).sendKeys("Admin");
    	driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		
		
    //  Step1 : create object of FileInputStream Constructor pass the path of properties
		FileInputStream fis = new FileInputStream ("src\\test\\resources\\Data.properties");
		
   //   Step2 : create object of Properties class
		Properties p = new Properties();
		
   //   Step3 : Load(InputStream)
		p.load(fis); 

	// step4 :  call getProperty(String key)
		String USERNAME = p.getProperty("Username");
		String PASSWORD = p.getProperty("Password");
		
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
	}
}