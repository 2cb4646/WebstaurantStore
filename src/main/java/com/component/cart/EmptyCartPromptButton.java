package com.component.cart;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmptyCartPromptButton extends AbstractComponent {

    @FindBy(xpath = "//footer[@data-testid='modal-footer']//button[contains(text(), 'Empty')]")
    private WebElement emptyCartPromptButton;

    public EmptyCartPromptButton(WebDriver driver) {
        super(driver);
    }

    public void click(){
        emptyCartPromptButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return wait.until((d)->emptyCartPromptButton.isDisplayed());
    }
}
