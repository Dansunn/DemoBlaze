package com.aplikasihadir.hooks;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.LoginMobilePages;
import com.aplikasihadir.pages.LogoutMobilePages;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

public class Hook {

    private WebDriver driver;
    private LoginMobilePages loginMobilePages;
    private LogoutMobilePages logoutMobilePages;
    private String email;
    private String password;

    @Before
    public void setup(Scenario scenario) throws InterruptedException {
        driver = DriverSingleton.getDriver(System.getProperty("browser", BrowserType.CHROME));
        loginMobilePages = new LoginMobilePages(driver);

        if (scenario.getName().contains("User1")){
//            email = "hadirsqa13@gmail.com";
//            password = "SQA@Hadir12345";
            email = "hadirsqa11@gmail.com";
            password = "SQA@Hadir12345";
        }
        else if (scenario.getName().contains("User2")){
            email = "hadirsqa11@gmail.com";
            password = "SQA@Hadir12345";
        } else if (scenario.getName().contains("User3")){
//            email = "hadirsqa12@gmail.com";
//            password = "SQA@Hadir12345";
            email = "hadirsqa11@gmail.com";
            password = "SQA@Hadir12345";
        }
        else if(scenario.getName().contains("User4")){
            email = "hadirsqa11@gmail.com";
            password = "SQA@Hadir12345";
        }

        driver.get("https://magang.dikahadir.com/absen/login");

        loginMobilePages.fillEmail(email);
        loginMobilePages.fillPassword(password);
        loginMobilePages.clickBtnMasuk();
    }


    @After
    public void teardown() throws InterruptedException {
        logoutMobilePages = new LogoutMobilePages(driver);
        logoutMobilePages.clickBtnSideMenu();
        logoutMobilePages.clickBtnLogout();
    }
}
