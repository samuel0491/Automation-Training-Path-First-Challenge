package com;

import com.managers.FileReaderManager;
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(FileReaderManager.getInstance()
                                                                            .getConfigurationEnvReader()
                                                                            .getExplicitWaitTimeOut()));
    }

    public void navigateTo(){

        driver.navigate().to(FileReaderManager.getInstance().getConfigurationEnvReader().getURLPracticePage());

        driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance()
                                                                    .getConfigurationEnvReader()
                                                                    .getImplicittWaitTimeOut(),
                                                    TimeUnit.SECONDS);

        if(FileReaderManager.getInstance().getConfigurationEnvReader().windowMaximized()) {
            driver.manage().window().maximize();
        }
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
