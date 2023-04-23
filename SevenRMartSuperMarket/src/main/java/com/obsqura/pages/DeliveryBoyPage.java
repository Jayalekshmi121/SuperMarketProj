package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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
	
	
	public void clickOnManageDeliveryBoy() {
		PageUtility.clickOnElement(manageDeliveryBoy);
	}
	public void clickOnShowDetailsButton() {
		PageUtility.clickOnElement(showDetailsButton);
	}
	public boolean isPasswordFieldDisplayed() {
		return PageUtility.isElementDisplayed(passwordField);
	}
	public void clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
	}
	public void editValueInNameField(String name) {
		PageUtility.enterText(nameField, name);
	}
	public void clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
	}
	public void clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
	}
	public boolean isAlertFieldDisplayed() {
		return PageUtility.isElementDisplayed(alertField);
	}
	public boolean getLocationOfSearchButtonAndResetButton() {
		return PageUtility.greaterComparisonX(resetButton, searchButton);
	}
	

}
