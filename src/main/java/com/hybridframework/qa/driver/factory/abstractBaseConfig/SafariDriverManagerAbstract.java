package com.hybridframework.qa.driver.factory.abstractBaseConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by Jyoti on 20/04/2020
 */
public class SafariDriverManagerAbstract extends DriverManagerAbstract{
    @Override
    public WebDriver startDriver() {
        driver = new SafariDriver();
        return driver;
    }
}
