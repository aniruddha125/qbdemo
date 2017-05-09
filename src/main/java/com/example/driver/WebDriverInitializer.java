package com.example.driver;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;

public class WebDriverInitializer {

	public void initialize(Object... arg0) {

		IInvokedMethod method = (IInvokedMethod) arg0[0];
		String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");

		WebDriver driver = WebDriverFactory.createInstance(browserName);
		WebDriverManager.setWebDriver(driver);
	}
}