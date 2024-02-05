package com.base.decorator;

import com.base.decoratorbase.AutomatedBrowserBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebDriverDecorator extends AutomatedBrowserBase {

    private WebDriver driver;

    public static final Logger LOGGER = LoggerFactory.getLogger(WebDriverDecorator.class);


    public WebDriverDecorator(){}

    @Override
    public WebDriver getWebDriver(){return driver;}

    @Override
    public void setWebDriver(final WebDriver driver){this.driver = driver;}

    @Override
    public void destroy(){
        if(null != driver){
            driver.quit();
        }
    }

    @Override
    public void goTo(final String url){driver.get(url);}

    @Override
    public void goToSleep(long timeToSleep){
        try{
            Thread.sleep(timeToSleep);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void snapshot(final String filePath){
        String fileTime = null;
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MM_dd_yyyy_hh_mm_ss_SSS_a");

        LocalDateTime localDateTime = LocalDateTime.now();

        fileTime = FORMATTER.format(localDateTime);

        File srcFile = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);

        try{
            String path = System.getProperty("user.dir");
            String proper = path.replace("\\","/");
            String properPath = proper+"/target/screenshots/"+filePath+"_"+fileTime+".png";
            LOGGER.info("The filePath for image:     " + properPath);
            FileUtils.copyFile(srcFile, new File(properPath));
            LOGGER.info("Finished snapshot image.");
        }catch (IOException e){
            LOGGER.warn("Error in snapshot. \n" + e );
        }
    }

}
