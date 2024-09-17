package com.pom.demoopencart.testscripts;

import java.io.IOException;


import org.testng.annotations.Test;

import com.pom.demoopencart.base.ActionEngine;
import com.pom.demoopencart.updatedages.OpenCartHeadersPage;
import com.pom.demoopencart.updatedages.ProductPage;
import com.pom.demoopencart.updatedages.SearchProductPage;
import com.pom.demoopencart.utilities.PojoReader;

public class ProductEndToEndFlowTest extends ActionEngine{
	
	
	@Test
	public void testProductEndFlow() throws IOException, InterruptedException
	{
		enterUrl(PojoReader.getPrConf().getValue("qa_opencart_url"));
		
		OpenCartHeadersPage.validateTitle();
		OpenCartHeadersPage.enterProductNameinSearchBox();
		OpenCartHeadersPage.clickMagnifier();
		OpenCartHeadersPage.validateTitleOfSearchOnr();
		SearchProductPage.getProducts();
		SearchProductPage.verifyHeaderMackBook();
		//ProductPage.validateDescription();
		
		Thread.sleep(4000);
	}

}
