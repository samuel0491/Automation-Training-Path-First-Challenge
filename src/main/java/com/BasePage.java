package com;

import com.training.configuration.FileReaderManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void navigateTo(){

        driver.navigate().to(FileReaderManager.getInstance().getConfigurationEnvReader().getSpecificProperty("URLAutomationPracticeSite"));
        //TODO: validate title page
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public void waitVisibilityOfElement(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUrlContain(String URL){

        wait.until(ExpectedConditions.urlContains(URL));

    }

    public void backButtonBrowser(){

        driver.navigate().back();
    }

}
