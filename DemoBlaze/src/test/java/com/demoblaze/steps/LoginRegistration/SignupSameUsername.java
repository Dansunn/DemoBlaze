package com.demoblaze.steps.LoginRegistration;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupSameUsername {
    private WebDriver driver;
    private MainPages mainPages;

    public SignupSameUsername(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User enters {string} and {string} as username and password again")
    public void fillUsernameandPasswordSU(String usernameSU, String passwordSU) throws InterruptedException {
        mainPages.clickMenuSignup();
        mainPages.fillUsernameSignup(usernameSU);
        mainPages.fillPasswordSignup(passwordSU);
    }

    @When("User clicks the sign-up button again")
    public void clickBtnSignup() throws InterruptedException {
        mainPages.clickBtnSignup();
    }

    @Then("User will see {string} as an error alert message")
    public void verifySignup(String expected) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String actual = alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expected, actual, "Alert Message tidak sesuai");
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        mainPages.clickBtncloseSU();
        mainPages.clickMenuHome();
    }
}
