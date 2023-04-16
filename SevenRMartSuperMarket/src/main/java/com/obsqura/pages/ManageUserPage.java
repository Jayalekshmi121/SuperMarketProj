package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

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
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	
	public void clickOnManageUser() {
		PageUtility.clickOnElement(manageUser);
	}
	public String getUrlOfPage() {
		return driver.getCurrentUrl();
	}
	public void clickOnInactiveButton() {
		PageUtility.clickOnElement(inactiveButton);
	}
	public String getUrlOfListUserPage() {
		return driver.getCurrentUrl();
	}

}
