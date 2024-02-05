package com.base;


import com.base.configuration.WebstaurantConfig;
import com.base.listener.ApplicationListener;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners(ApplicationListener.class)
public class BaseTest {


    protected WebstaurantConfig config;
    protected AutomatedBrowser automatedBrowser;
    private static final AutomatedBrowserFactory AUTOMATED_BROWSER_FACTORY = new AutomatedBrowserFactory();
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest
    public void setup() throws MalformedURLException {

        this.config = ConfigFactory.create(WebstaurantConfig.class, System.getenv(),System.getProperties());
        Assert.assertNotNull(config);


        System.setProperty("runHeadless", config.runHeadless());

        if(config.browser().equalsIgnoreCase("chrome")){
            automatedBrowser = AUTOMATED_BROWSER_FACTORY.getAutomatedBrowser("chrome");
        }

        automatedBrowser.init();
    }

    @AfterTest(alwaysRun = true)
    public void teardown(){
        if(null != automatedBrowser.getWebDriver()){
            automatedBrowser.getWebDriver().quit();
        }
    }




    public void scrollToElementAndClick(WebElement element) {
        ((JavascriptExecutor) automatedBrowser.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500); //small pause
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Interrupted while waiting for element to scroll into view", e);
        }

        new Actions(automatedBrowser.getWebDriver()).moveToElement(element).click().perform();
    }


    public static void scrollWorker(WebDriver driver, String command){
        if(command.equalsIgnoreCase("top")){
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollTo(0, 0)");
        }

        if(command.equalsIgnoreCase("bottom")){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
    }

    public void pressEnter(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.sendKeys(org.openqa.selenium.Keys.ENTER).perform();
    }




}
