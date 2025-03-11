package com.demoblaze.steps.Purchase;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;

public class AddToCart {

    private WebDriver driver;
    private MainPages mainPages;

    public AddToCart(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on a product page")
    public void onProductPage() throws InterruptedException {
        mainPages.clickMenuHome();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scroll({bottom: 800, behavior: 'smooth'})");
    }

    @When("User clicks on {string}")
    public void clickProduct(String product) throws InterruptedException {
        WebElement products = driver.findElement(By.xpath("//a[contains(.,'" + product + "')]"));
        Thread.sleep(2000);
        products.click();
        Thread.sleep(2000);
    }

    @And("User clicks add to cart button")
    public void clickBtnAddToCart() throws InterruptedException {
        mainPages.clickAddToCart();
    }

    @Then("The product should be added to the cart with a confirmation message {string} shown")
    public void verifyAddToCart(String expected) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String actual = alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expected, actual, "Alert Message tidak sesuai");
        alert.accept();
        Thread.sleep(2000);
    }

    @And("User clicks the home button")
    public void clickMenuHome() throws InterruptedException {
        mainPages.clickMenuHome();
    }
}
