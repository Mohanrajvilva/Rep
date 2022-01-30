package com.crm.genericlib;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {
	
	public String getdatafrompropertyfile(String key) throws Throwable
	{
		FileInputStream fs=new FileInputStream(Autoconstant.Propertyfilepath);
		Properties p=new Properties();
		p.load(fs);
		return p.getProperty(key);
		
	}

}
