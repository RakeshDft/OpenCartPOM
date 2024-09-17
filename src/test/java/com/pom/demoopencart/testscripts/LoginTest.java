package com.pom.demoopencart.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pom.demoopencart.base.ActionEngine;

import com.pom.demoopencart.updatedages.LoginPage;
import com.pom.demoopencart.updatedages.OpenCartHeadersPage;
import com.pom.demoopencart.utilities.PojoReader;

public class LoginTest extends ActionEngine{
	
	
	@Test
	public void testOpenCart() throws IOException, InterruptedException
	{enterUrl(PojoReader.getPrConf().getValue("qa_opencart_url"));
	Thread.sleep(5000);
	OpenCartHeadersPage.validateTitle();
	OpenCartHeadersPage.mouseHoverLaptopNotebookLink();
	OpenCartHeadersPage.validateLaptopNoteBookSize();
		
	}
	@Test
	public void verifyHeaders() throws IOException, InterruptedException
	{
		enterUrl(PojoReader.getPrConf().getValue("qa_opencart_url"));
		Thread.sleep(5000);
		OpenCartHeadersPage.validateTitle();
		OpenCartHeadersPage.verifyHeaders();
		
		
	}

}
