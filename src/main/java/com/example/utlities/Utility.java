package com.example.utlities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	private static final int EXPLICIT_TIMEOUT=10; // hardcoding the explicit timeout to 10 seconds.

	/**
	 * @param driver
	 * @param expectedTitle
	 * @description explicit wait for page title to load
	 */
	public static void waitforTitle(WebDriver driver, String expectedTitle) {

			WebDriverWait wait = new WebDriverWait(driver,EXPLICIT_TIMEOUT);
			wait.until(ExpectedConditions.titleContains(expectedTitle));
	}

	/**
	 * @param data
	 * @param regex
	 * @return list of Strings
	 * @description takes in a string and converts it to a List of strings
	 */
	public static List<String> getList(String data, String regex){
		String[] strinArr=data.split(regex);

		for (int i = 0; i < strinArr.length; i++)
			strinArr[i] = strinArr[i].trim();

		return new ArrayList<>(Arrays.asList(strinArr));
	}


}
