package com.example.stepdefinitions;

import java.util.List;

import org.testng.Assert;

import com.example.api.APIAutomation;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApiAutomationStepDefs {

	protected List<Integer> result = null;
	protected String exception;



	@When("^Call API with list values: (.*)$")
	public void callAPI(List<Integer> list) {

		APIAutomation apiAutomation = new APIAutomation();
		try {
			result = apiAutomation.getNumbers(list);
		} catch (IllegalArgumentException e) {
			exception = "IllegalArgumentException";

		}
	}

	@Then("^Validate the returned list contains:(.*)$")
	public void validateResult(List<Integer> expected) {

		Assert.assertEquals(result, expected);

	}

	@Then("^Validate Illegal Argument exception occurs$")
	public void validateException() {

		Assert.assertEquals(exception, "IllegalArgumentException");
	}
}
