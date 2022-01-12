package com.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//this class has only the responsibility to get the WebDriver when
//we need for it.
public class WebDriverHandler {

    private WebDriver driver;

    public WebDriver getDriver(){
        if(driver == null)
            driver = setUpDriver();
        return driver;
    }

    private WebDriver setUpDriver(){

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);

        return driver;
    }

    public void shutDown(){

        driver.close();
        driver.quit();
    }
}
