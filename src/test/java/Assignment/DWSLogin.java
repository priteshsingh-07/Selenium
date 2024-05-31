package Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DWSLogin extends DWSBaseClass{
	
	@Test
	public void main() throws InterruptedException {
		
		List<WebElement> follow = driver.findElements(By.xpath("//div[@class='column follow-us']//h3//..//ul//li"));
		for(WebElement add: follow)
		{
			add.click();
			Thread.sleep(2000);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//click on digital download
//		driver.findElement(By.xpath("//a[contains(text(),'Digital downloads')]")).click();
//		//add product
//		List<WebElement> addtocart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
//		for (WebElement add : addtocart) 
//		{
//			add.click();
//			Thread.sleep(1000);
//		}
//		
	}
}