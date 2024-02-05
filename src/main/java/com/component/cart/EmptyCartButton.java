package com.component.cart;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmptyCartButton extends AbstractComponent {

    @FindBy(xpath = "//button[contains(text(), 'Empty Cart')]")
    private WebElement emptyCartButton;

    public EmptyCartButton(WebDriver driver) {
        super(driver);
    }

    public void click(){
        emptyCartButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->emptyCartButton.isDisplayed());
    }
}
