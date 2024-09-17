package com.pom.demoopencart.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.demoopencart.base.ActionEngine;
import com.pom.demoopencart.enums.LoginEnum;
import com.pom.demoopencart.pages.FlipCartPage;
import com.pom.demoopencart.pages.LoginPage;
import com.pom.demoopencart.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTests extends ActionEngine{
	
	@Test
	public void homeLoginTest() throws IOException, InterruptedException
	{
		
		enterUrl(PojoReader.getPrConf().getValue("qa_url"));
		LoginPage.moveToComputersHover();
		Thread.sleep(3000);
		LoginPage.selectPosition();
		//LoginPage.enterUserEmail();
	}
	@Test
	public void testFilpTest() throws IOException
	{
		
		enterUrl(PojoReader.getPrConf().getValue("qa_url_flip"));
		FlipCartPage.searchForMobiles();
		FlipCartPage.selectThirdMobile();
	}
	

}
