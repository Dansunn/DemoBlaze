package com.demoblaze.steps.Purchase;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductNavigation {

    private WebDriver driver;
    private MainPages mainPages;

    public ProductNavigation(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on the homepage")
    public void openURL() throws InterruptedException {
        Thread.sleep(2000);
    }

    @When("User clicks on a product category")
    public void clickCatLaptop() throws InterruptedException {
        mainPages.clickCatLaptop();
        Thread.sleep(3000);
    }

    @Then("Products from the selected category should be displayed")
    public void verifyCatLaptop() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(mainPages.catLaptop1isDisplayed(), "Produk tidak muncul");
        Assert.assertTrue(mainPages.catLaptop2isDisplayed(), "Produk tidak muncul");
    }
}
