package com.shop;

import com.BasePage;
import io.cucumber.messages.Messages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShopPageObject extends BasePage {

    public ShopPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.CSS, using = "#menu-item-40")
    private WebElement shopOption;

    @FindBy(how = How.CSS, using = "#sidebar")
    private WebElement shopSideBar;

    @FindBy(how = How.XPATH, using = "//*[@id=\'woocommerce_price_filter-2\']/form/div/div[1]/div")
    private WebElement parentPriceSlider;

    @FindBy(how = How.XPATH, using = "//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[1]")
    private WebElement leftPriceSlider;

    @FindBy(how = How.XPATH, using = "//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[2]")
    private WebElement rightPriceSlider;

    @FindBy(how = How.CSS, using = "#woocommerce_price_filter-2 > form > div > div.price_slider_amount > button")
    private WebElement filterButton;

    @FindBy(how = How.CSS, using = "#content > ul > li")
    private List<WebElement> productListFiltered;

    @FindBy(how = How.XPATH, using = "//*[@id='content']/ul/li/a/span[@class='price']/*[self::ins or self::span]")
    private List<WebElement> productPriceList;

    @FindBy(how = How.XPATH, using = "//*[@id='woocommerce_product_categories-2']/ul/li")
    private List<WebElement> productCategories;

    @FindBy(how = How.CSS, using = "#content > form > select" )
    private WebElement defaultSorting;

    public void clickOnShopOption(){

        clickOnButtonOption(shopOption);
    }

    public boolean waitShopSideBarExists(){

        waitVisibilityOfElement(shopSideBar);
        return shopSideBar.isDisplayed();
    }

//    public void getCurrentParentPercent(){
//
//        System.out.println(parentPriceSlider.getAttribute("style"));
//    }

    public void movePriceSideBar(int min, int max){
        //TODO: implement this function
        //moveSliderBarElement(leftPriceSlider,58);
        //moveSliderBarElement(rightPriceSlider,0);
        //moveSliderBarElementJs(parentPriceSlider,100,0);

        setMinMaxPriceByUrl(min,max);

    }

    public void clickOnFilterButton(){

        clickOnButtonOption(filterButton);
    }

    public boolean verifyPricePorductList(double min, double max){

        boolean right = false;

        if(max >= min) {

            for (int i = 0; i < getCountElementsList(productPriceList); i++) {

                if (Double.parseDouble(productPriceList.get(i).getText().replaceAll("[^0-9\\.]", "")) >= min
                        && Double.parseDouble(productPriceList.get(i).getText().replaceAll("[^0-9\\.]", "")) <= max)
                {
                    right = true;
                }

                else{
                    right = false;
                        break;
                }
            }
        }

        else{
            right = false;
        }

        return right;
    }

    public void selectProductCategory(String product){

        for(int i=0; i < getCountElementsList(productCategories); i++)
        {
            if(productCategories.get(i).findElement(By.xpath("//a[contains(text(),'"+product+"')]")).getText().contentEquals(product))
            {
                clickOnButtonOption(productCategories.get(i).findElement(By.xpath("//a[contains(text(),'"+product+"')]")));
                    break;
            }
        }
    }

    public boolean waitProductListExists(){

        waitVisibilityOfElement(productListFiltered.get(0));
        return productListFiltered.get(0).isDisplayed();
    }

    public boolean compareProductQuantity(int quantity){

        return getCountElementsList(productListFiltered) == quantity;

    }
    public void selectDefaultSorting(String search){

        selectDropdownList(defaultSorting,search,1);

    }

    public boolean sortByPrice(){

        for(int i = 0; i< getCountElementsList(productPriceList);i++){

        }
        return true;
    }
}
