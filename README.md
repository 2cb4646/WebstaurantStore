# WebstaurantStore-Code-Screen-Task


----------------------------------

A Selenium based automation project used to support testing of WebstaurantStore applications.

----------------------------------


## Introduction

This project uses [Selenium Webdriver](https://www.selenium.dev/) to simulate user interactions with a browser and
[TestNG](https://testng.org/doc/documentation-main.html) to execute individual tests. This project leverages the concepts of [Single Responsibility Principle](https://www.udemy.com/selenium-webdriver-and-design-patterns/learn/lecture/17920332#overview)
and [Page Object Model](https://www.selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models) to help encapsulate browser
interactions and reduce test brittleness.

This project could also easily be developed to configurably use [Docker](https://www.docker.com/) and the [Selenium Grid](https://github.com/SeleniumHQ/docker-selenium) to provide further test infrastructure capabilities
but does not at this time for demonstration purposes.

----------------------------------

## Dependencies
This project uses [JDK 17](https://www.oracle.com/java/technologies/downloads/) and [Maven 3.3 or newer](https://maven.apache.org/).

Developers are encouraged to use [IntelliJ](https://www.jetbrains.com/idea/).
----------------------------------

## Executing Tests


1. Clone the repository:
   ```html
   git clone https://github.com/2cb4646/WebstaurantStore-Code-Screen-Task.git
   ```

2.  
Run suite file and or test in IDE.

-or-

Build project
```html
Navigate to project in command prompt.
```

```html
mvn clean package -DskipTests
```

```html
java -cp target/webstaurantstore.jar;target/webstaurantstore-tests.jar;target/libs/* org.testng.TestNG suites/webstaurantStoreSuite.xml
```


