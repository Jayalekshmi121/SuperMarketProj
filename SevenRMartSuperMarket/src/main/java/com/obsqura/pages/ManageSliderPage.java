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
	
	public void clickOnManageSlider() {
		PageUtility.clickOnElement(manageSlider);
	}
	public void clickOnNewButton() {
		PageUtility.clickOnElement(newButton);
	}
	public void enterValueInLinkField(String link) {
		PageUtility.enterText(linkField, link);
	}
	public void clickOnSaveButton() {
		PageUtility.clickOnElement(saveButton);
	}
	public boolean alertMessageFieldDisplayed() {
		return alertMessageField.isDisplayed();
	}
	public void clickOnEditButton() {
		PageUtility.clickOnElement(editButton);
	}
	public void clickOnUpdateButton() {
		PageUtility.clickOnElement(updateButton);
	}
	

}
