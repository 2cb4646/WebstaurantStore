package com.base.configuration;

import org.aeonbits.owner.Config;


public interface WebstaurantConfig extends Config {


    @Config.Key("browser")
    @Config.DefaultValue("chrome")
    String browser();

    @Config.Key("runHeadless")
    @Config.DefaultValue("false")
    String runHeadless();

    @Config.Key("navigationURL")
    @Config.DefaultValue("https://www.webstaurantstore.com/")
    String navigationURL();

    @Config.Key("searchTerm")
    @Config.DefaultValue("stainless work table")
    String searchTerm();



}
