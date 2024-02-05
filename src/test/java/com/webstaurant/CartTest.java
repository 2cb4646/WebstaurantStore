package com.webstaurant;

import com.base.BaseTest;
import com.page.CartPage;
import com.page.ResultsPage;
import com.page.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    private SearchPage searchPage;
    private ResultsPage resultsPage;
    private CartPage cartPage;

    @BeforeTest
    public void setupPages(){
        this.searchPage = new SearchPage(automatedBrowser);
        this.resultsPage = new ResultsPage(automatedBrowser);
        this.cartPage = new CartPage(automatedBrowser);
    }

    @Test(priority = 1,description = "Navigate to proper url.")
    public void NavigateToPage(){
        automatedBrowser.goTo(config.navigationURL());
    }

    @Test(priority =2, description = "Perform search for term.",dependsOnMethods = "NavigateToPage")
    public void EnterSearchTerm(){
        Assert.assertTrue(searchPage.getTopSearchBar().isDisplayed());
        searchPage.getTopSearchBar().sendKeys(config.searchTerm());
    }

    @Test(priority =3, description = "Click search icon.",dependsOnMethods = "EnterSearchTerm")
    public void ClickSearchIcon(){
        Assert.assertTrue(searchPage.getTopSearchButton().isDisplayed());
        searchPage.getTopSearchButton().click();
    }

    @Test(priority =4, description = "Assert that each product title contains the word 'Table'",dependsOnMethods = "ClickSearchIcon")
    public void ConfirmSearchResults(){
        Assert.assertTrue(resultsPage.getProductDescriptions().isDisplayed());


        for (WebElement title : resultsPage.getProductDescriptions().getItemDescriptions()) {
            Assert.assertTrue(title.getText().contains("Table"), "Product title does not contain 'Table': " + title.getText());
        }
    }

    @Test(priority = 5, description = "Take user action to click to last page.", dependsOnMethods = "ConfirmSearchResults")
    public void ClickToLastPage(){
        scrollToElementAndClick(resultsPage.getNineElement().returnNineElememnt());
    }

    @Test(priority= 6, description = "Click last add to carton button.",dependsOnMethods = "ConfirmSearchResults")
    public void ClickLastAddToCartButton(){
        Assert.assertTrue(resultsPage.getAddToCart().isDisplayed());
        resultsPage.getAddToCart().addLastItemToCart();
    }

    @Test(priority = 7, description = "Click view cart button.",dependsOnMethods = "ClickLastAddToCartButton")
    public void ClickViewCartButton(){
        Assert.assertTrue(cartPage.getViewCartButton().isDisplayed());
        cartPage.getViewCartButton().click();
    }

    @Test(priority = 8, description = "Empty user cart.",dependsOnMethods = "ClickViewCartButton")
    public void EmptyCart(){
        Assert.assertTrue(cartPage.getEmptyCartButton().isDisplayed());
        cartPage.getEmptyCartButton().click();
        automatedBrowser.goToSleep(450);
        automatedBrowser.snapshot("Empty Cart Prompt Snapshot"); //proof of what is in cart
        Assert.assertTrue(cartPage.getEmptyCartPromptButton().isDisplayed());
        cartPage.getEmptyCartPromptButton().click();
    }

    @Test(priority = 9, description = "Confirm user cart is empty.",dependsOnMethods = "EmptyCart")
    public void ConfirmEmptyCart(){
        Assert.assertTrue(cartPage.getEmptyCartText().isDisplayed());
        automatedBrowser.snapshot("Empty Cart Snapshot"); //proof of empty cart
    }








}
