package com.crm.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericlib.Baseclass;
import com.crm.genericlib.FileUtility;
import com.crm.genericlib.WebdriverUtility;
import com.crm.pompages.Homepage;
import com.crm.pompages.Loginpage;
import com.crm.pompages.Trainingpage;


@Listeners(com.crm.genericlib.Listimpclass.class)
public class Practice extends Baseclass{
	
	
	@Test(retryAnalyzer = )
	public void addtocart() {
		
		Homepage hp=new Homepage(driver);
		wlib.dropdown(hp.getDropdown(), 1);
		hp.getSelenium().click();
		Assert.assertEquals("a","b");
		
		Trainingpage tp=new Trainingpage(driver);
		wlib.doubleclick(driver, tp.getPlusbtn());
		tp.getAddtocart().click();
		wlib.alertpopup(driver);
	}

}
