package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class DeliveryBoyPage {
	WebDriver driver;
	public DeliveryBoyPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Delivery Boy']//parent::a")
	WebElement manageDeliveryBoy;
	@FindBy(xpath="//i[@class='fa fa-angle-double-down']")
	WebElement showDetailsButton;
	@FindBy(xpath="//div[@class='col-xs-12 col-sm-12']")
	WebElement passwordField;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//input[@name='name']")
	WebElement nameField;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertField;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	
	public DeliveryBoyPage clickOnManageDeliveryBoy() {
		PageUtility.clickOnElement(manageDeliveryBoy);
		return this;
	}
	public DeliveryBoyPage clickOnShowDetailsButton() {
		PageUtility.clickOnElement(showDetailsButton);
		return this;
	}
	public boolean isPasswordFieldDisplayed() {
		return PageUtility.isElementDisplayed(passwordField);
	}
	public DeliveryBoyPage clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
		return this;
	}
	public DeliveryBoyPage editValueInNameField(String name) {
		PageUtility.enterText(nameField, name);
		return this;
	}
	public DeliveryBoyPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return this;
	}
	public DeliveryBoyPage clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
		return this;
	}
	public boolean isAlertFieldDisplayed() {
		return PageUtility.isElementDisplayed(alertField);
	}
	public boolean getLocationOfSearchButtonAndResetButton() {
		return PageUtility.greaterComparisonX(resetButton, searchButton);
	}
	
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public DeliveryBoyPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfHref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}

}
