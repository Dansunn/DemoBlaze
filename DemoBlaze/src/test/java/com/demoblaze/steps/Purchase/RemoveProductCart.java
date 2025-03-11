package com.demoblaze.steps.Purchase;

import com.demoblaze.DriverSingleton;
import com.demoblaze.drivers.utils.BrowserType;
import com.demoblaze.pages.MainPages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RemoveProductCart {

    private WebDriver driver;
    private MainPages mainPages;

    public RemoveProductCart(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User has products in the cart")
    public void verifyProductinCart() throws InterruptedException {
        mainPages.clickMenuCart();
        Thread.sleep(2000);
        mainPages.isProductCart1Displayed();
        mainPages.isProductCart2Displayed();
        mainPages.isProductCart3Displayed();
    }

    @When("User removes a product from the cart")
    public void removeProductinCart() throws InterruptedException {
        WebElement btnDelete = driver.findElement(By.xpath("//td[text()='Nexus 6']/following-sibling::td/a[contains(text(), 'Delete')]"));
        btnDelete.click();
        Thread.sleep(2000);
    }

    @Then("The product should no longer be in the cart")
    public void verifyRemoveProduct(){
        Assert.assertTrue(mainPages.isNexus6NotDisplayed(), "Product masih ada dalam cart !!");
    }
}
