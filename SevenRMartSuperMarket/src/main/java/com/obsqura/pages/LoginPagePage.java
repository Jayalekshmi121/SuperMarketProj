package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;
import Utilities.WaitUtility;

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
	public LoginPagePage enterValueInUserNameField(String username) 
	{
		PageUtility.enterText(userNameField, username);
		return this;
	}
	public boolean isPasswordFieldDisplayed() 
	{
		return PageUtility.isElementDisplayed(passwordField);
	}
	public LoginPagePage enterValueInPasswordField(String password) 
	{
		PageUtility.enterText(passwordField, password);
		return this;
	}
	public boolean isSignInButtonEnabled() 
	{
		return PageUtility.isElementEnabled(signInButton);
	}
	public LoginPagePage clickOnSignInButton() 
	{
		PageUtility.clickOnElement(signInButton);
		return this;
	}
	public String getTitleOfPage() {
		return driver.getTitle();
	}
}
