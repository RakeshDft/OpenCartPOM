package com.pom.demoopencart.updatedages;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.pom.demoopencart.base.ActionEngine;
import com.pom.demoopencart.utilities.PojoReader;
import com.relevantcodes.extentreports.LogStatus;

public class OpenCartHeadersPage extends ActionEngine{

	static
	{
		PageFactory.initElements(getWebDriver(), OpenCartHeadersPage.class);
	}
	@FindBys({@FindBy(xpath="//ul[@class='nav navbar-nav']/li/a")})
	private static List<WebElement> headersList;
	
	@FindBy(xpath="//a[text()='Laptops & Notebooks']")
	 private static WebElement Laptops_Notebooks;
	 
	  @FindBy(xpath = "//a[contains(text(),'Show All Laptops')]") private static
	  WebElement ShowAllLaptops_Notebooks;
	  @FindBy(xpath="//div[@class='list-group mb-3']/a[2]")
	  private static WebElement actualLaptopsNoteBooksSize;
	  
	  @FindBys({@FindBy(xpath="//div[@class='image']")})
	  private static List<WebElement> expectedLaptopNoteBooks;
	  
	  @FindBy(xpath = "//input[@name='search']")
	  private static WebElement searchBox;
	  @FindBy(xpath="//i[@class='fa-solid fa-magnifying-glass']")
	  private static WebElement SearchMagnifier;
	 
	  public static void mouseHoverLaptopNotebookLink() {
	  moveWebElementActions(Laptops_Notebooks,"Laptops&Notebooks");
	  
	  clickWebElement(ShowAllLaptops_Notebooks, "showLaptops"); 
	  }
	  
	  public static int getActualLaptopNteBooksize()
	  {
		String actualSize=getTextWebElement(actualLaptopsNoteBooksSize); 
		String[] str=actualSize.split(" ");
		String str1=str[3];
		String[] str2=str1.split("");
		int actualsize1=Integer.parseInt(str2[1]);
		return actualsize1;
	  }
	  public static int getExpectedLaptopNoteBookSize()
	  {
		 int expSize=expectedLaptopNoteBooks.size();
		 return expSize;
	  }
	  public static void validateLaptopNoteBookSize()
	  {
		 int actualSize=getActualLaptopNteBooksize();
		 int expectedSize=getExpectedLaptopNoteBookSize();
		 if(actualSize==expectedSize)
		 {
			 getExtentTest().log(LogStatus.PASS,"Laptops & notebooks size is matching: "+ actualSize+" = "+expectedSize);
			 
		 }
		 else
		 {
			 getExtentTest().log(LogStatus.FAIL,"Laptops & notebooks size is not matching: "+ actualSize+" = "+expectedSize);

		 }
	  }
	public static List<String> getActualHeaders()
	{
		List<String>headersTxt=new ArrayList<String>();
		for(WebElement webElement:headersList)
		{
			String header=webElement.getText();
			headersTxt.add(header);
		}
		return headersTxt;
	}
	public static List<String> getExpectedHeaders() throws EncryptedDocumentException, IOException
	{
	List<String>headersTxt=new ArrayList<String>();
	String data=PojoReader.getExcelObj().getCellData("sheetname","Sheet3", 1, 0);
	String[] str=data.split(",");
	for(String str1:str)
	{
		headersTxt.add(str1);
	}
	return headersTxt;
	}
	
	public static void verifyHeaders() throws EncryptedDocumentException, IOException
	{
		List<String>actualHeaders=getActualHeaders();
		List<String> expectedHeaders=getExpectedHeaders();
		Collections.sort(actualHeaders);
		System.out.println(actualHeaders);
		Collections.sort(expectedHeaders);
		System.out.println(expectedHeaders);
		if((actualHeaders==expectedHeaders)) {
			getExtentTest().log(LogStatus.PASS,"Headers are matching: "+actualHeaders+" :"+expectedHeaders);
		Assert.assertEquals(actualHeaders, expectedHeaders);
		
		}
		
		/*
		 * if((expectedHeaders==actualHeaders)) {
		 * getExtentTest().log(LogStatus.PASS,"Headers are matching: "
		 * +actualHeaders+" :"+expectedHeaders); }
		 * 
		 * else { getExtentTest().log(LogStatus.FAIL,"Headers are NOT... matching: "
		 * +actualHeaders+" :"+expectedHeaders); }
		 */
	
	}
	public static void validateTitle() throws EncryptedDocumentException, IOException
	{
		String actualTitle=getWebDriver().getTitle();
		String title=PojoReader.getExcelObj().getCellData("sheetname","Sheet3", 2, 1);
		if(actualTitle.equalsIgnoreCase(title))
		{
			getExtentTest().log(LogStatus.PASS,"Title is same as expected:"+  actualTitle);
		}
		else
		{
			getExtentTest().log(LogStatus.FAIL,"Title is not sameas expected:"+  actualTitle);
		}
	}
	public static void validateTitleOfSearchOnr() throws EncryptedDocumentException, IOException
	{
		String actualTitle=getWebDriver().getTitle();
		String TitleOfSearch=PojoReader.getExcelObj().getCellData("sheetname","Sheet3", 3, 1);
		if(actualTitle.equalsIgnoreCase(TitleOfSearch))
		{
			getExtentTest().log(LogStatus.PASS,"Title is same as expected:"+  actualTitle);
		}
		else
		{
			getExtentTest().log(LogStatus.FAIL,"Title is not sameas expected:"+  actualTitle);
		}
	}
	public static void enterProductNameinSearchBox()
	{
		enterData("MacBook",searchBox,"Search");
	}
	public static void clickMagnifier()
	{
		//clickWebElement(SearchMagnifier, "Magnifer");
		clickWebElementActions(SearchMagnifier, "Magnifier");
		
	}
	
}
