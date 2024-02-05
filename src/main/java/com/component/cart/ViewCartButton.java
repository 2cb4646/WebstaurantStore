package com.component.cart;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartButton extends AbstractComponent {


    @FindBy(xpath = "//a[@href='/viewcart.cfm' and text()='View Cart']")
    private WebElement viewCartButton;

    public ViewCartButton(WebDriver driver) {
        super(driver);
    }

    public void click(){
        viewCartButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->viewCartButton.isDisplayed());
    }
}
