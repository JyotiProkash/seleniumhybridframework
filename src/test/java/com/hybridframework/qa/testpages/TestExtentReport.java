package com.hybridframework.qa.testpages;

import com.hybridframework.qa.helper.assertion.AssertionHelper;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestExtentReport extends TestBase  {

    public TestExtentReport() throws IOException {
    }

    //    @Test
//    public void loginTest1()
//    {
//        AssertionHelper.makeTrue();
//    }
//
    @Test(priority = 1)
    public void loginTest2()
    {
        //String s1=null;
        AssertionHelper.makeTrue();
        //driver.get("https://www.facebook.com");
    }

//    @Test(priority = 0)
//    public void loginTest3()
//    {
//        AssertionHelper.makeTrue();
//    }

//    @Test(priority = 2)
//    public void verifyBlogHeader()
//    {
//        bHome= PageFactory.initElements(driver,BlogHome.class);
//        AssertionHelper.verifyText(bHome.headerText(),"Learning Points on Software Testing");
//    }
}
