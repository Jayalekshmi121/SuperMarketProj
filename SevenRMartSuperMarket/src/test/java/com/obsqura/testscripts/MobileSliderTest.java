package com.obsqura.testscripts;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.MobileSliderPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class MobileSliderTest extends Base {
	MobileSliderPage mobileSliderPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyMobileSliderAlertNotification()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "menu"));
		mobileSliderPage=new MobileSliderPage(driver);
		mobileSliderPage.clickOnMobileSlider().clickOnNewButton().clickOnSaveButton();
		assertTrue(mobileSliderPage.alertMessageFieldDisplayed(),"Slider not added successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyFunctionalityofDeleteButtonInMobileSlider()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "menu"));
		mobileSliderPage=new MobileSliderPage(driver);
		mobileSliderPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(mobileSliderPage.alertMessageFieldDisplayed(),"Slider not deleted successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyFunctionalityOfEditButtonInMobileSlider()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "menu"));
		mobileSliderPage=new MobileSliderPage(driver);
		mobileSliderPage.clickOnEditButton().clickOnUpdateButton();
		assertTrue(mobileSliderPage.alertMessageFieldDisplayed(),"Slider not edited successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyFunctionalityOfStatusButtoninMobileSlier()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "menu"));
		mobileSliderPage=new MobileSliderPage(driver);
		mobileSliderPage.clickOnStatus();
		assertTrue(mobileSliderPage.alertMessageFieldDisplayed(),"Slider not edited successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyAllignmentOfNewAndResetButton()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(4, 0, UtilityFile.excelPath, "menu"));
		mobileSliderPage=new MobileSliderPage(driver);
		assertTrue(mobileSliderPage.getLocationOfNewButtonAndResetButton(),"Reset button is not alligned after New button");
	}

}
