package com.crm.listnersCode;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.ReadDataFromExternal.ReadFileUtility;


public class BaseClass 
	{

	public WebDriver driver;//to make it global
	
	@BeforeSuite
	public void beforeSuit()
	{
		System.out.println("connecting the database");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Precondition for test runner");
	}

	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException
	{
		String url= ReadFileUtility.RU("url");
		
	 //	Properties prop=new Properties();
	//	FileInputStream fis=new FileInputStream("src/test/resources/DWS.properties");
	//	prop.load(fis);
		
	    //launch the browser
		driver=new ChromeDriver();
		
	    //maximize the window
		driver.manage().window().maximize();
		
		//implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().to(url);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		
		String username = ReadFileUtility.RU("username");
		String password = ReadFileUtility.RU("password");
		
	//	Properties prop=new Properties();
	//	FileInputStream fis=new FileInputStream("E:\\Selenium\\dwsLog2.xlsx");
	//	prop.load(fis);
	//	String username= prop.getProperty("username");
	//	String password= prop.getProperty("password");
		
		driver.findElement(By.className("ico-login")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.findElement(By.className("ico-logout")).click();	
	}
	
	@AfterClass
	public void afterClass() 
	{
		driver.close();
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Post condition for test runner");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("Disconnect database");
	}
}