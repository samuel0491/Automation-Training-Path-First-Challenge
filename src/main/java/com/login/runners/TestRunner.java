package com.login.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/com.training.features/login",
        glue = {"com/login"},
        plugin = { "pretty","html:target/cucumber-reports.html"},
        monochrome = true
        )
public class TestRunner {

}
