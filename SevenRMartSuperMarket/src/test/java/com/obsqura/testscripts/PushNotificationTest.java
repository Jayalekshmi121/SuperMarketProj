package com.obsqura.testscripts;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.PushNotificationPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class PushNotificationTest extends Base
{
	PushNotificationPage pushNotificationPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyPushNotificationPageNavigationFromDashBoard()  {
		String urlofPage = ExcelUtility.getString(7, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(1, 0, UtilityFile.excelPath, "menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnPushNotification();
		assertEquals(urlofPage,pushNotificationPage.getUrlOfPushNotificationPage(),"Urls are not same");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void sendingNotificationByEnteringValueInFieldsOfPushNotificationPage()  {
		String enterTitle=ExcelUtility.getString(5, 1, UtilityFile.excelPath, "login");
		String description=ExcelUtility.getString(6, 1, UtilityFile.excelPath, "login");
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(1, 0, UtilityFile.excelPath, "menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		pushNotificationPage.clickOnPushNotification().enterValueInTitleField(enterTitle).enterValueInDescriptionField(description).clickOnSendButton();
		assertTrue(pushNotificationPage.alertMessageFieldDisplayed(),"Push notification Message not send successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyIfSendButtonIsAllignedBelowDescriptionField()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(1, 0, UtilityFile.excelPath, "menu"));
		pushNotificationPage=new PushNotificationPage(driver);
		assertTrue(pushNotificationPage.getLocationOfDescriptionField(),"Send button is not alligned below Description field");
	}
}
