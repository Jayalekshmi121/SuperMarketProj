package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPagePage;

import Utilities.ExcelUtility;

public class LoginPageTest extends Base
{
	LoginPagePage loginPagePage;
	public LoginPageTest(WebDriver driver) 
	{
		this.driver=driver;	
	}
	@Test
	public void verifyingLoginPageWithValidUserNameAndValidPassword() throws IOException 
	{
		String titleofDashboard = ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String username = ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String password = ExcelUtility.getString(2, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPagePage = new LoginPagePage(driver);
		assertTrue(loginPagePage.isUserNameFieldDisplayed(),"Username field is not displayed");
		loginPagePage.enterValueInUserNameField(username);
		assertTrue(loginPagePage.isPasswordFieldDisplayed(),"Password field is not displayed");
		loginPagePage.enterValueInPasswordField(password);
		assertTrue(loginPagePage.isSignInButtonEnabled(),"SignIn button is not enabled");
		loginPagePage.clickOnSignInButton();
		assertEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
	
	
}