package com.hybridframework.qa.testpages;

import com.hybridframework.qa.helper.logger.LoggerHelper;
import com.hybridframework.qa.testbase.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest extends TestBase
  {
      private Logger log= LoggerHelper.getLogger(LoginTest.class);

      public LoginTest() throws IOException {
      }

      @Test
      public void openFacebookSite()

        {
            System.out.println("Facebook site open");
            log.info("Jyoti here");
        }
  }
