package com.hybridframework.qa.driver.factory.interfaceBaseConfig;
import com.hybridframework.qa.constants.DriverType;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType driverType){
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManager();
            }
            case FIREFOX -> {
                return new FirefoxDriverManager();
            }
            case EDGE -> {
                return new EdgeDriverManager();
            }
            case IE -> {
                return new IEDriverManager();
            }
            case OPERA -> {
                return new OperaDriverManager();
            }
            case SAFARI -> {
                return new SafariDriverManager();
            }
            default -> throw new IllegalStateException("Invalid Driver: " + driverType);
        }
    }
}
