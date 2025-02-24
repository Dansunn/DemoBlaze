package com.aplikasihadir.definitions;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.LoginPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginDefinition {

    private WebDriver driver;
    private LoginPages loginPages;

    public LoginDefinition(){
        this.driver = DriverSingleton.getDriver(BrowserType.CHROME);
        loginPages = new LoginPages(driver);
    }

    @Given("Pengguna membuka halaman login Hadir")
    public void bukaURL(){
        driver.get("https://magang.dikahadir.com/authentication/login");
    }

    @When("Pengguna memasukkan email {string} dan password {string}")
    public void fillEmailPassword(String email, String password) throws InterruptedException {
        loginPages.fillEmail(email);
        loginPages.fillPassword(password);
    }

    @And("Pengguna menekan tombol login")
    public void clickBtnMasuk() throws InterruptedException {
        loginPages.clickBtnMasuk();
    }

    @Then("Pengguna berhasil masuk ke halaman utama")
    public void verifyLogin(){
        String expected = driver.getCurrentUrl();
        String actual = "https://magang.dikahadir.com/dashboards/pending";
        Assert.assertEquals(expected, actual, "BERHASIL LOGIN!!");
    }

}
