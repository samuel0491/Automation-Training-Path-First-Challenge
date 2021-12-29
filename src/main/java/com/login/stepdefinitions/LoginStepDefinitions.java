package com.login.stepdefinitions;

import com.cucumber.TestContext;
import com.login.pageobject.LoginPageObject;
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
    public void theUserOpensTheBrowserAndNavigatesToPracticeAutomationtestingSPage() {

        String pageTitle = "Automation Practice Site";//TODO: move this value
        loginPageObject.navigateTo();
        Assert.assertTrue("The titles aren't equals. "+pageTitle,loginPageObject.isRightTheTitle(pageTitle));
    }

    @And("the user click on My Account option")
    public void theUserClickOnMyAccountOption() {
        loginPageObject.clickOnMyAccountOption();

    }

    @Then("the login and register form should show up")
    public void theLoginAndRegisterFormShouldShowUp() {

        Assert.assertTrue("Login page doesn't changed the forms",loginPageObject.loginAndRegisterFormExists());
    }

    @Given("the user typed his username {string}")
    public void theUserTypedHisUsername(String username) {

        loginPageObject.enterUserName(username);
    }

    @And("the user typed his password {string}")
    public void theUserTypedHisPassword(String password) {

        loginPageObject.enterUserPassword(password);
    }

    @When("the user presses login button")
    public void theUserPressesLoginButton() {

        loginPageObject.clickOnLoginButton();
    }

    @Then("my account page show up")
    public void myAccountPageShowUp() {

        myAccountPageObject = new MyAccountPageObject(testContext.getWebDriverManager().getDriver());
    }

    @And("the text {string} is showing")
    public void theTextIsShowing(String welcomedText) {
        Assert.assertTrue("The Welcome Text are different",myAccountPageObject.wasSucessfulLogin(welcomedText));
    }


    @Given("the user typed his credentials {string} and {string}")
    public void theUserTypedHisCredentialsAnd(String username, String password) {

        loginPageObject.enterUserName(username);
        loginPageObject.enterUserPassword(password);
    }

    @Then("Proper {string} error must be displayed by the page")
    public void properErrorMustBeDisplayedByThePage(String message) {

        Assert.assertTrue("Error messages are not the same",loginPageObject.areEqualsLoginMessagesError(message));

    }

    @When("the user typed username as {string}")
    public void theUserTypedUsernameAs(String username) {

        loginPageObject.enterUserName(username);
    }

    @And("the user typed password as {string}")
    public void theUserTypedPasswordAs(String password) {

        loginPageObject.enterUserPassword(password);
    }

    @Then("password field type should be {string} in the DOM")
    public void passwordFieldTypeShouldBeInTheDOM(String fieldType) {

        Assert.assertTrue("Field type is not as expected",loginPageObject.isPasswordFieldTypeExpected(fieldType));

    }

    @Given("user is logged in successful")
    public void user_is_logged_in_successful(io.cucumber.datatable.DataTable dataTable) {

        loginPageObject.setLoginSuccessful(dataTable);
    }

    @When("the user click on sign out option")
    public void theUserClickOnSignOutOption() {
        myAccountPageObject = testContext.getPageObjectManager().getMyAccountPageObject();
        myAccountPageObject.clickOnSignoutOption();
    }

    @And("the user click on browser back button")
    public void theUserClickOnBrowserBackButton() {

        loginPageObject.backButtonBrowser();
        Assert.assertTrue("Login page doesn't changed the forms",loginPageObject.loginAndRegisterFormExists());

    }

    @Then("the user should not be logged in")
    public void theUserShouldNotBeLoggedIn() {

        Assert.assertTrue("Login page doesn't changed the forms",loginPageObject.loginAndRegisterFormExists());

    }
}
