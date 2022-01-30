package com.crm.genericlib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class Listimpclass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		String testname = result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot) Baseclass.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Photo/"+testname+".PNG");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		
	

}
