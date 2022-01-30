package com.crm.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	@FindBy(id="email")
	private WebElement usernamebtn;
	
	@FindBy(id="password")
	private WebElement passwordfield;
	
	@FindBy(id="last")
	private WebElement loginbtn;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void login(String username,String password)
	{
		usernamebtn.sendKeys(username);
		passwordfield.sendKeys(password);
		loginbtn.click();
	}

}
