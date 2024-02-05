package com.base.decorator;

import com.base.AutomatedBrowser;
import com.base.decoratorbase.AutomatedBrowserBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChromeDecorator extends AutomatedBrowserBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChromeDecorator.class);



    public ChromeDecorator(final AutomatedBrowser automatedBrowser){
        super(automatedBrowser);
    }


    @Override
    public void init() throws MalformedURLException{
        LOGGER.debug("Creating new Chromedriver ....");
        System.setProperty("webdrivermanager.traceLevel", "TRACE");

        //WebDriverManager.chromedriver().setup();

        //if above regular setup fails, use this line to specify version target
        //https://googlechromelabs.github.io/chrome-for-testing/
        WebDriverManager.chromedriver().driverVersion("121.0.6167.85").setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        options.setExperimentalOption("prefs",prefs);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.addArguments("--disable-useAutomationExtension");
        options.addArguments("--disable-extensions");

        if(null != System.getProperty("runHeadless")){
            if(System.getProperty("runHeadless").equalsIgnoreCase("false")){
                LOGGER.info("Headless Driver instance turned OFF.");
            }else{
                options.addArguments("--headless");
                LOGGER.info("Running headless driver instance.");
            }
        }else{
            options.addArguments("--headless");
            LOGGER.info("Running headless driver instance.");
        }

        final ChromeDriver driver = new ChromeDriver(options);


        getAutomatedBrowser().setWebDriver(driver);
        getAutomatedBrowser().init();



    }


}
