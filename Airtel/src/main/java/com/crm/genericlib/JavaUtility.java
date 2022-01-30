package com.crm.genericlib;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getrandomnum()
	{
		Random ran=new Random();
		int rannum = ran.nextInt(1000);
		return rannum;
	}
	public String getcurrentdate()
	{
		Date d=new Date();
		String dat = d.toString();
		return dat;
	}
	public String getsystemdate() {
		Date d=new Date();
		String dat = d.toString();
		String[] dt = dat.split(" ");
		String YYYY = dt[5];
		String MM = dt[2];
		String DD = dt[1];
		String today = YYYY+"-"+MM+"-"+DD;
		return today;
	}

}
