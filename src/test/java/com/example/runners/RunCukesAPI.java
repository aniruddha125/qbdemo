package com.example.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(glue = { "com/example/stepdefinitions" }, features = "src/test/resources/features", tags = {
		"@api","~@Ignore" }, plugin = { "pretty", "html:target/html/api" })
public class RunCukesAPI extends AbstractTestNGCucumberTests {
}
