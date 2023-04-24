package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.AdminUsersPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;

public class AdminUsersTest extends Base {
	AdminUsersPage adminUsersPage;
	LoginPageTest loginPageTest;
	
	@Test (retryAnalyzer = Retry.class)
	public void verifySaveFunctionalityOfAdminUsersPage() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(8, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton().enterValueInUserNameField(FakerUtility.firstNameFakerSample()).enterValueInPasswordField(FakerUtility.lastNameFakerSample()).clickOnUserTypeButton().clickOnSaveButton();
		assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"New User is not  added successfully");
	}
	@Test (retryAnalyzer = Retry.class)
	public void verifyEditFunctionalityOfAdminUsersPage() throws IOException {
		String username=ExcelUtility.getString(19, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(8, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnEditButton().enterValueInUserNameField(FakerUtility.firstNameFakerSample()).clickOnUpdateButton();
	    assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"UserName is not updated successfully");
	}
	@Test (retryAnalyzer = Retry.class)
	public void verifyDeleteButtonFunctionalityInAdminUsersPage() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(8, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"Users are not  deleted successfully");
	}

}
