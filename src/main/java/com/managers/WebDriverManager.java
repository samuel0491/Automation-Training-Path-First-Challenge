package com.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//this class has only the responsibility to get the WebDriver when
//we need for it.
public class WebDriverManager {

    private WebDriver driver;

    public WebDriver getDriver(){
        if(driver == null)
            driver = setUpDriver();
        return driver;
    }

    private WebDriver setUpDriver(){

        //TODO: moves to config file
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir")+"\\src\\main\\resources\\drivers\\"+"chromedriver.exe");//

        driver = new ChromeDriver();

        return driver;
    }

    public void shutDown(){

        driver.close();
        driver.quit();
    }
}
