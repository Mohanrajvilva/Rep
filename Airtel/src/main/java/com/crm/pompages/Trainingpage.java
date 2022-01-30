package com.crm.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Trainingpage {
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement plusbtn;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-lg btn-flat']")
	private WebElement addtocart;
	
	public Trainingpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getPlusbtn() {
		return plusbtn;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}
	

}
