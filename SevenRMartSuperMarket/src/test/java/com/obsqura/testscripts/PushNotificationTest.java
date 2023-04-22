package com.obsqura.testscripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;


import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;

import Utilities.ExcelUtility;

public class PushNotificationTest extends Base
{
	PushNotificationPage pushNotificationPage;
	LoginPageTest loginPageTest;
	@Test
	public void verifyPushNotificationPageNavigationFromDashBoard() throws IOException {
		String urlofPage = ExcelUtility.getString(7, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnPushNotification();
		assertEquals(urlofPage,pushNotificationPage.getUrlOfPushNotificationPage(),"Urls are not same");
	}
	@Test
	public void sendingNotificationByEnteringValueInFieldsOfPushNotificationPage() throws IOException {
		String urlofPage = ExcelUtility.getString(8, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String enterTitle=ExcelUtility.getString(5, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String description=ExcelUtility.getString(6, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnPushNotification();
		assertTrue(pushNotificationPage.isTitleFieldDisplayed(),"Title field is not displayed");
		pushNotificationPage.enterValueInTitleField(enterTitle);
		assertTrue(pushNotificationPage.isDescriptionFieldDisplayed(),"Description field is not displayed");
		pushNotificationPage.enterValueInDescriptionField(description);
		assertTrue(pushNotificationPage.isSendButtonEnabled(),"Send button is not enabled");
		pushNotificationPage.clickOnSendButton();
		assertEquals(urlofPage,pushNotificationPage.getUrlOfPushNotificationPage(),"Urls are not same");
	}
}
