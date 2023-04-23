package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class ManageProductPage {
	WebDriver driver;
	public ManageProductPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//p[text()='Manage Product']//parent::a")
	WebElement manageProduct;
	@FindBy(xpath="//i[@class='fas fa-trash-alt']")
	WebElement deleteButton;
	@FindBy(xpath="//div[@class='col-sm-12']")
	WebElement alertField;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	
	public void clickOnManageProduct() {
		PageUtility.clickOnElement(manageProduct);
	}
	public void clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
	}
	public boolean isAlertFieldDisplayed() {
		return PageUtility.isElementDisplayed(alertField);
	}
	public boolean getLocationOfNewAndSearchButton() {
		return PageUtility.greaterComparisonX(searchButton, newButton);
	}

}
