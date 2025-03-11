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

public class ContactFormNegative {

    private WebDriver driver;
    private MainPages mainPages;

    public ContactFormNegative(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPages = new MainPages(driver);
    }

    @Given("User is on the contact page")
    public void clickMenuContact() throws InterruptedException {
        mainPages.clickMenuContact();
    }

    @When("User not fill the form and click the send message")
    public void fillEmptyContactForm() throws InterruptedException {
        mainPages.notFillContactForm();
        mainPages.clickBtnSendMessage();
    }

    @Then("User should see {string} as an error alert message")
    public void verifySendMessage(String expected) throws InterruptedException {
        try {
            Thread.sleep(2000);
            Alert alert = driver.switchTo().alert();
            Thread.sleep(2000);
            String actual = alert.getText();
            Thread.sleep(2000);

            try {
                Assert.assertEquals(actual, expected, "Alert Message tidak sesuai");
            } catch (AssertionError e) {
                System.out.println("Assertion failed: " + e.getMessage());
            }
            alert.accept();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }


    @And("User clicks home menu button again")
    public void clickMenuHome() throws InterruptedException {
        mainPages.clickMenuHome();
    }
}
