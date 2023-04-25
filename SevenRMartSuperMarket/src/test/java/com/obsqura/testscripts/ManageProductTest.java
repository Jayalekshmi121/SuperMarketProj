package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageProductPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class ManageProductTest extends Base {
	ManageProductPage manageProductPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyFuctionalityOfDeleteButton() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "menu"));
		manageProductPage=new ManageProductPage(driver);
		manageProductPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageProductPage.isAlertFieldDisplayed(),"Product not deleted successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyAllignmentOfNewButtonAndSearchButton() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "menu"));
		manageProductPage=new ManageProductPage(driver);
		assertTrue(manageProductPage.getLocationOfNewAndSearchButton(),"New Button is not alligned before Search button");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifySearchFunctionalityInManageProductPage() throws IOException {
		String title=ExcelUtility.getString(20, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(7, 0, UtilityFile.excelPath, "menu"));
		manageProductPage=new ManageProductPage(driver);
		manageProductPage.clickOnSearchButton().enterValueInTitleField(title).clickOnFilterSearchButton();
		assertTrue(manageProductPage.productCodeButtonIsDisplayed(),"Searched Content-title:Red Meat is not found");
	}
}
