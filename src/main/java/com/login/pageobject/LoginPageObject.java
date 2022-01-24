package com.login.pageobject;

import com.common.BasePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePage {

    public LoginPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[@id='menu-item-50']")
    private WebElement myAccountOption;

    @FindBy(how = How.ID, using = "customer_login")
    private WebElement loginRegisterForms;

    @FindBy(how = How.XPATH, using = "//*[@name='username']")
    private WebElement usernameLoginInputField;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement passwordLoginInputField;

    @FindBy(how = How.XPATH, using = "//*[@name='login']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@id='rememberme']")
    private WebElement remembermeCheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id='page-36']/div/div[1]/ul/li")
    private WebElement loginErrorMessage;

    //actions on elements

    public boolean loginAndRegisterFormExists(){

        waitVisibilityOfElement(loginRegisterForms);
            return loginRegisterForms.isDisplayed();
    }

    public void clickOnMyAccountOption(){

        clickOnButtonOption(myAccountOption);
    }

    public void enterUserName(String username){

        usernameLoginInputField.sendKeys(username);
    }

    public void enterUserPassword(String userPassword){

        passwordLoginInputField.sendKeys(userPassword);
    }

    public void clickOnLoginButton(){

        clickOnButtonOption(loginButton);

    }

    public String getLoginErrorMesage(){

            waitVisibilityOfElement(loginErrorMessage);
        return loginErrorMessage.getText();
    }

    public boolean areEqualsLoginMessagesError(String message){

        return getLoginErrorMesage().contains(message);
    }

    public boolean isPasswordFieldTypeExpected(String fieldType){

        return passwordLoginInputField.getAttribute("type").contentEquals(fieldType);
    }

    public void setLoginSuccessful(DataTable table){

        usernameLoginInputField.sendKeys(table.asList().get(0));
        passwordLoginInputField.sendKeys(table.asList().get(1));
        clickOnButtonOption(loginButton);
    }

}
