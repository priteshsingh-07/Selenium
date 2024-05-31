package Assignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShopperStack2  extends ShopperStack{
	
	@Test
	public void Shop() throws InterruptedException 
	{
		driver.findElement(By.xpath("//a[text()='Men']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li[text()='T-shirts']"));	
	}
}
