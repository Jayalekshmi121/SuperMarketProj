package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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
	
	public void clickOnManageLocation() {
		PageUtility.clickOnElement(managePayment);
	}
	public void clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
	}
	public void enterValueInTitleField(String title) {
		PageUtility.enterText(titleField, title);
	}
	public void clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public void clickOnStatusButton() {
		PageUtility.clickOnElement(statusButton);
	}

}
