@api
Feature: API Automation test

  1. Call API to return highest two numbers from a given list
  2. Validate the data returned in the list is correct
  3. Validate that when  a List with lesst han 2 numbers are provided to the API an exception is thrown

  Scenario: Validate Api
    When Call API with list values: 5, 100, 10, 125, 15, 150, 20, 175, 25, 0
    Then Validate the returned list contains:175,150
    When Call API with list values: 25, 93, 97, 18, 71, 114, 52, 48
    Then Validate the returned list contains:114,97
    When Call API with list values: 5
    Then Validate Illegal Argument exception occurs
