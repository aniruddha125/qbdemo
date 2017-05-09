package com.example.stepdefinitions;

import java.util.List;

import org.testng.Assert;
import org.testng.TestNGException;

import com.example.driver.WebDriverManager;
import com.example.dto.AssertDTO;
import com.example.pageobjects.WebDriverAPIPage;
import com.example.pageobjects.WebDriverHomePage;
import com.example.utlities.Utility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebDriverIOStepDefs {

	protected WebDriverHomePage webDriverHomePage;
	protected WebDriverAPIPage webDriverAPIPage;

	@Given("^launch application with url \"([^\"]*)\"$")
	public void launchApplication(String url) throws Throwable {

		WebDriverManager.getDriver().navigate().to(url);
	}


	@Given("^Navigate to API link in the top navigation bar$")
	public void navigateToApiDocs() {

		webDriverHomePage = new WebDriverHomePage(WebDriverManager.getDriver());
		webDriverAPIPage = webDriverHomePage.clickApi();

	}

	@When("^Search API for text ([^\"]*)$")
	public void searchApiDocs(String searchText) throws TestNGException {

		webDriverAPIPage.search(searchText);
	}

	@Then("^List of link names returned in the left nav section$")
	public void getApiNavBarLinkNames() throws TestNGException {

		webDriverAPIPage.getApiNavBarLinkNames();
	}

	@Then("^Verify that the following action results are returned$")
	public void validateApiActionNavBarLinkNames(List<AssertDTO> expectedParameters) throws TestNGException {

		List<String> actualResults = webDriverAPIPage.getActionApiNavBarLinkNames();

		for(AssertDTO expectedParameter:expectedParameters){

			Assert.assertEquals(actualResults.size(), expectedParameter.getNumberOfLinks());
			Assert.assertEquals(actualResults, Utility.getList(expectedParameter.getListOfLinks(), ","));
		}
	}
}
