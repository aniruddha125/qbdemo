package com.example.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utlities.Utility;

public class WebDriverHomePage {

	private WebDriver driver;

	@FindBy(linkText = "API")
	private WebElement api;

	// fill in other elements of the page as needed.

	public WebDriverHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Utility.waitforTitle(driver, "WebdriverIO - WebDriver bindings for Node.js");

	}

	public WebDriverAPIPage clickApi() {

		api.click();

		return PageFactory.initElements(driver, WebDriverAPIPage.class);
	}

}