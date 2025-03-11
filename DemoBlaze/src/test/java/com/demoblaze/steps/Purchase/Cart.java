package com.demoblaze.steps.Purchase;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cart {

    private WebDriver driver;
    private MainPages mainPages;

    public Cart(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User fill all the information needed")
    public void clickMenuCart() throws InterruptedException {
        mainPages.clearCO();
        mainPages.fillCO();
        Thread.sleep(2000);
    }

    @When("User proceeds to purchase")
    public void clickBtnOrder() throws InterruptedException {
        mainPages.clickBtnPurchase();
    }

    @Then("User should see a success message confirming the order")
    public void verifyCheckout(){
        Assert.assertTrue(mainPages.popupSuccessisDisplayed(), "Pop up tidak muncul !!");
    }
}
