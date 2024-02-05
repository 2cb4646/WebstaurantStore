package com.page;

import com.base.AutomatedBrowser;

import com.component.searchResults.AddToCart;
import com.component.searchResults.NineElement;
import com.component.searchResults.ProductDescriptions;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

     private final ProductDescriptions productDescriptions;
     private final NineElement nineElement;
     private final AddToCart addToCart;


    public ResultsPage(final AutomatedBrowser automatedBrowser){
       this.productDescriptions = PageFactory.initElements(automatedBrowser.getWebDriver(),ProductDescriptions.class);
       this.nineElement = PageFactory.initElements(automatedBrowser.getWebDriver(),NineElement.class);
       this.addToCart = PageFactory.initElements(automatedBrowser.getWebDriver(),AddToCart.class);
    }

    public ProductDescriptions getProductDescriptions(){return productDescriptions;}
    public NineElement getNineElement(){return nineElement;}
    public AddToCart getAddToCart(){return addToCart;}


}
