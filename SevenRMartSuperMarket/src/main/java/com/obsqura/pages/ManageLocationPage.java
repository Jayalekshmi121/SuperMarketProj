package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageLocationPage {
	WebDriver driver;
	public ManageLocationPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Location']//parent::a")
	WebElement manageLocation;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@id='location']")
	WebElement locationField;
	@FindBy(xpath="//input[@id='delivery']")
	WebElement deliveryChargeField;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement alertMessageField;
	@FindBy(xpath="//span[@class='badge bg-warning']")
	WebElement statusButton;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	
	public ManageLocationPage clickOnManageLocation() {
		PageUtility.clickOnElement(manageLocation);
		return this;
	}
	public ManageLocationPage clickOnNewButton() {
		PageUtility.clickOnElement(newButton);
		return this;
	}
	public ManageLocationPage enterValueInLocationField(String locationName) {
		PageUtility.enterText(locationField, locationName);
		return this;
	}
	public ManageLocationPage enterValueInDeliveryChargeField(String deliveryCharge) {
		PageUtility.enterText(deliveryChargeField, deliveryCharge);
		return this;
	}
	public ManageLocationPage clickOnSaveButton() {
		PageUtility.clickOnElement(saveButton);
		return this;
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public ManageLocationPage clickOnStatusButton() {
		PageUtility.clickOnElement(statusButton);
		return this;
	}
	public ManageLocationPage clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
		return this;
	}
	public ManageLocationPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return this;
	}
	public boolean getLocationOfNewButtonAndSearchButton() {
		return PageUtility.greaterComparisonX(searchButton, newButton);
	}
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public ManageLocationPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfHref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}
}
