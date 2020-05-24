package com.hybridframework.qa.sourcepages;

import com.hybridframework.qa.helper.javascript.JavaScriptHelper;
import com.hybridframework.qa.helper.logger.LoggerHelper;
import com.hybridframework.qa.helper.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

/**
 * Created by Jyoti 06/05/2020
 */
public class LoginPage
  {
      private WebDriver driver;
      private final Logger log= LoggerHelper.getLogger(LoginPage.class);
      WaitHelper waitHelper;

      public LoginPage(WebDriver driver) throws IOException
        {
            this.driver=driver;
            PageFactory.initElements(driver,this);
            waitHelper=new WaitHelper(driver);
            waitHelper.waitForElement(loginButton,10,2000);
        }

      @FindBy(id ="login_button")
      WebElement loginButton;

      public HomePage clickOnSubmitButton() throws IOException
        {
            log.info("Clicking on Submit button.");
            new JavaScriptHelper(driver).scrollDownVertically();
            loginButton.click();
            return new HomePage(driver);
        }
  }
