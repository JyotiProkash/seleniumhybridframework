package com.hybridframework.qa.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.hybridframework.qa.helper.resource.ResourceHelper;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jyoti 22/04/2020
 */
public class ExtentManager
  {
      private static ExtentReports extent;
      public static ExtentReports getInstance(String browser) {
            if(extent==null) {
                return createInstance(browser);
            }

            else
              {
                  return extent;
              }
        }

      private static ExtentReports createInstance(String browser){
            //Date d=new Date();
            //String fileName="AutomationReport_"+d.toString().replace(":","_").replace(" ","_")+".html";
            String fileName="ExtentReport.html";
            String directory=ResourceHelper.getResourcePath("src/test/output/TestReport/");
            new File(directory).mkdirs();
            String path=directory+fileName;
/*          ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
            htmlReporter.config().setDocumentTitle("Selenium Automation");
            htmlReporter.config().setTheme(Theme.STANDARD);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName("Automation Execution Report");
            htmlReporter.loadXMLConfig("extent-config.xml");*/
            final File CONF = new File("extent-config.xml");
            ExtentSparkReporter spark = new ExtentSparkReporter(path);
/*          spark.config().setDocumentTitle("Selenium Automation");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setEncoding("utf-8");
            spark.config().setReportName("Automation Execution Report");*/
          try {
              spark.loadXMLConfig(CONF);
          } catch (IOException e) {
              e.printStackTrace();
          }


          extent=new ExtentReports();
            extent.setSystemInfo("Application Name", "ExtentReport");
            extent.setSystemInfo("Platform", System.getProperty("os.name"));
            extent.setSystemInfo("Environment", "STG");
            extent.setSystemInfo("Browser Name", browser);
            extent.attachReporter(spark);
            return extent;

        }
  }

