package com.example.stepdefinitions.hooks;

import java.sql.DriverManager;

import org.openqa.selenium.WebDriver;

import com.example.driver.WebDriverFactory;
import com.example.driver.WebDriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class BeforeHook {

	@Before
	public void initialize(Scenario scenario) {


		System.out.println(WebDriverManager.getSession());
		System.out.println(WebDriverManager.getBrowser());

		if (WebDriverManager.getSession()==null) {
			String browser = WebDriverManager.getBrowser();

			WebDriver driver = WebDriverFactory.createInstance(browser);
			WebDriverManager.setWebDriver(driver);

		}
	}
}
