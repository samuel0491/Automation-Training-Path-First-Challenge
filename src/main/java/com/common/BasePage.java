package com.common;

import com.managers.FileReaderManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
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
        js = (JavascriptExecutor) driver;
    }

    public void navigateTo(){

        driver.navigate().to(FileReaderManager.getInstance().getConfigurationEnvReader().getURLPracticePage());

        driver.manage().timeouts().pageLoadTimeout(FileReaderManager.getInstance()
                                                                    .getConfigurationEnvReader()
                                                                    .getImplicitWaitTimeOut(),
                                                    TimeUnit.SECONDS);

        if(FileReaderManager.getInstance().getConfigurationEnvReader().windowMaximized()) {
            driver.manage().window().maximize();
        }
    }

    public String getPageTitle(){

        System.out.println("-----------> "+driver.getTitle());
        return driver.getTitle();
    }

    public void waitVisibilityOfElement(WebElement element){

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void backButtonBrowser(){

        driver.navigate().back();
    }

    public void clickOnButtonOption(WebElement element){

        element.click();
    }

    public boolean isRightTheTitle(String title){

        return title.contentEquals(getPageTitle());
    }

    public boolean moveSliderBarLeftElement(WebElement sideBar,int min_price,int currentPrice) {

        boolean isPriceSet = false;
        Actions moveSlider = new Actions(driver);
        Action action;

        if(currentPrice < min_price) {
            action = moveSlider.dragAndDropBy(sideBar, 1, 0).build();
            action.perform();
        }

        if(currentPrice == min_price){
            isPriceSet = true;
        }

        return isPriceSet;
    }

    public boolean moveSliderBarRightElement(WebElement sideBar,int max_price,int currentPrice) {

        boolean isPriceSet = false;
        Actions moveSlider = new Actions(driver);
        //Action action;

        if(currentPrice > max_price) {
            Action action = moveSlider.dragAndDropBy(sideBar, -1, 0).build();
            action.perform();
        }

         if(currentPrice == max_price){
            isPriceSet = true;
        }

        return isPriceSet;
    }

    public int getCountElementsList(List<WebElement> list){

        return list.size();

    }

    public void selectDropdownList(WebElement element, String search, int searchCriteria){

        Select dropdown = new Select(element);
        switch(searchCriteria){
            case 1: dropdown.selectByValue(search);
                break;
            case 2: dropdown.selectByVisibleText(search);
                break;
            case 3: dropdown.selectByIndex(Integer.parseInt(search));
                break;
        }


    }
}
