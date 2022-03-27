package com.hybridframework.qa.helper.logger;

import com.hybridframework.qa.utils.PropertyUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;

public class LoggerHelper
  {
      /**
       * Created by Jyoti 14/04/2020
       * @Method getLogger
       */

      private static boolean root=false;

      /**
       * This method will help to generate log.
       * @param classname
       * @return
       * @throws IOException
       */
      public static Logger getLogger(Class classname) throws IOException
         {
             if(root)
               {
                   return Logger.getLogger(classname);
               }
             PropertyConfigurator.configure(PropertyUtils.propertyLoader("log4j.properties"));
             root=true;
             return Logger.getLogger(classname);
         }

  }
