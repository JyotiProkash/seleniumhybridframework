package com.hybridframework.qa.driver.factory.abstractBaseConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

/**
 * Created by Jyoti on 20/04/2020
 */
public class ChromeDriverManagerAbstract extends DriverManagerAbstract
  {
      private ChromeOptions getChromeOptions()
        {
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--test-type");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--start-maximized");
            options.addArguments("--auto-open-devtools-for-tabs");
            DesiredCapabilities cap=new DesiredCapabilities();
            cap.setJavascriptEnabled(true);
            cap.setCapability(ChromeOptions.CAPABILITY,options);
            if(System.getProperty("os.name").contains("Linux"))
              {
                  options.addArguments("--headless","window-size=1024,768","--no-sandbox");
              }
            options.merge(cap);
            return options;
        }

      @Override
      protected void startDriver() {
          WebDriverManager.chromedriver().cachePath("Drivers").setup();
          driver = new ChromeDriver(getChromeOptions());
      }
  }
