package com.obsqura.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageUserPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;


public class ManageUserTest extends Base
{
	ManageUserPage manageUserPage;
	LoginPageTest loginPageTest;
	@Test
	public void verifyManageUserPageNavigation() throws IOException 
	{
		String urlofPage = ExcelUtility.getString(3, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu("Manage Users");
		manageUserPage=new ManageUserPage(driver);
		manageUserPage.clickOnManageUser();
		assertEquals(urlofPage,manageUserPage.getUrlOfPage(),"Urls are not same");
	}
	@Test
	public void verifyStatusButtonsInListUserPage() throws IOException 
	{
		String urlFromListPage = ExcelUtility.getString(4, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu("Manage Users");
		manageUserPage=new ManageUserPage(driver);
		manageUserPage.clickOnManageUser();
		manageUserPage.clickOnInactiveButton();
		assertEquals(urlFromListPage,manageUserPage.getUrlOfListUserPage(),"Messages are not same");
	}
	
}