package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class LoginPagePage 
{
	WebDriver driver;
	public LoginPagePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	@FindBy(xpath="//button[@class='btn btn-dark btn-block']")
	WebElement signInButton;
	
	public boolean isUserNameFieldDisplayed() 
	{
		return PageUtility.isElementDisplayed(userNameField);
	}
	public void enterValueInUserNameField(String username) 
	{
		PageUtility.enterText(userNameField, username);
	}
	public boolean isPasswordFieldDisplayed() 
	{
		return PageUtility.isElementDisplayed(passwordField);
	}
	public void enterValueInPasswordField(String password) 
	{
		PageUtility.enterText(passwordField, password);
	}
	public boolean isSignInButtonEnabled() 
	{
		return PageUtility.isElementEnabled(signInButton);
	}
	public void clickOnSignInButton() 
	{
		PageUtility.clickOnElement(signInButton);
	}
	public String getTitleOfPage() {
		return driver.getTitle();
	}
}
