package com.demoblaze.steps.Navigation;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NextPage {

    private WebDriver driver;
    private MainPages mainPages;

    public NextPage(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on the first page")
    public void firstPage() throws InterruptedException {
        Thread.sleep(1000);
    }

    @When("User clicks the next page button")
    public void clickNextPage() throws InterruptedException {
        mainPages.clickNextPage();
        Thread.sleep(2000);
    }

    @Then("The next set of products should be displayed")
    public void verifyNextPage(){
        Assert.assertTrue(mainPages.product1NextPageisDisplayed(), "Halaman tidak berubah");
        Assert.assertTrue(mainPages.product2NextPageisDisplayed(), "Halaman tidak berubah");
    }
}
