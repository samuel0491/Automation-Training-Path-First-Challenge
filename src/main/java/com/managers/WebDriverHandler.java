package com.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

//this class has only the responsibility to get the WebDriver when
//we need for it.
public class WebDriverHandler {

    private WebDriver driver;

    private WebDriver setUpDriver(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver(chromeOptions);
        driver.manage().deleteAllCookies();
        return driver;
    }

    public WebDriver getDriver(){
        if(driver == null)
            driver = setUpDriver();
        return driver;
    }

    public void shutDown(){

        getDriver().close();
        getDriver().quit();
    }
}
