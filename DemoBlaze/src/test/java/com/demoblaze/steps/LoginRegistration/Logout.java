package com.demoblaze.steps.LoginRegistration;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Logout {

    private WebDriver driver;
    private MainPages mainPages;

    public Logout(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is logged in")
    public void userLogIn(){

    }

    @When("User clicks the logout button")
    public void clickBtnLogout() throws InterruptedException {
        mainPages.clickBtnLogout();
    }

    @Then("User should be logged out and redirected to the homepage")
    public void verifyLogout(){
        Assert.assertTrue(mainPages.isWelcomeNotDisplayed(), "Logout tidak berhasil !!");
    }
}
