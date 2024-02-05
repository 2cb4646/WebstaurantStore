package com.component.searchResults;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddToCart extends AbstractComponent {
    // Assuming the Add to Cart buttons can be uniquely identified like this
    @FindBy(xpath = "//input[@data-testid='itemAddCart']")
    private List<WebElement> addToCartButtons;

    public AddToCart(WebDriver driver) {
        super(driver);
    }


    // Method to click the Add to Cart button for the last item
    public void addLastItemToCart() {
        if (!addToCartButtons.isEmpty()) {
            WebElement lastAddToCartButton = addToCartButtons.get(addToCartButtons.size() - 1);
            lastAddToCartButton.click();
        }
    }


    @Override
    public boolean isDisplayed() {
        return wait.until((d)->addToCartButtons.size()>0);
    }
}
