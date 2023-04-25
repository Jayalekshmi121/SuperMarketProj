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
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageField;
	
	public PushNotificationPage clickOnPushNotification() {
		PageUtility.clickOnElement(pushNotification);
		return this;
	}
	public boolean isTitleFieldDisplayed() {
		return PageUtility.isElementDisplayed(titleField);
	}
	public boolean isDescriptionFieldDisplayed() {
		return PageUtility.isElementDisplayed(descriptionField);
	}
	public PushNotificationPage enterValueInTitleField(String enterTitle) {
		PageUtility.enterText(titleField, enterTitle);
		return this;
	}
	public PushNotificationPage enterValueInDescriptionField(String description) {
		PageUtility.enterText(descriptionField, description);
		return this;
	}
	public boolean isSendButtonEnabled() 
	{
		return PageUtility.isElementEnabled(sendButton);
	}
	public PushNotificationPage clickOnSendButton() 
	{
		PageUtility.clickOnElement(sendButton);
		return this;
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
