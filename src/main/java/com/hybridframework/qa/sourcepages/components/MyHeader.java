package com.hybridframework.qa.sourcepages.components;

import com.hybridframework.qa.pagebase.BasePage;
import com.hybridframework.qa.sourcepages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Created by Jyoti 03/04/2022
 */

public class MyHeader extends BasePage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public MyHeader(WebDriver driver) {
        super(driver);
    }
    public StorePage navigateToStoreUsingMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(storeMenuLink)).click();
        return new StorePage(driver);
    }
}
