package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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

}
