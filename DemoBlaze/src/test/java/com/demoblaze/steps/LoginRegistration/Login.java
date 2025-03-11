package com.demoblaze.steps.LoginRegistration;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login {

    private WebDriver driver;
    private MainPages mainPages;

    public Login(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on the login page again")
    public void bukaURL() throws InterruptedException {
        mainPages.clickMenuLogin();
        mainPages.clearUsernameandPassword();
    }

    @When("User enters {string} and {string}")
    public void fillUsernameandPasswordLogin(String username, String password) throws InterruptedException {
        mainPages.fillUsername(username);
        mainPages.fillPassword(password);
    }

    @And("User clicks the login button")
    public void clickBtnLogin() throws InterruptedException {
        mainPages.clickBtnLogin();
        Thread.sleep(3000);
    }

    @Then("User should see {string}")
    public void verifyLogin(String expected) throws InterruptedException {
        Thread.sleep(5000);
        String actual = mainPages.getTxtWelcome(expected);
        Assert.assertEquals(expected, actual, "Text Welcome tidak sesuai !!");
    }
}
