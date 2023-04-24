package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageSliderPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class ManageSliderTest extends Base {
	ManageSliderPage manageSliderPage;
	LoginPageTest loginPageTest;
	
	@Test(retryAnalyzer = Retry.class)
	public void addingSliderByEnteringValueInLinkField() throws IOException {
		String link=ExcelUtility.getString(15, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnManageSlider().clickOnNewButton().enterValueInLinkField(link).clickOnSaveButton();
		assertTrue(manageSliderPage.alertMessageFieldDisplayed(),"Slider not added successfully");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyEditButtonFunctionalityInManageSliderPage() throws IOException {
		String link=ExcelUtility.getString(17, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnEditButton().enterValueInLinkField(link).clickOnUpdateButton();
		assertTrue(manageSliderPage.alertMessageFieldDisplayed(),"Slider not edited successfully");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyDeleteFunctionality() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(3, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageSliderPage.alertMessageFieldDisplayed(),"Slider not deleted successfully");
	}

}
