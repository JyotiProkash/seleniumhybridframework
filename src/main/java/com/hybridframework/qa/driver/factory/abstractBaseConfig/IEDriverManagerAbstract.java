package com.hybridframework.qa.driver.factory.abstractBaseConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Jyoti on 20/04/2020
 */
public class IEDriverManagerAbstract extends DriverManagerAbstract
  {
      private InternetExplorerOptions getIExplorerCapabilities()
         {
             DesiredCapabilities cap=new DesiredCapabilities();
             cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
             cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
             cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
             cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
             cap.setJavascriptEnabled(true);

             InternetExplorerOptions internetExplorerOptions=new InternetExplorerOptions(cap);
             return internetExplorerOptions;
         }

      @Override
      protected void startDriver() {
          WebDriverManager.iedriver().cachePath("Drivers").setup();
          driver = new InternetExplorerDriver(getIExplorerCapabilities());
          driver.manage().window().maximize();
      }
  }
