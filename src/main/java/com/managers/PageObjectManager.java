package com.managers;

import com.login.pageobject.LoginPageObject;
import com.myaccount.pageobject.MyAccountPageObject;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private MyAccountPageObject myAccountPageObject;

    public PageObjectManager(WebDriver driver){

        this.driver = driver;
    }

    public LoginPageObject getLoginPageObject(){
        if(loginPageObject == null)
            return loginPageObject = new LoginPageObject(driver);
        else
            return loginPageObject;
    }

    public MyAccountPageObject getMyAccountPageObject(){
        if(myAccountPageObject == null)
            return myAccountPageObject = new MyAccountPageObject(driver);
        else
            return myAccountPageObject;
    }

}
