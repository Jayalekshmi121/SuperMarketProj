package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManagePaymentPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class ManagePaymentTest extends Base {
	ManagePaymentPage managePaymentPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyEditButtonFunctionalityInManagePayementPage() throws IOException {
		String title=ExcelUtility.getString(16, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(5, 0, UtilityFile.excelPath, "menu"));
		managePaymentPage=new ManagePaymentPage(driver);
		managePaymentPage.clickOnManagePayment().clickOnEditButton().enterValueInTitleField(title).clickOnUpdateButton();
		assertTrue(managePaymentPage.alertMessageFieldDisplayed(),"Payment not edited successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyStatusOfButtonsInStatusField() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(5, 0, UtilityFile.excelPath, "menu"));
		managePaymentPage=new ManagePaymentPage(driver);
		managePaymentPage.clickOnStatus();
		assertTrue(managePaymentPage.alertMessageFieldDisplayed(),"Status not changed successfully");
		
	}

}
