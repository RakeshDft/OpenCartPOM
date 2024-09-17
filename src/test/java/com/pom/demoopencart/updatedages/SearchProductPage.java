package com.pom.demoopencart.updatedages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.demoopencart.base.ActionEngine;
import com.pom.demoopencart.utilities.PojoReader;

public class SearchProductPage extends ActionEngine{

	static
	{
		PageFactory.initElements(getWebDriver(), SearchProductPage.class);
	}
	@FindBys({@FindBy(xpath="//div[@class='product-thumb']")})
	private static List<WebElement> productList;
	
	@FindBy(xpath="//h1[text()='MacBook Air']")
	private static WebElement MacBookHeader;
	
	public static void getProducts()
	{
		for(WebElement webElement:productList)
		{
			if(webElement.getText().contains("Air"))
				//System.out.println("the text is "+webElement.getText());
			 {
				clickWebElement(webElement, "Mac");
				
				 break;
			 }
			
		}
					
	}
	public static void verifyHeaderMackBook() throws EncryptedDocumentException, IOException
	{
		String expectedHeader=PojoReader.getExcelObj().getCellData("sheetname","Sheet3", 5, 1);
		String actualHeader=MacBookHeader.getText();
		System.out.println("actualHeader "+actualHeader);
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	

	
	
	

}
