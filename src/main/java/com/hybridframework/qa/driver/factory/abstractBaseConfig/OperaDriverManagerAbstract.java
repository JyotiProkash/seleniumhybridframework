package com.hybridframework.qa.driver.factory.abstractBaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * Created by Jyoti on 20/04/2020
 */
public class OperaDriverManagerAbstract extends DriverManagerAbstract{
    @Override
    public WebDriver startDriver() {
        WebDriverManager.operadriver().cachePath("Drivers").setup();
        driver = new OperaDriver();
        return driver;
    }
}
