package com.crm.ReadDataFromExternal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.listnersCode.BaseClass;

public class ReadFileUtility extends BaseClass {
	
	
	public static String RU(String key) throws  IOException  {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./ConfigFile/DWS.properties");
		prop.load(fis);
		String data = prop.getProperty(key);
		return data ;		
	}
	
	public static  String  fileRead(String s,int row,int cell) throws EncryptedDocumentException, IOException {
		
		File path = new File("E:\\Selenium\\dwsLog2.xlsx");
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet("Sheet1");
		String data = sheet.getRow(row).getCell(cell).toString();
		return data;
	}
}
