package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.ManageSliderPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class ManageSliderTest extends Base {
	ManageSliderPage manageSliderPage;
	LoginPageTest loginPageTest;
	
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void addingSliderByEnteringValueInLinkField()  {
		String link=ExcelUtility.getString(15, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(3, 0, UtilityFile.excelPath, "menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnManageSlider().clickOnNewButton().enterValueInLinkField(link).clickOnSaveButton();
		assertTrue(manageSliderPage.alertMessageFieldDisplayed(),"Slider not added successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyEditButtonFunctionalityInManageSliderPage()  {
		String link=ExcelUtility.getString(17, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(3, 0, UtilityFile.excelPath, "menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnEditButton().enterValueInLinkField(link).clickOnUpdateButton();
		assertTrue(manageSliderPage.alertMessageFieldDisplayed(),"Slider not edited successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyDeleteFunctionality()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(3, 0, UtilityFile.excelPath, "menu"));
		manageSliderPage=new ManageSliderPage(driver);
		manageSliderPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(manageSliderPage.alertMessageFieldDisplayed(),"Slider not deleted successfully");
	}

}
