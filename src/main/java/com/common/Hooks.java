package com.common;

import com.cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks{

    private final TestContext testContext;

    public Hooks(TestContext context){
        this.testContext = context;
    }

    @Before
    public void setUp(){
        testContext.getWebDriverManager().getDriver();
    }

    @After
    public void shutDown(){
        testContext.getWebDriverManager().shutDown();
    }
}
