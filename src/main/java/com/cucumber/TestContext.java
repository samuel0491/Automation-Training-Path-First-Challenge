package com.cucumber;

import com.managers.PageObjectManager;
import com.managers.WebDriverManager;

//this class has only the responsibility to share Test Context, Scenario Context, Test State
//between our step definitions file
public class TestContext {

    private final PageObjectManager pageObjectManager;
    private final WebDriverManager webDriverManager;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
    }

    public WebDriverManager getWebDriverManager(){
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager(){
        return pageObjectManager;
    }
}
