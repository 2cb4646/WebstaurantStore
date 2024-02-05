package com.component.searchResults;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/*
Have a few questions on the method of aquiring the last selected item.
for demonstration purposes, we will use NineElement as an abstraction.
 */
public class NineElement extends AbstractComponent {

    @FindBy(xpath = "//a[contains(@aria-label, 'last page, page 9')]")
    private WebElement nineButton;


    public NineElement(WebDriver driver) {
        super(driver);
    }

    public void click(){
        nineButton.click();
    }

    public WebElement returnNineElememnt(){
        return nineButton;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)-> nineButton.isDisplayed());
    }
}
