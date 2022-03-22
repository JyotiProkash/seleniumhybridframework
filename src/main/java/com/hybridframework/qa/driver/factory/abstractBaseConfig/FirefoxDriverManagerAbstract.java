package com.hybridframework.qa.driver.factory.abstractBaseConfig;

import com.hybridframework.qa.utilities.PropertyManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

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
      protected void startDriver() {
          WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
          driver = new FirefoxDriver(getFireFoxOptions());
          driver.manage().window().maximize();
      }
  }
