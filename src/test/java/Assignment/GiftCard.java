package Assignment;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GiftCard extends DWSBaseClass {
	@Parameters({"recipient","username","input"})
    @Test
public void gift(String recipient,String username,String input ) {
	driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')][1]")).click();
    driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
    driver.findElement(By.xpath("//input[@id='giftcard_1_RecipientName']")).sendKeys(recipient);
    driver.findElement(By.cssSelector("input[class='recipient-email']")).sendKeys(username);
    driver.findElement(By.cssSelector("input[class='sender-name']")).sendKeys(recipient);
    driver.findElement(By.cssSelector("input[class='sender-email']")).sendKeys(username);
    driver.findElement(By.cssSelector("input[class='qty-input']")).clear();
    driver.findElement(By.cssSelector("input[class='qty-input']")).sendKeys(input);
    driver.findElement(By.id("add-to-cart-button-1")).click();
   
}
}