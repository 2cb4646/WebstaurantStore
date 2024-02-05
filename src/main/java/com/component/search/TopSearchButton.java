package com.component.search;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopSearchButton extends AbstractComponent {

    @FindBy(xpath = "//button[@value='Search']")
    private WebElement searchButton;


    public TopSearchButton(WebDriver driver) {
        super(driver);
    }

    public void click(){searchButton.click();}

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->searchButton.isDisplayed());
    }
}
