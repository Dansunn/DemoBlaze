package com.demoblaze.steps.Navigation;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PreviousPage {
    private WebDriver driver;
    private MainPages mainPages;

    public PreviousPage(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on the second page of products")
    public void secondPage() throws InterruptedException {

    }

    @When("User clicks the previous page button")
    public void clickNextPage() throws InterruptedException {
        mainPages.clickPreviousPage();
        Thread.sleep(2000);
    }

    @Then("The first set of products should be displayed")
    public void verifyNextPage(){
        Assert.assertTrue(mainPages.product1PreviousPageisDisplayed(), "Halaman tidak berubah");
        Assert.assertTrue(mainPages.product2PreviousPageisDisplayed(), "Halaman tidak berubah");
    }
}
