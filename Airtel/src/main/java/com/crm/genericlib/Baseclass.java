package com.crm.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.pompages.Homepage;
import com.crm.pompages.Loginpage;

public class Baseclass{
	public static WebDriver driver;
	public ExcelUtility elib=new ExcelUtility();
	public FileUtility flib=new FileUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	
	@BeforeSuite
	public void congifBS()
	{
		System.out.println("Connect to database");
	}
	
	@BeforeClass
	public void configBC() throws Throwable
	{
		String Browser = flib.getdatafrompropertyfile("browser");
		String url = flib.getdatafrompropertyfile("url");
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("Invalid Browser");
		}
		wlib.maximizewindow(driver);
		wlib.implicitwait(driver);
		driver.get(url);
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		String username = flib.getdatafrompropertyfile("username");
		String password = flib.getdatafrompropertyfile("password");
		Loginpage lp=new Loginpage(driver);
		lp.login(username, password);
		
	}
	
	@AfterMethod
	public void configAM()
	{
		Homepage hp=new Homepage(driver);
		hp.logout();
	}
	
	@AfterClass
	public void configAC()
	{
		driver.close();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("disconnect to db");
	}
	

}
