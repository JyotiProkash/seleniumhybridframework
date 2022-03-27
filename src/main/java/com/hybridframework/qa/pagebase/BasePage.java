package com.hybridframework.qa.pagebase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Created by Jyoti 21/03/2022
 */

public class BasePage {
      protected WebDriver driver;
      protected WebDriverWait wait;

      public  BasePage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
      }

      public void load(String endpoint){
        driver.get(endpoint);
      }

      public void waitForOverlaysToDisappear(By overlay){
        List<WebElement> overlays = driver.findElements(overlay);
        System.out.println("OVERLAY SIZE" + overlays.size());
        if(overlays.size() > 0){
        wait.until(ExpectedConditions.invisibilityOfAllElements(overlays));
        System.out.println("OVERLAYS INVISIBLE");
        } else{
          System.out.println("OVERLAY NOT FOUND");
        }
      }

  }
