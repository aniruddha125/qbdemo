@selenium
Feature: WebDriverIO test

  1. Navigate to WebDriverIO website
  2. Click on API link in the top naviation bar
  3. Search for "click" and other paramaeters in the API Docs.
  4. Validate that in the left navigation pane all returned links are displayed
  5. Validate in the left navigation Action pane all relevant links are returned.

  Scenario Outline: Test Search functionality of WebDriverIO/Api link
    Given launch application with url "http://webdriver.io"
    When Navigate to API link in the top navigation bar
    And Search API for text <text>
    Then List of link names returned in the left nav section
    And Verify that the following action results are returned
      | numberOfLinks   | listOfLinks   |
      | <numberOfLinks> | <listOfLinks> |

    Examples:
      | text   | numberOfLinks | listOfLinks                                                                                             |  |
      | click  |             5 | click, doubleClick, leftClick, middleClick, rightClick                                                  |  |
      | submit |             1 | submitForm                                                                                              |  |
      | select |             6 | selectByAttribute,selectByIndex ,selectByValue,selectByVisibleText,selectorExecute,selectorExecuteAsync |  |
      | clear  |             1 | clearElement                                                                                              |  |


