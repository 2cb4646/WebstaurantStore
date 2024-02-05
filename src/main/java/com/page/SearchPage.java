package com.page;

import com.base.AutomatedBrowser;
import com.component.search.TopSearchBar;
import com.component.search.TopSearchButton;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {


    private final TopSearchBar topSearchBar;
    private final TopSearchButton topSearchButton;



    public SearchPage(final AutomatedBrowser automatedBrowser){
        this.topSearchBar = PageFactory.initElements(automatedBrowser.getWebDriver(),TopSearchBar.class);
        this.topSearchButton = PageFactory.initElements(automatedBrowser.getWebDriver(), TopSearchButton.class);
   }

    public TopSearchBar getTopSearchBar(){return topSearchBar;}
    public TopSearchButton getTopSearchButton(){return topSearchButton;}

}
