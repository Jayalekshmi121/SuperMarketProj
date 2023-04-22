package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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
	
	public void clickOnManageLocation() {
		PageUtility.clickOnElement(manageLocation);
	}
	public void clickOnNewButton() {
		PageUtility.clickOnElement(newButton);
	}
	public void enterValueInLocationField(String locationName) {
		PageUtility.enterText(locationField, locationName);
	}
	public void enterValueInDeliveryChargeField(String deliveryCharge) {
		PageUtility.enterText(deliveryChargeField, deliveryCharge);
	}
	public void clickOnSaveButton() {
		PageUtility.clickOnElement(saveButton);
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public void clickOnStatusButton() {
		PageUtility.clickOnElement(statusButton);
	}
	public void clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
	}
	public void clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
	}
}
