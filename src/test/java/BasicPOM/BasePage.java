package BasicPOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import commonUtils.JavaUtil;
import pom.HomePage;
import pom.LoginPage;
import pom.OrganizationInformationPage;
import pom.OrganizationsPage;

public class BasePage{
	
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		JavaUtil jutil = new JavaUtil();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/");
		
		LoginPage lp = new LoginPage(driver);
		lp.Login("admin", "admin");
		
		HomePage hp = new HomePage(driver);
		hp.Home();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.Organizations();
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		oip.OrganixationInformation("Wipro"+jutil.getRandomNumber(),"Support Group");
		
		Thread.sleep(2000);
		hp.Home(driver);
		
	}
}