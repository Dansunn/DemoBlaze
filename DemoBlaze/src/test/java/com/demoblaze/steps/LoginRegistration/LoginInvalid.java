package com.demoblaze.steps.LoginRegistration;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginInvalid {

    private WebDriver driver;
    private MainPages mainPages;

    public LoginInvalid(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on the login page")
    public void clickMenuLogin() throws InterruptedException {
        Thread.sleep(2000);
        mainPages.clickMenuLogin();
    }

    @When("User enters {string} and {string} as an invalid username and password")
    public void fillUsernameandPasswordLogin(String username, String password) throws InterruptedException {
        mainPages.fillUsername(username);
        mainPages.fillPassword(password);
    }

    @And("User clicks the login button again")
    public void clickBtnLogin() throws InterruptedException {
        mainPages.clickBtnLogin();
    }

    @Then("User should see {string} as an error message")
    public void verifyLogin(String expected) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String actual = alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expected, actual, "Alert Message tidak sesuai");
        alert.accept();
        Thread.sleep(2000);
        mainPages.clickBtnClose();
    }
}
