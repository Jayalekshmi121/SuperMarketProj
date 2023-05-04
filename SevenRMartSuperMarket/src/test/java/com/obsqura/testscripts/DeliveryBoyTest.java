package com.obsqura.testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.pages.DeliveryBoyPage;
import com.obsqura.pages.SelectCategoryList;
import Utilities.ExcelUtility;
import Utilities.UtilityFile;

public class DeliveryBoyTest extends Base {
	DeliveryBoyPage deliveryBoyPage;
	LoginPageTest loginPageTest;
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyFunctionalityOfShowDetailsButtonInDeliveryBoyPage()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickOnManageDeliveryBoy().clickOnShowDetailsButton();
		assertTrue(deliveryBoyPage.isPasswordFieldDisplayed(),"PasswordField is not displayed");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyFunctionalityOfDeleteButtonInDeliveryBoyPage()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickOnDeleteButton();
		driver.switchTo().alert().accept();
		assertTrue(deliveryBoyPage.isAlertFieldDisplayed(),"Delivery Boy information is not deleted successfully");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyAllignmentOfSearchButtonAndResetButton()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		assertTrue(deliveryBoyPage.getLocationOfSearchButtonAndResetButton(),"Reset Button is not alligned after Search button");
	}
	@Test(retryAnalyzer = generaltests.Retry.class)
	public void verifyStatusChangeByClickingStatusButton()  {
		loginPageTest=new LoginPageTest(driver);
		loginPageTest.verifyingLoginPageWithValidUserNameAndValidPassword();
		SelectCategoryList SelectCategoryListObj=new SelectCategoryList(driver);
		SelectCategoryListObj.navigateMenu(ExcelUtility.getString(6, 0, UtilityFile.excelPath, "menu"));
		deliveryBoyPage=new DeliveryBoyPage(driver);
		deliveryBoyPage.clickOnStatus();
		assertTrue(deliveryBoyPage.isAlertFieldDisplayed(),"Status not changed successfully");
	}

}
