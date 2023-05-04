package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.AdminUsersPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.RandomDataUtility;
import Utilities.UtilityFile;

public class AdminUsersTest extends Base {
	AdminUsersPage adminUsersPage;
	LoginPageTest loginPageTest;
	
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifySaveFunctionalityOfAdminUsersPage()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(8, 0, UtilityFile.excelPath, "menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnNewButton().enterValueInUserNameField(RandomDataUtility.firstNameFakerSample()).enterValueInPasswordField(RandomDataUtility.lastNameFakerSample()).clickOnUserTypeButton().clickOnSaveButton();
		assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"New User is not  added successfully");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyEditFunctionalityOfAdminUsersPage()  {
		String username=ExcelUtility.getString(19, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(8, 0, UtilityFile.excelPath, "menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnEditButton().enterValueInUserNameField(RandomDataUtility.firstNameFakerSample()).clickOnUpdateButton();
	    assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"UserName is not updated successfully");
	}
	@Test (retryAnalyzer = generaltests.Retry.class)
	public void verifyDeleteButtonFunctionalityInAdminUsersPage()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(8, 0, UtilityFile.excelPath, "menu"));
		adminUsersPage=new AdminUsersPage(driver);
		adminUsersPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(adminUsersPage.AlertMessageFieldDisplayed(),"Users are not  deleted successfully");
	}

}
