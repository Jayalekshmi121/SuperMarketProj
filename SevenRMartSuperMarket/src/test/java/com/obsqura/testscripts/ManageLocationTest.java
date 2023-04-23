package com.obsqura.testscripts;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.ManageLocationPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	ManageLocationPage manageLocationPage;
	LoginPageTest loginPageTest;
	@Test
	public void addingLocationByEnteringValuesInLocationInformationField() throws IOException {
		String locationName=ExcelUtility.getString(13, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String deliveryCharge=ExcelUtility.getString(14, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnManageLocation();
		manageLocationPage.clickOnNewButton();
		manageLocationPage.enterValueInLocationField(locationName);
		manageLocationPage.enterValueInDeliveryChargeField(deliveryCharge);
		manageLocationPage.clickOnSaveButton();
		assertTrue(manageLocationPage.alertMessageFieldDisplayed(),"Alert Message Field not displayed");
	}
	@Test
	public void verifyStatusOfButtonsInStatusField() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnStatusButton();
		assertTrue(manageLocationPage.alertMessageFieldDisplayed(),"Alert Message Field not displayed");
	}
	@Test
	public void verifyEditButtonFunctionalityInManageLocationField() throws IOException {
		String locationName=ExcelUtility.getString(18, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		manageLocationPage.clickOnEditButton();
		manageLocationPage.enterValueInLocationField(locationName);
		manageLocationPage.clickOnUpdateButton();
		assertTrue(manageLocationPage.alertMessageFieldDisplayed(),"Location is not Updated Successfully");
	}
	@Test
	public void verifyIfNewButtonIsAllignedBeforeSearchButton() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(2, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		manageLocationPage=new ManageLocationPage(driver);
		assertTrue(manageLocationPage.getLocationOfNewButtonAndSearchButton(),"New Button is not alligned before search button");
	}	

}
