package com.pom.demoopencart.updatedages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.demoopencart.base.ActionEngine;
import com.pom.demoopencart.utilities.PojoReader;

public class ProductPage extends ActionEngine{
	static
	{
		PageFactory.initElements(getWebDriver(), SearchProductPage.class);
	}
	@FindBy(xpath="//li//a[text()='Description']")
	private static WebElement DescriptionP;

	
	public static void validateDescription() throws EncryptedDocumentException, IOException
	{
	String actualDescription=DescriptionP.getText();
	System.out.println("the description is "+actualDescription);
	String expectedDescription=PojoReader.getExcelObj().getCellData("sheetname","Sheet3", 4, 1);
	Assert.assertEquals(actualDescription, expectedDescription);
	}
	

}
