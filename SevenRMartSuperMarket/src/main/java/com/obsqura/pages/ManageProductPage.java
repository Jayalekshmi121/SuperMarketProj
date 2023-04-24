package com.obsqura.pages;

import java.util.List;

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
	@FindBy(xpath="//button[@class='btn btn-xs btn-success']")
	WebElement ProductCodeButtonElement;
	@FindBy(xpath="//input[@placeholder='Title']")
	WebElement TitleFieldElement;
	@FindBy(xpath="//button[@name='Search']")
	WebElement FilterSearchButtonElement;
	
	public ManageProductPage clickOnManageProduct() {
		PageUtility.clickOnElement(manageProduct);
		return this;
	}
	public ManageProductPage clickOnDeleteButton() {
		PageUtility.clickOnElement(deleteButton);
		return this;
	}
	public boolean isAlertFieldDisplayed() {
		return PageUtility.isElementDisplayed(alertField);
	}
	public boolean getLocationOfNewAndSearchButton() {
		return PageUtility.greaterComparisonX(searchButton, newButton);
	}
	public boolean  productCodeButtonIsDisplayed()
	{
		return PageUtility.isElementDisplayed(ProductCodeButtonElement);
	}
	public boolean checkTitleIsPresent(String Title)
	{
		List<WebElement> rows=PageUtility.findRowElements(TitleFieldElement);
		for(WebElement row:rows)
		{
	     	if(row.getText().contains(Title))
	     		return  true;
		}
		return  false;
	}
	public ManageProductPage enterValueInTitleField(String title)
    {
    	PageUtility.enterText(TitleFieldElement, title);
    	return this;
    }
	public ManageProductPage clickOnSearchButton() {
		PageUtility.clickOnElement(searchButton);
		return this;
	}
	public ManageProductPage clickOnFilterSearchButton() {
		PageUtility.clickOnElement(FilterSearchButtonElement);
		return this;
	}

}
