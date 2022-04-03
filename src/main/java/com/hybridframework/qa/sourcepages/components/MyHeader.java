package com.hybridframework.qa.sourcepages.components;

import com.hybridframework.qa.pagebase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyHeader extends BasePage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");

    public MyHeader(WebDriver driver) {
        super(driver);
    }

}
