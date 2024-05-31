package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertEqual extends Baseclass{
	
	@Test
	public void HardAssert() {
		String expected_result = "https://demowebshop.tricentis.com/";
		String a = "vaishya";
		String b = null ;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		SoftAssert ass = new SoftAssert();
		String actual_result = driver.getCurrentUrl();
	//	assertEquals(expected_result,actual_result);
		boolean result = expected_result.equals(actual_result);
		ass.assertAll();
		driver.findElement(By.id("small-searchterms")).sendKeys("vaishya");
		ass.assertNull(a);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		ass.assertAll();
	}
}
