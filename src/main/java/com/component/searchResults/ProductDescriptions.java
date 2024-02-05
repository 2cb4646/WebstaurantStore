package com.component.searchResults;

import com.component.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDescriptions extends AbstractComponent {


    @FindBy(xpath = "//span[@data-testid='itemDescription']")
    private List<WebElement> itemDescriptions;



    public ProductDescriptions(WebDriver driver) {
        super(driver);

    }

    public List<WebElement> getItemDescriptions() {
        return itemDescriptions;
    }

    @Override
    public boolean isDisplayed() {
        // Adjust the isDisplayed method to check if at least one item description is displayed
        return wait.until((d)->itemDescriptions.size()>0);
    }
}
