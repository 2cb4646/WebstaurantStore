package com.base;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface AutomatedBrowser {

    WebDriver getWebDriver();

    void setWebDriver(WebDriver webDriver);

    void init() throws MalformedURLException;

    void destroy();

    void goTo(String urlToNavigateTo);

    void goToSleep(long timeToSleep);

    void snapshot(String filename);




}
