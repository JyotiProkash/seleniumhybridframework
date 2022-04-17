package com.hybridframework.qa.driver.factory.abstractBaseConfig;

import org.openqa.selenium.WebDriver;

public abstract class DriverManagerAbstract {
    protected WebDriver driver;

    public abstract WebDriver startDriver();

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver(){
        if(driver == null){
            startDriver();
        }
        return driver;
    }
}
