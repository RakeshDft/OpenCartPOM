package com.pom.demoopencart.updatedages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.demoopencart.base.ActionEngine;


public class LoginPage extends ActionEngine {
	//static bloack used to load the .class file when JVM loads.
	static
	{
		PageFactory.initElements(getWebDriver(),LoginPage.class);
	}
	
	//Identifing Laptops_Notebooks link xpath on Homepage.and stored in Laptops_Notebooks webElement
	
	 
		
	@FindBy(xpath = "//a[contains(text(),'Computers')]")
	private static WebElement computerHover;
	@FindBy(xpath="//a[contains(text(),'Notebooks')]")
	private static WebElement NOtebooks;
	@FindBy(xpath="//select[@id='products-orderby']")
	private static WebElement SelectPosition;
	
	public static void moveToComputersHover() {
		moveWebElementActions(computerHover,"computerHover");
		clickWebElement(NOtebooks, "NoteBooksHover");
		//DTA("email", loginLink, "usermail");
	}
	public static void selectPosition()
	{
		habdleDropDowns(SelectPosition, "position", "text", "Created on");
	}

	 

}
