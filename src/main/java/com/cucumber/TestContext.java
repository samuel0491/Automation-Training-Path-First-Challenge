package com.cucumber;

import com.managers.PageObjectManager;
import com.managers.WebDriverHandler;

//this class has only the responsibility to share Test Context, Scenario Context, Test State
//between our step definitions file
public class TestContext {

    private final PageObjectManager pageObjectManager;
    private final WebDriverHandler webDriverManager;

    public TestContext(){
        webDriverManager = new WebDriverHandler();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverHandler getWebDriverManager(){
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }
}
