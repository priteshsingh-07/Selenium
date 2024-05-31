package Listeners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class networkfailure {
    @Test(retryAnalyzer = com.crm.listnersCode.networkretry.class)
	public void main() {
		WebDriver driver = new ChromeDriver();
		assertEquals("Hii", "bye"); // executes 4 times 
	//	assertEquals("Hii", "Hii"); executes one times
	}
}
