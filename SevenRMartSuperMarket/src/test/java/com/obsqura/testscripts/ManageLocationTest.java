package com.obsqura.testscripts;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class ManageLocationTest extends Base {
	ManageLocationPage manageLocationPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void addingLocationByEnteringValuesInLocationInformationField()  {
		String locationName=ExcelUtility.getString(13, 1, UtilityFile.excelPath, "login");
		String deliveryCharge=ExcelUtility.getString(14, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, UtilityFile.excelPath, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnManageLocation().clickOnNewButton().enterValueInLocationField(locationName).enterValueInDeliveryChargeField(deliveryCharge).clickOnSaveButton();
		assertTrue(manageLocationPage.alertMessageFieldDisplayed(),"Location not added successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyStatusOfButtonsInStatusField()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, UtilityFile.excelPath, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnStatus();
		assertTrue(manageLocationPage.alertMessageFieldDisplayed(),"Status not changed successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyEditButtonFunctionalityInManageLocationField()  {
		String locationName=ExcelUtility.getString(18, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, UtilityFile.excelPath, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnEditButton().enterValueInLocationField(locationName).clickOnUpdateButton();
		assertTrue(manageLocationPage.alertMessageFieldDisplayed(),"Location is not Updated Successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyIfNewButtonIsAllignedBeforeSearchButton()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, UtilityFile.excelPath, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		assertTrue(manageLocationPage.getLocationOfNewButtonAndSearchButton(),"New Button is not alligned before search button");
	}	

}
