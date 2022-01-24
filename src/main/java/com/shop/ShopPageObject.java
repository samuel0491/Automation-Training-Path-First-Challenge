package com.shop;

import com.common.BasePage;
import com.common.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import java.util.ArrayList;
import java.util.List;

public class ShopPageObject extends BasePage {

    public ShopPageObject(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private String productTile;

    @FindBy(how = How.CSS, using = "#menu-item-40")
    private WebElement shopOption;

    @FindBy(how = How.CSS, using = "#sidebar")
    private WebElement shopSideBar;

    @FindBy(how = How.XPATH, using = "//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[1]")
    private WebElement leftPriceSlider;

    @FindBy(how = How.XPATH, using = "//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[2]")
    private WebElement rightPriceSlider;

    @FindBy(how = How.CSS, using = "#woocommerce_price_filter-2 > form > div > div.price_slider_amount > button")
    private WebElement filterButton;

    @FindBy(how = How.XPATH,using = "//*[@id='content']/ul/li")//"#content > ul > li")
    private List<WebElement> productListFiltered;

    @FindBys(@FindBy(how = How.XPATH, using = "//*[@id='content']/ul/li/a/span[@class='price']/*[self::ins or self::span]"))
    private List<WebElement> productPriceList;

    @FindBys(@FindBy(how = How.XPATH, using = "//*[@id='woocommerce_product_categories-2']/ul/li"))
    private List<WebElement> productCategories;

    @FindBy(how = How.CSS, using = "#content > form > select" )
    private WebElement defaultSorting;

    @FindBy(how = How.XPATH,using = "//*[@id='woocommerce_price_filter-2']/form//span[@class='from']")
    private WebElement minPrice;

    @FindBy(how = How.XPATH,using = "//*[@id='woocommerce_price_filter-2']/form//span[@class='to']")
    private WebElement maxPrice;

    @FindBy(how = How.XPATH, using = "//*[div[contains(@id,'product')]]/div/div[2]/h1[@class='product_title entry-title']")
    private WebElement productDetailsTitle;


    public void clickOnShopOption(){

        clickOnButtonOption(shopOption);
    }

    public boolean waitShopSideBarExists(){

        waitVisibilityOfElement(shopSideBar);
        return shopSideBar.isDisplayed();
    }

    public void movePriceSideBar(int min, int max){

        int currentMinPrice,currentMaxPrice;

        do{
            currentMinPrice = Integer.parseInt(minPrice.getText().replaceAll("[^0-9.]", ""));
            currentMaxPrice = Integer.parseInt(maxPrice.getText().replaceAll("[^0-9.]", ""));

        }while(!(moveSliderBarLeftElement(leftPriceSlider,min,currentMinPrice)
                && moveSliderBarRightElement(rightPriceSlider,max,currentMaxPrice))
        );
    }

    public void clickOnFilterButton(){

        clickOnButtonOption(filterButton);
    }

    public boolean verifyPriceProductList(int min, int max){

        boolean right = false;

        if(max >= min)
        {
            for (int i = 0; i < getCountElementsList(productPriceList); i++)
            {
                //TODO: figure out why the string value 450.00 throw an execution exception when it's trying to convert it to integer
                if ((int)Double.parseDouble(productPriceList.get(i).getText().replaceAll("[^0-9.]", "")) >= min
                        && (int)Double.parseDouble(productPriceList.get(i).getText().replaceAll("[^0-9.]", "")) <= max)
                {
                    right = true;
                }

                else{
                    right = false;
                        break;
                }
            }
        }

        return right;
    }

    public void selectProductCategory(String product){

        for(int i=0; i < getCountElementsList(productCategories); i++)
        {
            if(productCategories.get(i).findElements(By.xpath("//a[contains(text(),'"+product+"')]")).get(i).getText().contentEquals(product))
            {
                clickOnButtonOption(productCategories.get(i).findElements(By.xpath("//a[contains(text(),'"+product+"')]")).get(i));
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

    public boolean isSortByPriceRight(String criteria){

        boolean sorted = false;

        for(int i=0; i < getCountElementsList(productListFiltered); i++)
        {
            if(productListFiltered.get(i).findElement(By.xpath("a[@rel]")).getAttribute("href").contains("/product/selenium-ruby")
            || productListFiltered.get(i).findElement(By.xpath("a[@rel]")).getAttribute("href").contains("orderby="+criteria)
            || productListFiltered.get(i).findElement(By.xpath("a[@rel]")).getAttribute("href").contains("/shop/?"))
            {
                sorted = true;
            }

            else{
                sorted = false;
                break;
            }
        }

        return sorted;
    }

    public String getProductWithDiscount() {

        String saleIcon = "a/span[@class='onsale']";
        List<WebElement> itemsOnSaleIcon = new ArrayList<>();

        for(int i=0; i < productListFiltered.size(); i++)
        {
            try{
                if(productListFiltered.get(i).findElement(By.xpath(saleIcon)).isDisplayed())
                {
                    itemsOnSaleIcon.add(productListFiltered.get(i));
                }

            }catch (NoSuchElementException e){
                System.out.println("For the index "+i+" ["+saleIcon+"] doesn't exists");
            }
       }

        int element = Utils.getRandomInteger(getCountElementsList(itemsOnSaleIcon));

        if(element > 0)
        {
            productTile = itemsOnSaleIcon.get(element-1).findElement(By.xpath("a[1]/img")).getAttribute("title");
            itemsOnSaleIcon.get(element-1).click();
        }

        else
        {
            productTile = itemsOnSaleIcon.get(element).findElement(By.xpath("a[1]/img")).getAttribute("title");
            itemsOnSaleIcon.get(element).click();
        }

        return  productTile;
    }

    public void waitUntilProductDetailsPageLoad(){

        waitVisibilityOfElement(productDetailsTitle);
    }

    public String getProductTitleOnDetailsPage(){

        return productDetailsTitle.getText();
    }

    public boolean isTheSameProductDetailsVsProduct(){

        return this.productTile.contentEquals(this.getProductTitleOnDetailsPage());
    }

}
