package com.pom.demoopencart.pages;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pom.demoopencart.base.ActionEngine;

public class FlipCartPage extends ActionEngine {
	static
	{
		PageFactory.initElements(getWebDriver(),FlipCartPage.class);
	}
@FindBy(xpath ="//input[@placeholder='Search for Products, Brands and More']")
private static WebElement searchBox;

@FindBy(xpath="//div[contains(text(),'oppo mobile 5g')]")
private static WebElement Oppomobiles;
@FindBy(xpath="//div[@class='yPq5Io']//div//div//img")
private static WebElement ThirdSearchMobile;
@FindBy(xpath="//button[text()='Buy Now']")
private static WebElement AddToCart;

public static void searchForMobiles()
{
	enterData("mobiles",searchBox,"Search");
	clickWebElement(Oppomobiles, "Oppomobiles");
}public static void selectThirdMobile()
{
	String parentWindowHandle = getWebDriver().getWindowHandle();
	System.out.println("current window  "+parentWindowHandle);

	clickWebElementActions(ThirdSearchMobile, "thirdMobile");

	// Get the window handles of all the windows that are currently open
	Set<String> allWindowHandles = getWebDriver().getWindowHandles();

	// Loop through the window handles to find the handle of the new window
	for (String windowHandle : allWindowHandles) {
	    if (!windowHandle.equals(parentWindowHandle)) {
	    	getWebDriver().switchTo().window(windowHandle);
	    	System.out.println("child window  "+windowHandle);
	        break;
	    }
	    getWebDriver().switchTo().window(parentWindowHandle);
	}

	// Now we are in the child window, do some actions
	// ...
	clickWebElementActions(AddToCart,"AddToCart");
	// Switch back to the parent window
	getWebDriver().switchTo().window(parentWindowHandle);
	
}
	
}


