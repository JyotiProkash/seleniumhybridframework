package com.hybridframework.qa.driver.factory.interfaceBaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by Jyoti on 20/04/2020
 */
public class SafariDriverManager implements DriverManager {
    @Override
    public WebDriver createDriver() {
        WebDriver driver = new SafariDriver();
        return driver;
    }

}
