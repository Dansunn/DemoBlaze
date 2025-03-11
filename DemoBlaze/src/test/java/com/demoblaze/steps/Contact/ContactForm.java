package com.demoblaze.steps.Contact;

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

public class ContactForm {

    private WebDriver driver;
    private MainPages mainPages;

    public ContactForm(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }
    @Given("User is on the contact page again")
    public void openContactForm() throws InterruptedException {
        driver.get("https://www.demoblaze.com/index.html#");
        mainPages.clickMenuContact();
        Thread.sleep(2000);
    }

    @When("User fills in {string}, {string}, and {string}")
    public void fillContactForm(String name, String email, String message) throws InterruptedException {
        mainPages.fillContactForm(name, email, message);
    }

    @And("User submits the form")
    public void clickBtnSendMessage() throws InterruptedException {
        mainPages.clickBtnSendMessage();
    }

    @Then("User should see a success message {string}")
    public void verifySendMesaage(String expected) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String actual = alert.getText();
        Thread.sleep(2000);
        Assert.assertEquals(expected, actual, "Alert Message tidak sesuai");
        alert.accept();
        Thread.sleep(2000);
    }

    @And("User clicks home menu button")
    public void clickMenuHome() throws InterruptedException {
        mainPages.clickMenuHome();
    }
}
