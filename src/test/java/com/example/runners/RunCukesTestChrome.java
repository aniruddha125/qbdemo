package com.example.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = { "com/example/stepdefinitions" }, features = "src/test/resources/features", tags = {
		"@selenium","~@Ignore" }, plugin = { "pretty", "html:target/html/chrome" })
public class RunCukesTestChrome extends AbstractTestNGCucumberTests {
}
