package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManagePaymentPage {
	WebDriver driver;
	public ManagePaymentPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Payment Methods']//parent::a")
	WebElement managePayment;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//input[@id='name']")
	WebElement titleField;
	@FindBy(xpath="//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement alertMessageField;
	@FindBy(xpath="//span[@class='badge bg-warning']")
	WebElement statusButton;
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	
	public ManagePaymentPage clickOnManagePayment() {
		PageUtility.clickOnElement(managePayment);
		return this;
	}
	public ManagePaymentPage clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
		return this;
	}
	public ManagePaymentPage enterValueInTitleField(String title) {
		PageUtility.enterText(titleField, title);
		return this;
	}
	public ManagePaymentPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return this;
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public ManagePaymentPage clickOnStatusButton() {
		PageUtility.clickOnElement(statusButton);
		return this;
	}
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public ManagePaymentPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfHref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}

}
