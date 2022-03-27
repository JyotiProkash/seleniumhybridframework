package com.hybridframework.qa.utils;
import com.hybridframework.qa.constants.EnvType;

import java.util.Properties;

/**
 * Created by Jyoti on 13/04/2020
 */

public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        switch (EnvType.valueOf(env)) {
            case STAGE -> properties = PropertyUtils.propertyLoader("ConfigFiles","stage.properties");
            case PRODUCTION -> properties = PropertyUtils.propertyLoader("ConfigFiles","prod.properties");
            default -> throw new IllegalStateException("Invalid env type: " + env);
        }
    }

    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in the stg_config.properties file");
    }

    public String getUsername(){
        String prop = properties.getProperty("username");
        if(prop != null) return prop;
        else throw new RuntimeException("property username is not specified in the stg_config.properties file");
    }

    public String getPassword(){
        String prop = properties.getProperty("password");
        if(prop != null) return prop;
        else throw new RuntimeException("property password is not specified in the stg_config.properties file");
    }
    public String browserName(){
        String prop = properties.getProperty("browser");
        if(prop != null) return prop;
        else throw new RuntimeException("property browser is not specified in the stg_config.properties file");
    }
}