package com.aplikasihadir.hooks;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;

public class Hook {

    private WebDriver driver;

    @Before
    public void setup(){driver = DriverSingleton.getDriver(System.getProperty("browser", BrowserType.CHROME));
    }

    @After
    public void teardown(){
//        driver.quit();
    }
}
