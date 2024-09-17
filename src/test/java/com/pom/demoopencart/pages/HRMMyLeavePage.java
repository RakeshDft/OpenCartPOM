package com.pom.demoopencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.demoopencart.base.ActionEngine;

public class HRMMyLeavePage extends ActionEngine {
	static 
	{
		PageFactory.initElements(getWebDriver(),HRMMyLeavePage.class);
	}
	@FindBy(xpath = "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']")
	private static WebElement MyLeaveclndr;
	public static void clickMyLeaveCalender()
	{
		clickWebElement(MyLeaveclndr, "MyLeave");
	}
	

}
