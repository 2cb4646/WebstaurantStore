package com.base;

import com.base.decorator.ChromeDecorator;
import com.base.decorator.WebDriverDecorator;

public class AutomatedBrowserFactory {



    //this could take browser version, runRemote, runProxy etc.   for simplicity at this stage, only latest chrome browser
    public AutomatedBrowser getAutomatedBrowser(final String browser){

        if("Chrome".equalsIgnoreCase(browser)){
            return getChromeBrowser();
        }

        throw new IllegalArgumentException("Unknown browser: " + browser);

    }


    private AutomatedBrowser getChromeBrowser(){
        return new ChromeDecorator(
                new WebDriverDecorator()
        );
    }



}
