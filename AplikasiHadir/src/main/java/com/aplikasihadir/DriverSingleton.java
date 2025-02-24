package com.aplikasihadir;

import com.aplikasihadir.drivers.strat.DriverStratImplementer;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser){
        if(driver == null){
            driver = new DriverStratImplementer().setStrat(browser);
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
