package com.base.decoratorbase;

import com.base.AutomatedBrowser;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class AutomatedBrowserBase implements AutomatedBrowser {


    private AutomatedBrowser automatedBrowser;

    public AutomatedBrowserBase(){}

    public AutomatedBrowserBase(AutomatedBrowser automatedBrowser){this.automatedBrowser = automatedBrowser;}

    public AutomatedBrowser getAutomatedBrowser(){return automatedBrowser;}



    @Override
    public WebDriver getWebDriver() {
        if(null != getAutomatedBrowser()){
            return getAutomatedBrowser().getWebDriver();
        }
        return null;
    }

    @Override
    public void setWebDriver(WebDriver webDriver) {
        if(null != getAutomatedBrowser()){
            getAutomatedBrowser().setWebDriver(webDriver);
        }
    }

    @Override
    public void init() throws MalformedURLException {
        if(null != getAutomatedBrowser()){
            getAutomatedBrowser().init();
        }
    }

    @Override
    public void destroy() {
        if(null != getAutomatedBrowser()){
            getAutomatedBrowser().destroy();
        }
    }

    @Override
    public void goTo(String urlToNavigateTo) {
        if(null != getAutomatedBrowser()){
            getAutomatedBrowser().goTo(urlToNavigateTo);
        }
    }

    @Override
    public void goToSleep(long timeToSleep) {
        if(null != getAutomatedBrowser()){
            getAutomatedBrowser().goToSleep(timeToSleep);
        }
    }

    @Override
    public void snapshot(String filename) {
        if(null != getAutomatedBrowser()){
            getAutomatedBrowser().snapshot(filename);
        }
    }
}
