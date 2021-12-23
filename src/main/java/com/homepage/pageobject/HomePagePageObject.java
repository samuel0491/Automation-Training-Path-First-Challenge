package com.homepage.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePagePageObject {

    public HomePagePageObject(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using= "site-logo")
    private WebElement imgSiteLogo;

    public boolean isLogoDisplayed(){

        return imgSiteLogo.isDisplayed();
    }

}
