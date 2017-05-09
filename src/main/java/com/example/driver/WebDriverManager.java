package com.example.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

public class WebDriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public static WebDriver getDriver() {

		if (driver.get() != null) {
			return driver.get();
		} else
			throw new WebDriverException("Webdriver has not been initialized");
	}

	public static void setWebDriver(WebDriver driver) {

		driver.manage().window().maximize();
		WebDriverManager.driver.set(driver);

	}

	/**
	 * @description gets the sessionID of the driver browser
	 * @return SessionId-the sessionID
	 */
	public static SessionId getSession() {

		return ((RemoteWebDriver) WebDriverManager.getDriver()).getSessionId();

	}

	/**
	 * @description Returns a string containing browser name without its version
	 *              and OS name.
	 * @return String-the browserName
	 */
	public static String getBrowser() {
		Capabilities cap = ((RemoteWebDriver) WebDriverManager.getDriver()).getCapabilities();
		String b = cap.getBrowserName();

		return b;
	}
}