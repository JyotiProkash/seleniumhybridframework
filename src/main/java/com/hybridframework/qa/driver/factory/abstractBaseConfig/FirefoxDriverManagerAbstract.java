package com.hybridframework.qa.driver.factory.abstractBaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Created by Jyoti on 20/04/2020
 */
public class FirefoxDriverManagerAbstract extends DriverManagerAbstract
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
      public WebDriver startDriver() {
          WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
          driver = new FirefoxDriver(getFireFoxOptions());
          driver.manage().window().maximize();
          return driver;
      }
  }
