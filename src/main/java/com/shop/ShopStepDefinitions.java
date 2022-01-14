package com.shop;

import com.cucumber.TestContext;
import com.login.pageobject.LoginPageObject;
import com.managers.FileReaderManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShopStepDefinitions {

    private final LoginPageObject loginPageObject;
    private final ShopPageObject shopPageObject;
    private final TestContext context;

    public ShopStepDefinitions(TestContext context){

        this.context = context;
        loginPageObject = context.getPageObjectManager().getLoginPageObject();
        shopPageObject = context.getPageObjectManager().getShopPageObject();
    }

    @Given("the user open the browser and navigates to practice.automationtesting page")
    public void userOpenTheBrowserAndNavigatesToPage() {

        shopPageObject.navigateTo();
    }

    @And("the user click on Shop menu")
    public void theUserClickOnShopMenu() {

       String pageTitle = FileReaderManager.getInstance().getConfigurationEnvReader().getShopPageTitle();
       System.out.println("config: "+pageTitle);
       shopPageObject.clickOnShopOption();
       //TODO: fix the issue with the special character
       //Assert.assertTrue("The titles aren't equals. "+pageTitle,shopPageObject.isRightTheTitle(pageTitle));
    }

    @Then("the shop page is displayed")
    public void theShopPageIsDisplayed() {
     Assert.assertTrue("Shop page doesn't changed the Side Bar",shopPageObject.waitShopSideBarExists());
    }

    @Given("the user adjust the filter by price between {int} {int} rps")
    public void userAdjustTheFilterByPriceBetweenMinAndMax(int min_price, int max_price) {
      shopPageObject.movePriceSideBar(min_price,max_price);
    }

    @When("the user click on the filter button")
    public void theUserClickOnTheFilterButton() {

     shopPageObject.clickOnFilterButton();
    }

    @Then("user can view books only between {int} to {int} rps price")
    public void userCanViewBooksOnlyBetweenToMinMaxPrices(double min, double max) {

     Assert.assertTrue("At least a book price in the page is different to in the Scenario",shopPageObject.verifyPricePorductList(min,max));

    }

    @When("the user click on a product {string}")
    public void theUserClickOnAProduct(String category) {
     shopPageObject.selectProductCategory(category);
     Assert.assertTrue("At least a book don't display in the page",shopPageObject.waitProductListExists());
    }

    @Then("the user can view only that particular product and {string}")
    public void userCanViewOnlyThatParticularProductAndQuantity(String quantity) {

     Assert.assertTrue("The quantity in the page isn't equal to in the scenario", shopPageObject.compareProductQuantity(Integer.parseInt(quantity)));
    }

    @Given("the user select a {string} to sort")
    public void theUserSelectAToSort(String criteria) {
     shopPageObject.selectDefaultSorting(criteria);

        Assert.assertTrue("At least a book don't display in the page",shopPageObject.waitProductListExists());

    }

    @Then("the user can view the products ordered by criterion selected")
    public void theUserCanViewTheProductsOrderedByCriterionSelected() {

    }

    @When("the user click on a product with Sale! icon")
    public void theUserClickOnAProductWithSaleIcon() {
    }

    @Then("the detail product corresponding is show up")
    public void theDetailProductCorrespondingIsShowUp() {
    }

    @And("the user can see the actual price with old price stricken")
    public void theUserCanSeeTheActualPriceWithOldPriceStricken() {
    }

    @Given("the user Click on the Add To Basket button")
    public void theUserClickOnTheAddToBasketButton() {
    }

    @And("the user can view the product in the Menu item with price")
    public void theUserCanViewTheProductInTheMenuItemWithPrice() {
    }

    @And("the user click on View Basket link")
    public void theUserClickOnViewBasketLink() {
    }

    @And("the check out page is displayed")
    public void theCheckOutPageIsDisplayed() {
    }

    @And("the user can see the value of Total is Subtotal + Taxes")
    public void theUserCanSeeTheValueOfTotalIsSubtotalTaxes() {
    }

    @When("the user click on Proceed to Check Out button")
    public void theUserClickOnProceedToCheckOutButton() {
    }

    @And("payment gateway page is displayed")
    public void paymentGatewayPageIsDisplayed() {
    }

    @And("the user enter in the form")
    public void theUserEnterInTheForm() {
    }

    @And("the user can see order details")
    public void theUserCanSeeOrderDetails() {
    }

    @And("the user select a {string}")
    public void theUserSelectA(String arg0) {
    }

    @And("the user click on Place Order button")
    public void theUserClickOnPlaceOrderButton() {
    }

    @Then("the user completes the process and can see the Order confirmation page")
    public void theUserCompletesTheProcessAndCanSeeTheOrderConfirmationPage() {
    }
}
