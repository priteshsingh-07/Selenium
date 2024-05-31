package TestNGFashion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AjioShop {
	@Parameters({"url"})
	@Test(groups = "SmokeTesting")

public void Demowebshop(String url) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ajio.com");
		Thread.sleep(2000);
		driver.close();	
}
}
