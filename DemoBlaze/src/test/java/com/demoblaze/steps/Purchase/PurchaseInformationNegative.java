package com.demoblaze.steps.Purchase;

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

public class PurchaseInformationNegative {

    private WebDriver driver;
    private MainPages mainPages;

    public PurchaseInformationNegative(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User has added products to the cart")
    public void clickMenuCart() throws InterruptedException {
        mainPages.clickMenuCart();
    }

    @When("User proceeds to checkout")
    public void clickBtnOrder() throws InterruptedException {
        mainPages.clickBtnOrder();
    }

    @And("User enters payment details but not fill the name and credit card")
    public void fillNotAllCO() throws InterruptedException {
        mainPages.fillNotAllCO();
        mainPages.clickBtnPurchase();
        Thread.sleep(2000);
    }

    @Then("User should see an error message {string}")
    public void verifyError(String expected) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String actual = alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expected, actual, "Alert Message tidak sesuai");
        alert.accept();
        Thread.sleep(2000);
    }
}
