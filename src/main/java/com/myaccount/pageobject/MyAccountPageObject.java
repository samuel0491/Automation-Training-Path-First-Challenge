package com.myaccount.pageobject;

import com.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageObject extends BasePage {

    public MyAccountPageObject(WebDriver driver){

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='page-36']/div/div[1]/nav")
    private WebElement navigationBarMyAccount;

    @FindBy(how = How.XPATH, using = "//*[@id='page-36']/div/div[1]/div/p[1]/a")
    private WebElement signoutOption;

    @FindBy(how = How.XPATH, using = "//*[@id='page-36']/div/div[1]/div/p[1]")
    private WebElement welcomedTextMyAccount;

    //actions on elements
    public String getWelcomedText(){

        waitVisibilityOfElement(welcomedTextMyAccount);
            return welcomedTextMyAccount.getText();
    }

    public void clickOnSignoutOption(){

        signoutOption.click();
    }

    public boolean wasSucessfulLogin(String welcomedText){

        if(welcomedText.contentEquals(getWelcomedText()))
            return true;
        else
            return false;
    }

}
