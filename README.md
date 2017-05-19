## QB Coding Exercise

This is a maven project and can be imported into Eclipse/STS as an existing maven project

Tested with firefox 38 and webdriver v 2.46.
Tested with chrome 58 and webdriver v 2.46.

Should be good to run on any webdriver version before version 3.x.

### Execution

- Command to run on firefox:- 
``` 
mvn clean install 
```
Chrome test cases if enabled in the TestNG xml file will fail with this maven command.

- Command to run on chrome :- 

```
mvn clean install -DchromeDriver="/path/to/chrome/driver/chromedriver"
```

By default chrome tests are enabled in "TestNGRunWebdriverTests.xml".
Just enable the firefox tests to run it in firefox.

- Command to run all webdriver tests with both firefox and chrome tests enabled in "TestNGRunWebdriverTests.xml":-
```
mvn clean install -Pui-tests -DchromeDriver="/path/to/chrome/driver/chromedriver"
```

- Command to run api tests :- 
```
mvn clean install -Papi-tests
```

### Assumptions
- Test are not meant to be run on Selenium grid.
- RemoteWebDriver was not used and no reporting structure was setup.
- Only browsers coded for were chrome and firefox. The structure should support an easy addition of other browsers.

### Description of test
Tested the search functionality of webdriver.io/api link. In addition to "click" also tested for "submit" , "select" and "clear".

### Language used
tests were automated using cucumber-java.
Feature file "WebDrivverIOTest.feature" for test is located at "src/test/resources/features"
Glue code is at src/test/java/com/example/stepdefinitions.

### Contact
Please send an email to aniruddhach125@gmail.com for any further queries.
