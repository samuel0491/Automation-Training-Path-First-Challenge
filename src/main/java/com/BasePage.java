package com;

import com.managers.FileReaderManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    public void waitUrlContain(String URL){

        wait.until(ExpectedConditions.urlContains(URL));

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

//    public void moveSliderBarElementJs(WebElement sideBar,double min,double max){
//        js.executeScript("arguments[0].setAttribute('style','left: "+min+"%')",sideBar);
//        js.executeScript("arguments[0].setAttribute('style','width: "+max+"%')",sideBar);
//   }
//public void moveSliderBarElement(WebElement sideBar,int x) {
//
//    Actions moveSlider = new Actions(driver);
//    Action action = moveSlider.dragAndDropBy(sideBar,x,0).build();
//
//    action.perform();
//
//}

    public void setMinMaxPriceByUrl(int min,int max){

        driver.get(driver.getCurrentUrl()+ String.format("/?min_price=%s&max_price=%s", min,max));

    }

    public int getCountElementsList(List<WebElement> list){

        return list.size();

    }

}
