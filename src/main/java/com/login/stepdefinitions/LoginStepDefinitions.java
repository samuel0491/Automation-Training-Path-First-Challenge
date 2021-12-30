package com.login.stepdefinitions;

import com.cucumber.TestContext;
import com.login.pageobject.LoginPageObject;
import com.managers.FileReaderManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.myaccount.pageobject.MyAccountPageObject;
import org.junit.Assert;

public class LoginStepDefinitions {

    private final LoginPageObject loginPageObject;
    private MyAccountPageObject myAccountPageObject;
    private final TestContext testContext;

    public LoginStepDefinitions(TestContext context){
        testContext = context;
        loginPageObject = testContext.getPageObjectManager().getLoginPageObject();
    }

    @Given("the user opens the browser and navigates to practice.automationtesting's page")
    public void OpenTheBrowserAndNavigatesToPage() {

        String pageTitle = FileReaderManager.getInstance().getConfigurationEnvReader().getHomePageTitle();
        loginPageObject.navigateTo();
        Assert.assertTrue("The titles aren't equals. "+pageTitle,loginPageObject.isRightTheTitle(pageTitle));
    }

    @And("the user click on My Account option")
    public void userClickOnMyAccountOption() {
        loginPageObject.clickOnMyAccountOption();

    }

    @Then("the login and register form should show up")
    public void loginAndRegisterFormShouldShowUp() {

        Assert.assertTrue("Login page doesn't changed the forms",loginPageObject.loginAndRegisterFormExists());
    }

    @Given("the user typed his username {string}")
    public void userTypedHisUsername(String username) {

        loginPageObject.enterUserName(username);
    }

    @And("the user typed his password {string}")
    public void userTypedHisPassword(String password) {

        loginPageObject.enterUserPassword(password);
    }

    @When("the user presses login button")
    public void userPressesLoginButton() {

        loginPageObject.clickOnLoginButton();
    }

    @Then("my account page show up")
    public void myAccountPageShowUp() {

        myAccountPageObject = new MyAccountPageObject(testContext.getWebDriverManager().getDriver());
    }

    @And("the text {string} is showing")
    public void welcomedTextIsShowing(String welcomedText) {
        Assert.assertTrue("The Welcome Text are different",myAccountPageObject.wasSucessfulLogin(welcomedText));
    }


    @Given("the user typed his credentials {string} and {string}")
    public void userTypedHisCredentials(String username, String password) {

        loginPageObject.enterUserName(username);
        loginPageObject.enterUserPassword(password);
    }

    @Then("Proper {string} error must be displayed by the page")
    public void properErrorMustBeDisplayedByThePage(String message) {

        Assert.assertTrue("Error messages are not the same",loginPageObject.areEqualsLoginMessagesError(message));

    }

    @When("the user typed username as {string}")
    public void userTypedUsername(String username) {

        loginPageObject.enterUserName(username);
    }

    @And("the user typed password as {string}")
    public void userTypedPassword(String password) {

        loginPageObject.enterUserPassword(password);
    }

    @Then("password field type should be {string} in the DOM")
    public void passwordFieldTypeShouldBeInTheDOM(String fieldType) {

        Assert.assertTrue("Field type is not as expected",loginPageObject.isPasswordFieldTypeExpected(fieldType));

    }

    @Given("user is logged in successful")
    public void userLoggedInSuccessful(io.cucumber.datatable.DataTable dataTable) {

        loginPageObject.setLoginSuccessful(dataTable);
    }

    @When("the user click on sign out option")
    public void userClickOnSignOutOption() {
        myAccountPageObject = testContext.getPageObjectManager().getMyAccountPageObject();
        myAccountPageObject.clickOnSignoutOption();
    }

    @And("the user click on browser back button")
    public void userClickOnBrowserBackButton() {

        loginPageObject.backButtonBrowser();
        Assert.assertTrue("Login page doesn't changed the forms",loginPageObject.loginAndRegisterFormExists());

    }

    @Then("the user should not be logged in")
    public void userShouldNotBeLoggedIn() {

        Assert.assertTrue("Login page doesn't changed the forms",loginPageObject.loginAndRegisterFormExists());

    }
}
