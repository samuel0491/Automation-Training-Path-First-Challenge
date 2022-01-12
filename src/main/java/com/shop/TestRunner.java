package com.shop;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/com.training.features/shop",
        glue = {"com/shop"},
        plugin = { "pretty","html:target/cucumber-reports.html"},
        monochrome = true
)
public class TestRunner {

}
