package com.page;

import com.base.AutomatedBrowser;
import com.component.cart.*;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private final CartButton cartButton;
    private final EmptyCartButton emptyCartButton;
    private final ViewCartButton viewCartButton;
    private final EmptyCartText emptyCartText;
    private final EmptyCartPromptButton emptyCartPromptButton;


    public CartPage(final AutomatedBrowser automatedBrowser){
        this.cartButton = PageFactory.initElements(automatedBrowser.getWebDriver(),CartButton.class);
        this.emptyCartButton = PageFactory.initElements(automatedBrowser.getWebDriver(),EmptyCartButton.class);
        this.viewCartButton = PageFactory.initElements(automatedBrowser.getWebDriver(),ViewCartButton.class);
        this.emptyCartText = PageFactory.initElements(automatedBrowser.getWebDriver(),EmptyCartText.class);
        this.emptyCartPromptButton = PageFactory.initElements(automatedBrowser.getWebDriver(),EmptyCartPromptButton.class);
    }



    public CartButton getCartButton(){return cartButton;}
    public EmptyCartButton getEmptyCartButton(){return emptyCartButton;}
    public ViewCartButton getViewCartButton(){return viewCartButton;}
    public EmptyCartText getEmptyCartText(){return emptyCartText;}
    public EmptyCartPromptButton getEmptyCartPromptButton(){return emptyCartPromptButton;}


}
