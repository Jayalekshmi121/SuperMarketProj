package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class MobileSliderPage {
	WebDriver driver;
	public MobileSliderPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Mobile Slider']//parent::a")
	WebElement mobileSlider;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement alertMessageField;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement updateButton;
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;
	
	public MobileSliderPage clickOnMobileSlider() {
		PageUtility.clickOnElement(mobileSlider);
		return this;
	}
	public MobileSliderPage clickOnNewButton() {
		PageUtility.clickOnElement(newButton);
		return this;
	}
	public MobileSliderPage clickOnSaveButton() {
		PageUtility.clickOnElement(saveButton);
		return this;
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public MobileSliderPage clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
		return this;
	}
	public MobileSliderPage clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
		return this;
	}
	public MobileSliderPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return this;
	}
	public boolean getLocationOfNewButtonAndResetButton() {
		return PageUtility.greaterComparisonX(resetButton, newButton);
	}
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public MobileSliderPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfHref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}

}
