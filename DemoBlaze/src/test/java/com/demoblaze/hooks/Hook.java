package com.demoblaze.hooks;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hook {

    private static WebDriver driver;

    @BeforeAll
    public static void setup() throws InterruptedException {
        driver = DriverSingleton.getDriver(System.getProperty("browser", BrowserType.CHROME));
    }

    @AfterAll
    public static void teardown() throws InterruptedException {
        driver.quit();
    }
}
