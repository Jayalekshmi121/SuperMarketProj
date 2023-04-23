package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class ManageProductTest extends Base {
	ManageProductPage manageProductPage;
	LoginPageTest loginPageTest;
	@Test
	public void verifyFuctionalityOfDeleteButton() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(7, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageProductPage=new ManageProductPage(driver);
		manageProductPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageProductPage.isAlertFieldDisplayed(),"Product not deleted successfully");
	}
	@Test
	public void verifyAllignmentOfNewButtonAndSearchButton() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(7, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageProductPage=new ManageProductPage(driver);
		assertTrue(manageProductPage.getLocationOfNewAndSearchButton(),"New Button is not alligned before Search button");
	}
}
