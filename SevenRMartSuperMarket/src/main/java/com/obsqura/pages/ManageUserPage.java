package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class ManageUserPage 
{
	WebDriver driver;
	public ManageUserPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Users']//parent::a")
	WebElement manageUser;
	@FindBy(xpath="//span[text()='Inactive']")
	WebElement inactiveButton;
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement alertMessageField;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath="//a[@role='button']")
	WebElement StatusButtonElement;
	
	
	
	public ManageUserPage clickOnManageUser() {
		PageUtility.clickOnElement(manageUser);
		return this;
	}
	public String getUrlOfPage() {
		return driver.getCurrentUrl();
	}
	public ManageUserPage clickOnInactiveButton() {
		PageUtility.clickOnElement(inactiveButton);
		return this;
	}
	public String getUrlOfListUserPage() {
		return driver.getCurrentUrl();
	}
	public ManageUserPage clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
		return this;
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public String getBackGroundColorOfStatusButton()
	{
		return PageUtility.getCssValueOfElement(StatusButtonElement, "background-color");
	}
	
	public ManageUserPage clickOnStatus()
	{
		PageUtility.getAttributeElementOfHref(StatusButtonElement);
		WaitUtility.waitForElementClickable(driver, StatusButtonElement);
		getBackGroundColorOfStatusButton().equals(StatusButtonElement);
		PageUtility.clickOnElement(StatusButtonElement);
		return this;
	}

}
