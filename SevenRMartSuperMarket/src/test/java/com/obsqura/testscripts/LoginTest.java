package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.LoginPagePage;

import Utilities.ExcelUtility;

public class LoginTest  extends Base
{
	LoginPagePage loginPagePage;
	@Test
	public void verifyingLoginPageWithValidUserNameAndValidPassword() throws IOException {
		String titleofDashboard = ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String username = ExcelUtility.getString(1, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String password = ExcelUtility.getString(2, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPagePage = new LoginPagePage(driver);
		loginPagePage.enterValueInUserNameField(username);
		loginPagePage.enterValueInPasswordField(password);
		loginPagePage.clickOnSignInButton();
		assertEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
	@Test(dataProvider="LoginProvider")
	public void verifyingLoginPageWithInValidUserNameAndValidPassword(String username, String password) throws IOException {
		String titleofDashboard = ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPagePage = new LoginPagePage(driver);
		assertTrue(loginPagePage.isUserNameFieldDisplayed(),"Username field is not displayed");
		loginPagePage.enterValueInUserNameField(username);
		assertTrue(loginPagePage.isPasswordFieldDisplayed(),"Password field is not displayed");
		loginPagePage.enterValueInPasswordField(password);
		assertTrue(loginPagePage.isSignInButtonEnabled(),"SignIn button is not enabled");
		loginPagePage.clickOnSignInButton();
		assertEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
	@DataProvider(name="LoginProvider")
	 public Object[][] getDataFromDataprovider(){
		
	    return new Object[][] 
	    	{
	            { "7mart", "admin" }
	        };

	    }
	@Test
	public void verifyingLoginPageWithValidUserNameAndInValidPassword() throws IOException {
		String titleofDashboard = ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String username=ExcelUtility.getString(9, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String password=ExcelUtility.getString(10, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPagePage = new LoginPagePage(driver);
		assertTrue(loginPagePage.isUserNameFieldDisplayed(),"Username field is not displayed");
		loginPagePage.enterValueInUserNameField(username);
		assertTrue(loginPagePage.isPasswordFieldDisplayed(),"Password field is not displayed");
		loginPagePage.enterValueInPasswordField(password);
		assertTrue(loginPagePage.isSignInButtonEnabled(),"SignIn button is not enabled");
		loginPagePage.clickOnSignInButton();
		assertEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
	@Test
	public void verifyingLoginPageWithInValidUserNameAndInValidPassword() throws IOException {
		String titleofDashboard = ExcelUtility.getString(0, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String username=ExcelUtility.getString(11, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String password=ExcelUtility.getString(12, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
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
