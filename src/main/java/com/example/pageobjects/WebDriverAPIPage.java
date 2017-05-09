package com.example.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.example.utlities.Utility;

public class WebDriverAPIPage {

	private WebDriver driver;

	@FindBy(name = "search")
	private WebElement searchBox;

	@FindBy(className = "apinav")
	private WebElement apiNavigation;

	@FindBy(css = "div.commands.action.active")
	private WebElement actionNavigation;

	// fill in other elements of the page as needed.

	public WebDriverAPIPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Utility.waitforTitle(driver, "WebdriverIO - API Docs");

	}

	public void search(String searchText) {
		searchBox.clear();
		searchBox.sendKeys(searchText);
	}

	public List<String> getApiNavBarLinkNames() {

		return getLinks(apiNavigation);
	}

	public List<String> getActionApiNavBarLinkNames() {

		return getLinks(actionNavigation);
	}

	/**
	 * @param linkNames
	 */
	public List<String> getLinks(WebElement element) {
		List<String> linkNames = new ArrayList<String>();

		for (WebElement e : element.findElements(By.tagName("a"))) {
			if (e.isDisplayed()) {

				System.out.println(e.getText());
				linkNames.add(e.getText());
			}
		}
		System.out.println();
		return linkNames;
	}

}