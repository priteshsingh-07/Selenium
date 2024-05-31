package TestNGTravel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AbhiAbhi {
	@Parameters({"url"})
	@Test(groups = "RegressionTesting")
	public void AbhiBus(String url) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.abhibus.com");
		Thread.sleep(2000);
		driver.close();
	}
}
