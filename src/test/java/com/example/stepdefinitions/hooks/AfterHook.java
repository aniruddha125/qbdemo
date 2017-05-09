package com.example.stepdefinitions.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.example.driver.WebDriverManager;

import cucumber.api.Scenario;
import cucumber.api.java.After;

public class AfterHook {

	@After
	public void teardown(Scenario scenario) {

		if (scenario.isFailed()) {
			embedScreenshot(scenario);
		}
		if (WebDriverManager.getDriver() != null) {
			WebDriverManager.getDriver().quit();
		}
	}

	/**
	 * @description Embed a screenshot in test report if test is marked as
	 *              failed
	 */
	public void embedScreenshot(Scenario scenario) {

			scenario.write("Current Page URL is: " + WebDriverManager.getDriver().getCurrentUrl());

			try {
				byte[] screenshot = ((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.out.println(somePlatformsDontSupportScreenshots.getMessage());
			}

	}
}
