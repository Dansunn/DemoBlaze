package com.demoblaze.drivers.strat;

import com.demoblaze.drivers.managers.ChromeDriverManager;
import com.demoblaze.drivers.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import com.demoblaze.drivers.utils.BrowserType;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverStratImplementer{

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
