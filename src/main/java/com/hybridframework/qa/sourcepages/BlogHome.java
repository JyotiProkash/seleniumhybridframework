package com.hybridframework.qa.sourcepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BlogHome {

    private WebDriver driver;
    public BlogHome(WebDriver driver)
      {
          this.driver=driver;
      }
     @FindBy(xpath="//span[contains(text(),'Learning Points on Software Testing')]")
    public WebElement headerText;

    public String headerText()
      {
          return headerText.getText();
      }
}
