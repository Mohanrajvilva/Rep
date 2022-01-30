package com.crm.genericlib;

import java.io.File;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility {
	WebDriver driver;
	
	public void maximizewindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
	}
	public void explicitwait(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void explicitwaitvisibility(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void dropdown(WebElement ele,int index)
	{
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	public void dropdown(WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);
	}
	public void dropdown(String value,WebElement ele)
	{
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	public void doubleclick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
	}
	public void rightclick(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	public void mousehover(WebDriver driver,WebElement ele)
	{
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	public void alertpopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void alertpopupdismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public void switchtoframe(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchtoframe(WebDriver driver,String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchtoframe(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	public void switchtowindow(WebDriver driver,String partitaltitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String winid = it.next();
			driver.switchTo().window(winid);
			String title = driver.getTitle();
			if(title.contains(partitaltitle))
			{
					break;
			}
		}
	}
	public void threadsleed(WebElement ele) throws Throwable
	{
		int count=0;
		while(count<20)
		{
			try
			{
				ele.click();
			}
			catch(Exception e)
			{
				Thread.sleep(2000);
				count++;
			}
		}
	}
	public void getscreenshot(WebDriver driver,String Screenshotname) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Photo"+Screenshotname+".PNG");
		Files.copy(src, dest);
	}
	
	public void swithtoframe(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	public void dragdrop(WebDriver driver,WebElement src,WebElement dest)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(src, dest).perform();
	}

}


