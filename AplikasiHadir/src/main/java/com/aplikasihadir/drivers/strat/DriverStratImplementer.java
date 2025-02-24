package com.aplikasihadir.drivers.strat;

import com.aplikasihadir.drivers.managers.ChromeDriverManager;
import com.aplikasihadir.drivers.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import com.aplikasihadir.drivers.utils.BrowserType;

public class DriverStratImplementer {
    public WebDriver setStrat(String strat){
        switch (strat){
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return ChromeDriverManager.make();
        }
    }
}
