package com.hybridframework.qa.sourcepages;

import com.hybridframework.qa.helper.logger.LoggerHelper;
import com.hybridframework.qa.helper.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage
  {
      private WebDriver driver;
      private final Logger log= LoggerHelper.getLogger(HomePage.class);
      WaitHelper waitHelper;
      public HomePage(WebDriver driver) throws IOException
        {
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }
  }
