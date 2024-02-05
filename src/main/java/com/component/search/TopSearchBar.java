package com.component.search;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TopSearchBar extends AbstractComponent {


    @FindBy(id = "searchval")
    private WebElement topSearchElement;

    public TopSearchBar(WebDriver driver) {
        super(driver);
    }

    public void sendKeys(String keys){
        topSearchElement.sendKeys(keys);
    }


    @Override
    public boolean isDisplayed() {
        return wait.until((d)->topSearchElement.isDisplayed());
    }
}
