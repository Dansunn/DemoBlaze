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

public class Signup {

    private WebDriver driver;
    private MainPages mainPages;

    public Signup(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on the signup page")
    public void bukaURL() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html");
        Thread.sleep(2000);
        mainPages.clickMenuSignup();
    }

    @When("User enters {string} and {string} as username and password")
    public void fillUsernameandPasswordSU(String usernameSU, String passwordSU) throws InterruptedException {
        mainPages.fillUsernameSignup(usernameSU);
        mainPages.fillPasswordSignup(passwordSU);
    }

    @And("User clicks the sign-up button")
    public void clickBtnSignup() throws InterruptedException {
        mainPages.clickBtnSignup();
    }

    @Then("User will see {string} as an alert successful message")
    public void verifyAlert(String expected) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String actual = alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expected, actual, "Alert Message tidak sesuai");
        alert.accept();
        mainPages.clickMenuHome();
    }


}
