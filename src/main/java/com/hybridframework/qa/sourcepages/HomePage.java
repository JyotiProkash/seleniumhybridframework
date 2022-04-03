package com.hybridframework.qa.sourcepages;

import com.hybridframework.qa.helper.logger.LoggerHelper;
import com.hybridframework.qa.pagebase.BasePage;
import com.hybridframework.qa.sourcepages.components.MyHeader;
import com.hybridframework.qa.sourcepages.components.ProductThumbnail;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class HomePage extends BasePage {
    public MyHeader getMyHeader() {
        return myHeader;
    }

    public ProductThumbnail getProductThumbnail() {
        return productThumbnail;
    }

    private MyHeader myHeader;
    private ProductThumbnail productThumbnail;
    private final Logger log= LoggerHelper.getLogger(HomePage.class);
    public HomePage(WebDriver driver) throws IOException {
        super(driver);
        myHeader = new MyHeader(driver);
        productThumbnail = new ProductThumbnail(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }
}
