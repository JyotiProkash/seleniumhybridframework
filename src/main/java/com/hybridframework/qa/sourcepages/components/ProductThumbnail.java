package com.hybridframework.qa.sourcepages.components;

import com.hybridframework.qa.pagebase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductThumbnail extends BasePage {
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public ProductThumbnail(WebDriver driver) {
        super(driver);
    }

    private By getAddToCartBtnElement(String productName){
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");
    }

    public ProductThumbnail clickAddToCartBtn(String productName){
        By addToCartBtn = getAddToCartBtnElement(productName);
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        return this;
    }

}
