package Listeners;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.listnersCode.BaseClass;
@Listeners(com.crm.listnersCode.DWSListeners.class)

public class TestCase1 extends BaseClass

{
	@Test
	public void addtocart() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
		List<WebElement> add=driver.findElements(By.xpath("//input[@value='Add to cart']"));
		for(WebElement add1:add)
		{
			add1.click();
		}
		Thread.sleep(2000);
	}
	
			

}