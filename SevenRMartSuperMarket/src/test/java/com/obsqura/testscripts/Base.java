package com.obsqura.testscripts;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.WaitUtility;
import constants.Constants;

public class Base {
	public WebDriver driver;
	public Properties prop,prop1; 
	FileInputStream fs,fs1;
	@BeforeMethod(alwaysRun = true)
	public void initialiseBrowser() 
	{
		prop=new Properties();
		try 
		{
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.CONFIGfILE);
        } 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		try 
		{
			prop.load(fs);
		} catch (Exception e) 
		{
			// TODO: handle exception
		}
		prop1=new Properties();

		try
		{
			fs = new FileInputStream(System.getProperty("user.dir") +constants.Constants.TESTDATAFILE);
        } 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		try 
		{
             prop1.load(fs);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
		}
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + Constants.CHROMEDRIVERFILE);
			ChromeOptions options = new ChromeOptions();  options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("url"));
			WaitUtility.implicitWait(driver);
			WaitUtility.pageLoadWait(driver);
	}
	@Test
	public void testdemo() {		
	}
	@AfterMethod(alwaysRun = true)
	public void afterTest() 
	{
		driver.quit();
	}

}
