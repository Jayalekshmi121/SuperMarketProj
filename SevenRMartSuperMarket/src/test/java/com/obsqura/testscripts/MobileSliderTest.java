package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.obsqura.pages.MobileSliderPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class MobileSliderTest extends Base {
	MobileSliderPage mobileSliderPage;
	LoginPageTest loginPageTest;
	@Test
	public void verifyMobileSliderAlertNotification() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(4, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		mobileSliderPage=new MobileSliderPage(driver);
		mobileSliderPage.clickOnMobileSlider();
		mobileSliderPage.clickOnNewButton();
		mobileSliderPage.clickOnSaveButton();
		assertTrue(mobileSliderPage.alertMessageFieldDisplayed(),"Alert Message Field is not displayed");
	}

}
