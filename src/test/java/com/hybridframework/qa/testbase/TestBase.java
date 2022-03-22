package com.hybridframework.qa.testbase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hybridframework.qa.constants.DriverType;
import com.hybridframework.qa.driver.factory.abstractBaseConfig.DriverManagerAbstract;
import com.hybridframework.qa.driver.factory.abstractBaseConfig.DriverManagerFactoryAbstract;
import com.hybridframework.qa.helper.logger.LoggerHelper;
import io.restassured.http.Cookies;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Updated by Jyoti 21/04/2020
 */
public class TestBase
  {
      //public WebDriver driver;
      public static ExtentReports extent;
      public static ExtentTest test;
      private Logger log= LoggerHelper.getLogger(TestBase.class);

      private final ThreadLocal<DriverManagerAbstract> driverManager = new ThreadLocal<>();
      private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

      private void setDriverManager(DriverManagerAbstract driverManager){
          this.driverManager.set(driverManager);
      }

      protected DriverManagerAbstract getDriverManager(){
          return this.driverManager.get();
      }

      private void setDriver(WebDriver driver){
          this.driver.set(driver);
      }

      protected WebDriver getDriver(){
          return this.driver.get();
      }


      public TestBase() throws IOException {
      }


      @BeforeSuite
      public void beforeSuite() throws IOException
        {
            //extent=ExtentManager.getInstance();
        }

      @BeforeTest
      public void beforeTest() throws Exception
        {
//           driver= BrowserFactory.getABrowser();
//           BrowserFactory.maximizeABrowser(driver);
//           BrowserFactory.openURL(driver, PropertyManager.getProperty("basicinfo.properties", "url"));

//            ObjectReader.reader=new PropertyReader();
//            setUpDriver(ObjectReader.reader.getBrowserType());
        }

      //Launching a browser with url
      @BeforeClass
      public void initiation() throws InterruptedException, IOException
        {
            //test=extent.createTest(getClass().getName());
/*            driver= BrowserFactory.getABrowser();
            BrowserFactory.maximizeABrowser(driver);
            BrowserFactory.openURL(driver, PropertyManager.getProperty("basicinfo.properties", "url"));*/
        }

      @Parameters("browser")
      @BeforeMethod
      public synchronized void startDriver(@Optional String browser,Method method){
          test.log(Status.INFO,method.getName()+" test started.");
          browser = System.getProperty("browser", browser);
//        if(browser == null) browser = "CHROME";
//        setDriver(new DriverManagerOriginal().initializeDriver(browser));
          // Factory pattern implementation using interface
//          setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());
          // Factory pattern implementation using Abstract Class
          setDriverManager(DriverManagerFactoryAbstract.getManager(DriverType.valueOf(browser)));
          setDriver(getDriverManager().getDriver());
          // Factory pattern implementation using interface
/*          System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                  "DRIVER = " + getDriver());*/
          // Factory pattern implementation using Abstract Class
          System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                  "DRIVER = " + getDriver());
      }

      @Parameters("browser")
      @AfterMethod
      public synchronized void quitDriver(@Optional String browser, ITestResult result) throws InterruptedException, IOException {
          Thread.sleep(300);
          System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                  "DRIVER = " + getDriver());
          // Factory pattern implementation using interface
//          getDriver().quit();
          // Factory pattern implementation using Abstract Class
          getDriverManager().getDriver().quit();
      }

      @AfterClass
      public void tearDown() throws InterruptedException
        {
            //BrowserFactory.closeABrowser(driver);
        }

/*      public void injectCookiesToBrowser(Cookies cookies){
          List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
          for(Cookie cookie: seleniumCookies){
              System.out.println(cookie.toString());
              getDriver().manage().addCookie(cookie);
          }
      }*/
  }
