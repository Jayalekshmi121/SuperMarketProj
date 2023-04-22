package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManagePaymentPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class ManagePaymentTest extends Base {
	ManagePaymentPage managePaymentPage;
	LoginPageTest loginPageTest;
	@Test
	public void verifyEditButtonFunctionalityInManagePayementPage() throws IOException {
		String title=ExcelUtility.getString(16, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(5, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		managePaymentPage=new ManagePaymentPage(driver);
		managePaymentPage.clickOnManageLocation();
		managePaymentPage.clickOnEditButton();
		managePaymentPage.enterValueInTitleField(title);
		managePaymentPage.clickOnUpdateButton();
		assertTrue(managePaymentPage.alertMessageFieldDisplayed(),"Alert Message Field not displayed");
	}
	@Test
	public void verifyStatusOfButtonsInStatusField() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(5, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		managePaymentPage=new ManagePaymentPage(driver);
		managePaymentPage.clickOnStatusButton();
		assertTrue(managePaymentPage.alertMessageFieldDisplayed(),"Alert Message Field not displayed");
		
	}

}
