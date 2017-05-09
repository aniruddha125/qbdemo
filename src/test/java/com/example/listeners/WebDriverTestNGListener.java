package com.example.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.example.driver.WebDriverInitializer;
import com.example.driver.WebDriverManager;

public class WebDriverTestNGListener implements IInvokedMethodListener {


	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

		if (method.isTestMethod()) {
			WebDriverInitializer remoteWebDriverInitializer = new WebDriverInitializer();
			remoteWebDriverInitializer.initialize(method);
		}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		if (method.isTestMethod()) {
			WebDriverManager.getDriver().quit();
		}

	}

}