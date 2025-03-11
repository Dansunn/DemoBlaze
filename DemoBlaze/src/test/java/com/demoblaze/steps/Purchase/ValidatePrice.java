package com.demoblaze.steps.Purchase;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ValidatePrice {

    private WebDriver driver;
    private MainPages mainPages;
    int hargaSebelum, hargaSesudah;

    public ValidatePrice(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User see the current total price")
    public void verifyProductCart() throws InterruptedException {
        Thread.sleep(2000);
        hargaSebelum = mainPages.getTotalCartPrice();
        System.out.println(hargaSebelum);
    }

    @When("User removes the first product from the cart")
    public void removeProduct() throws InterruptedException {
        mainPages.deleteFirstProduct();
        Thread.sleep(2000);
        hargaSesudah = mainPages.getTotalCartPrice();
        System.out.println(hargaSesudah);
    }

    @Then("The total price should be updated accordingly")
    public void verifyPrice() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(hargaSesudah < hargaSebelum, "Terdapat Kesalahan !!!");
    }
}
