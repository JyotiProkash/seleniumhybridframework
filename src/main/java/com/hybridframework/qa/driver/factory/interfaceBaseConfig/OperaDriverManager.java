package com.hybridframework.qa.driver.factory.interfaceBaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * Created by Jyoti on 20/04/2020
 */
public class OperaDriverManager implements DriverManager {
    @Override
    public WebDriver createDriver() {
        WebDriverManager.operadriver().cachePath("Drivers").setup();
        WebDriver driver = new OperaDriver();
        return driver;

    }

}
