package com.hybridframework.qa.driver.factory.abstractBaseConfig;

import com.hybridframework.qa.constants.DriverType;

public class DriverManagerFactoryAbstract {

    public static DriverManagerAbstract getManager(DriverType driverType){
        switch (driverType){
            case CHROME -> {
                return new ChromeDriverManagerAbstract();
            }
            case FIREFOX -> {
                return new FirefoxDriverManagerAbstract();
            }
            case EDGE -> {
                return new EdgeDriverManagerAbstract();
            }
            case IE -> {
                return new IEDriverManagerAbstract();
            }
            case OPERA -> {
                return new OperaDriverManagerAbstract();
            }
            case SAFARI -> {
                return new SafariDriverManagerAbstract();
            }
            default -> throw new IllegalStateException("Invalid Driver: " + driverType);
        }
    }
}
