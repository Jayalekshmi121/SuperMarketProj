package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class DeliveryBoyTest extends Base {
	DeliveryBoyPage deliveryBoyPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = Retry.class)
	public void verifyFunctionalityOfShowDetailsButtonInDeliveryBoyPage() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickOnManageDeliveryBoy().clickOnShowDetailsButton();
		assertTrue(deliveryBoyPage.isPasswordFieldDisplayed(),"PasswordField is not displayed");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyFunctionalityOfDeleteButtonInDeliveryBoyPage() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(deliveryBoyPage.isAlertFieldDisplayed(),"Delivery Boy information is not deleted successfully");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyAllignmentOfSearchButtonAndResetButton() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		assertTrue(deliveryBoyPage.getLocationOfSearchButtonAndResetButton(),"Reset Button is not alligned after Search button");
	}
	@Test(retryAnalyzer = Retry.class)
	public void verifyStatusChangeByClickingStatusButton() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickOnStatus();
		assertTrue(deliveryBoyPage.isAlertFieldDisplayed(),"Status not changed successfully");
	}

}
