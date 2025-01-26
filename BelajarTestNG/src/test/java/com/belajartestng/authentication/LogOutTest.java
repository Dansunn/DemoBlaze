package com.belajartestng.authentication;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.drivers.utilities.BrowserType;
import com.belajartestng.pages.auth.DashboardPage;
import com.belajartestng.pages.auth.LogoutPage;
import com.belajartestng.pages.auth.ProductPage;
import com.belajartestng.pages.auth.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogOutTest {

    private LogoutPage logOutPage;
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        logOutPage = new LogoutPage(driver);
    }

    @Test
    public void testLogOut() throws InterruptedException {
        logOutPage.clickBtnLogout();
    }
}
