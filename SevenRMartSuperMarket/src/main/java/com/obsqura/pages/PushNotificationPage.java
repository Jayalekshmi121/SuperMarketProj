package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class PushNotificationPage {

	WebDriver driver;
	public PushNotificationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushNotification;
	@FindBy(xpath="//input[@id='title']")
	WebElement titleField;
	@FindBy(xpath="//input[@id='description']")
	WebElement descriptionField;
	@FindBy(xpath="//button[@type='submit']")
	WebElement sendButton;
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement alertMessageField;
	
	public void clickOnPushNotification() {
		PageUtility.clickOnElement(pushNotification);
	}
	public boolean isTitleFieldDisplayed() {
		return PageUtility.isElementDisplayed(titleField);
	}
	public boolean isDescriptionFieldDisplayed() {
		return PageUtility.isElementDisplayed(descriptionField);
	}
	public void enterValueInTitleField(String enterTitle) {
		PageUtility.enterText(titleField, enterTitle);
	}
	public void enterValueInDescriptionField(String description) {
		PageUtility.enterText(descriptionField, description);
	}
	public boolean isSendButtonEnabled() 
	{
		return PageUtility.isElementEnabled(sendButton);
	}
	public void clickOnSendButton() 
	{
		PageUtility.clickOnElement(sendButton);
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public String getUrlOfPushNotificationPage() {
		return driver.getCurrentUrl();
	}
	public boolean getLocationOfDescriptionField() {
		return PageUtility.greaterComparisonY(sendButton, descriptionField);
	}
}
