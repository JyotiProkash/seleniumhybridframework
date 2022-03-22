package com.hybridframework.qa.driver.factory.interfaceBaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Created by Jyoti on 20/04/2020
 */
public class FirefoxDriverManager implements DriverManager
  {
      private FirefoxOptions getFireFoxOptions()
         {
             FirefoxOptions firefoxOptions = new FirefoxOptions();
             firefoxOptions.setCapability("marionette", true);

             if(System.getProperty("os.name").contains("Linux"))
             {
                 firefoxOptions.addArguments("--headless","window-size=1024,768","--no-sandbox");
             }
             return firefoxOptions;
         }
      @Override
      public WebDriver createDriver() {
          WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
          WebDriver driver = new FirefoxDriver(getFireFoxOptions());
          return driver;
      }
  }
