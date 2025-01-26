package com.belajartestng.drivers.strategies;

import com.belajartestng.drivers.managers.ChromeDriverManager;
import com.belajartestng.drivers.managers.FirefoxDriverManager;
import com.belajartestng.drivers.utilities.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverStrategyImplementer implements IdriverStrategies{

    @Override
    public WebDriver setStrat(String strategy) {
        switch (strategy){
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
            case BrowserType.FIREFOX:
                return FirefoxDriverManager.make();
            default:
                return  ChromeDriverManager.make();
        }
    }
}
