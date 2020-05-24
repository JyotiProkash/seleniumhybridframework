package com.hybridframework.qa.helper.javascript;

import com.hybridframework.qa.helper.frame.FrameHelper;
import com.hybridframework.qa.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class JavaScriptHelper
  {
      private WebDriver driver;
      private Logger log= LoggerHelper.getLogger(JavaScriptHelper.class);

      /**
       * This method will click on element.
       * @param element
       */
      public void clickElement(WebElement element)
         {
             executeScript("arguments[0].click();",element);
         }

      public JavaScriptHelper(WebDriver driver) throws IOException
         {
            this.driver=driver;
            log.info("JavaScriptHelper has been initialised.");
         }
      public Object executeScript(String script)
         {
            JavascriptExecutor exe=(JavascriptExecutor)driver;
            return exe.executeScript(script);
         }
      public Object executeScript(String script, Object...args)
         {
           JavascriptExecutor exe=(JavascriptExecutor)driver;
           return exe.executeScript(script,args);
         }
      private void scrollToElement(WebElement element)
         {
            log.info("Scroll to WebElement...");
            executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
         }
      public void scrollToElementAndClick(WebElement element)
         {
           log.info("Scroll to WebElement and Click.");
           scrollToElement(element);
           element.click();
           log.info("Element is clicked: "+element.toString());
         }
      private void scrollIntoView(WebElement element)
         {
            log.info("Scroll till WebElement.");
            executeScript("arguments[0].scrollIntoView()",element);
         }
      public void scrollIntoViewAndClick(WebElement element)
        {
            scrollIntoView(element);
            element.click();
            log.info("Element is clicked: "+element.toString());
        }
      public void scrollDownVertically()
        {
            log.info("Scrolling Down Vertically...");
            executeScript("window.scrollTo(0,document.body.scrollHeight)");
        }
      public void scrollUpVertically()
        {
           log.info("Scrolling Up Vertically...");
           executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        }

      /**
       * This method will scroll till given pixel.
       * @param pixel
       */
        public void scrollDownByPixel(int pixel)
          {
             executeScript("window.scrollBy(0,"+pixel+")");
          }
        public void scrollUpByPixel(int pixel)
          {
             executeScript("window.scrollBy(0,-"+pixel+")");
          }

      /**
       * This method will zoom screen by 100%.
       */
      public void zoomInBy100Percentage()
        {
           executeScript("document.body.style.zoom='100%'");
        }

      /**
       * This method will zoom screen by 60%.
       */
      public void zoomInBy60Percentage()
        {
           executeScript("document.body.style.zoom='60%'");
        }
  }
