package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageSliderPage {
	WebDriver driver;
	public ManageSliderPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Slider']")
	WebElement manageSlider;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//input[@id='link']")
	WebElement linkField;
	@FindBy(xpath="//button[@name='create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement alertMessageField;
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	@FindBy(xpath="//button[@name='update']")
	WebElement updateButton;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	
	public ManageSliderPage clickOnManageSlider() {
		PageUtility.clickOnElement(manageSlider);
		return this;
	}
	public ManageSliderPage clickOnNewButton() {
		PageUtility.clickOnElement(newButton);
		return this;
	}
	public ManageSliderPage enterValueInLinkField(String link) {
		PageUtility.enterText(linkField, link);
		return this;
	}
	public ManageSliderPage clickOnSaveButton() {
		PageUtility.clickOnElement(saveButton);
		return this;
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public ManageSliderPage clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
		return this;
	}
	public ManageSliderPage clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
		return this;
	}
	public ManageSliderPage clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
		return this;
	}
}
