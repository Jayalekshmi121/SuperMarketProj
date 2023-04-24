package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;


public class ManageUserTest extends Base
{
	ManageUserPage manageUserPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = Retry.class)
	public void verifyManageUserPageNavigationFromDashBoard() throws IOException 
	{
		String urlofPage = ExcelUtility.getString(3, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(0, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageUserPage=new ManageUserPage(driver);
		manageUserPage.clickOnManageUser();
		assertEquals(urlofPage,manageUserPage.getUrlOfPage(),"Urls are not same");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyStatusChangeWhenInactiveButtonInListUserPageisClicked() throws IOException 
	{
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(0, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageUserPage=new ManageUserPage(driver);
		manageUserPage.clickOnStatus();
		assertTrue(manageUserPage.alertMessageFieldDisplayed(),"User is not deleted successfully");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyDeleteButtonFunctionalityInManageUserPage() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(0, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageUserPage=new ManageUserPage(driver);
		manageUserPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageUserPage.alertMessageFieldDisplayed(),"User is not deleted successfully");
	}
	
}
