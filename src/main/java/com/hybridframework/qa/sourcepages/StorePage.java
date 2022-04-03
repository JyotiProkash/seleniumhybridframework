package com.hybridframework.qa.sourcepages;

import com.hybridframework.qa.pagebase.BasePage;
import com.hybridframework.qa.sourcepages.components.ProductThumbnail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Created by Jyoti 03/04/2022
 */

public class StorePage extends BasePage {
    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchBtn = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private ProductThumbnail productThumbnail;

    public StorePage(WebDriver driver) {
        super(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    private StorePage enterTextInSearchFld(String txt){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchFld)).sendKeys(txt);
        return this;
    }

    public StorePage load(){
        load("/store");
        return this;
    }

    public StorePage search(String txt){
        enterTextInSearchFld(txt).clickSearchBtn();
        return this;
    }

    private StorePage clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        return this;
    }

    public String getTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).getText();
    }
}
