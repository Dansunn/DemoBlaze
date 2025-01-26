package com.belajartestng.authentication;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.drivers.utilities.BrowserType;
import com.belajartestng.pages.auth.ProductPage;
import com.belajartestng.pages.auth.DashboardPage;
import com.belajartestng.pages.auth.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignInTest {
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private ProductPage productPage;
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void testGagalSignIn() throws InterruptedException {
        driver.get("http://localhost:8000/admin");
        signInPage.loginActivity("asd", "asd");

        String actual = signInPage.getTxtErrorLogin();
        String expected = "Please enter the correct username and password for a staff account. Note that both fields may be case-sensitive.";

        if (actual.equals(expected)){
            System.out.println("Error Login Sudah Sesuai");
        }
        else {
            System.out.println("Terdapat Kesalahan");
            Assert.fail("(Login) Perbandingan gagal: actual tidak sama dengan expected");
        }

    }

    @Test (priority = 1)
    public void signInTest() throws InterruptedException {
        signInPage.clearFieldUsername();
        signInPage.loginActivity("Dansunn", "Zxcasdqwe123");

        dashboardPage = new DashboardPage(driver);

        String Expected = "Welcome to Demo SQA Testing Portal";
        String Actual = dashboardPage.getTextWelcomeHeading();

        Assert.assertTrue(Actual.toLowerCase().equals(Expected.toLowerCase()));

    }
}
