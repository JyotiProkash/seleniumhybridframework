package com.hybridframework.qa.utils;

import com.hybridframework.qa.helper.resource.ResourceHelper;

import java.io.*;
import java.util.Properties;

/**
 * Created by Jyoti on 12/04/2020
 */

public class PropertyUtils
  {
      public static Properties properties;

      /**
       * This method will help to find any of property file.
       * @param nameOfPropertyFile
       * @param folderName
       * @return
       * @throws IOException
       */
      public static Properties propertyLoader(String folderName, String nameOfPropertyFile)
        {

            try {
                FileInputStream fs=new FileInputStream(ResourceHelper.getResourcePath("src/main/resources/")+folderName+"/"+nameOfPropertyFile);

                try {
                    properties=new Properties();
                    properties.load(fs);
                    fs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("failed to load properties file "+ nameOfPropertyFile);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("properties file not found at " + nameOfPropertyFile);
            }
            return properties;
        }

      /**
       * This method will help to find any of property file.
       * @param nameOfPropertyFile
       * @return
       * @throws IOException
       */
      public static Properties propertyLoader(String nameOfPropertyFile)
      {

          try {
              FileInputStream fs=new FileInputStream(ResourceHelper.getResourcePath("src/main/resources/")+nameOfPropertyFile);

              try {
                  properties=new Properties();
                  properties.load(fs);
                  fs.close();
              } catch (IOException e) {
                  e.printStackTrace();
                  throw new RuntimeException("failed to load properties file "+ nameOfPropertyFile);
              }
          } catch (FileNotFoundException e) {
              e.printStackTrace();
              throw new RuntimeException("properties file not found at " + nameOfPropertyFile);
          }
          return properties;
      }
  }
