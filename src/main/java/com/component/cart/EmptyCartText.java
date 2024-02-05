package com.component.cart;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmptyCartText extends AbstractComponent {

    @FindBy(xpath = "//p[contains(text(),'Your cart is empty.')]")
    private WebElement emptyCartText;

    public EmptyCartText(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->emptyCartText.isDisplayed());
    }
}
