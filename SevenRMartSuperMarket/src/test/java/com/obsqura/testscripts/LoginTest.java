package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.obsqura.pages.LoginPagePage;
import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class LoginTest  extends Base
{
	LoginPagePage loginPagePage;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyingLoginPageWithValidUserNameAndValidPassword()  {
		String titleofDashboard = ExcelUtility.getString(0, 1, UtilityFile.excelPath, "login");
		String username = ExcelUtility.getString(1, 1, UtilityFile.excelPath, "login");
		String password = ExcelUtility.getString(2, 1, UtilityFile.excelPath, "login");
		loginPagePage = new LoginPagePage(driver);
		loginPagePage.enterValueInUserNameField(username).enterValueInPasswordField(password).clickOnSignInButton();
		assertEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
	@Test(dataProvider="LoginProvider")
	public void verifyingLoginPageWithInValidUserNameAndValidPassword(String username, String password)  {
		String titleofDashboard = ExcelUtility.getString(0, 1, UtilityFile.excelPath, "login");
		loginPagePage = new LoginPagePage(driver);
		loginPagePage.enterValueInUserNameField(username).enterValueInPasswordField(password).clickOnSignInButton();
		assertNotEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
	@DataProvider(name="LoginProvider")
	 public Object[][] getDataFromDataprovider(){
		
	    return new Object[][] 
	    	{
	            { "7mart", "admin" }
	        };

	    }
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyingLoginPageWithValidUserNameAndInValidPassword()  {
		String titleofDashboard = ExcelUtility.getString(0, 1, UtilityFile.excelPath, "login");
		String username=ExcelUtility.getString(9, 1, UtilityFile.excelPath, "login");
		String password=ExcelUtility.getString(10, 1, UtilityFile.excelPath, "login");
		loginPagePage = new LoginPagePage(driver);
		loginPagePage.enterValueInUserNameField(username).enterValueInPasswordField(password).clickOnSignInButton();
		assertNotEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyingLoginPageWithInValidUserNameAndInValidPassword()  {
		String titleofDashboard = ExcelUtility.getString(0, 1, UtilityFile.excelPath, "login");
		String username=ExcelUtility.getString(11, 1, UtilityFile.excelPath, "login");
		String password=ExcelUtility.getString(12, 1, UtilityFile.excelPath, "login");
		loginPagePage = new LoginPagePage(driver);
		loginPagePage.enterValueInUserNameField(username).enterValueInPasswordField(password).clickOnSignInButton();
		assertNotEquals(titleofDashboard,loginPagePage.getTitleOfPage(),"Titles are not same");
	}
}
