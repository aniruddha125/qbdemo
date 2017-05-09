package com.example.stepdefinitions.hooks;

import org.openqa.selenium.WebDriver;

import com.example.driver.WebDriverFactory;
import com.example.driver.WebDriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class BeforeHook {

	@Before
	public void initialize(Scenario scenario) {

		if (WebDriverManager.getSession()==null) {
			String browser = WebDriverManager.getBrowser();

			WebDriver driver = WebDriverFactory.createInstance(browser);
			WebDriverManager.setWebDriver(driver);

		}
	}
}
