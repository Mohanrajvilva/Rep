package com.crm.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	
	@FindBy(name="addresstype")
	private WebElement dropdown;
	
	@FindBy(xpath="(//a[text()='Selenium Training'])[2]")
	private WebElement selenium;
	
	@FindBy(xpath="//img[@class='user-image']")
	private WebElement logout;
	
	@FindBy(linkText="Sign out")
	private WebElement signoutbtn;
	
	public Homepage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSelenium() {
		return selenium;
	}
	public void logout()
	{
		logout.click();
		signoutbtn.click();
	}
	

}
