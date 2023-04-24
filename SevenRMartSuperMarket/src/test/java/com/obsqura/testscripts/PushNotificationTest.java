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
		String enterTitle=ExcelUtility.getString(5, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		String description=ExcelUtility.getString(6, 1, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnPushNotification().enterValueInTitleField(enterTitle).enterValueInDescriptionField(description).clickOnSendButton();
		assertTrue(pushNotificationPage.alertMessageFieldDisplayed(),"Push notification Message not send successfully");
	}
	@Test
	public void verifyIfSendButtonIsAllignedBelowDescriptionField() throws IOException {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(1, 0, System.getProperty("user.dir")+constants.Constants.EXCELFILE, "menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		assertTrue(pushNotificationPage.getLocationOfDescriptionField(),"Send button is not alligned below Description field");
	}
}
