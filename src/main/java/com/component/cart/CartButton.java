package com.component.cart;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartButton extends AbstractComponent {

    @FindBy(xpath = "//a[@data-testid='cart-button']")
    private WebElement cartButton;

    public CartButton(WebDriver driver) {
        super(driver);
    }

    public void click(){
        cartButton.click();
    }

    public WebElement returnCartButton(){
        return cartButton;
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->cartButton.isDisplayed());
    }
}
