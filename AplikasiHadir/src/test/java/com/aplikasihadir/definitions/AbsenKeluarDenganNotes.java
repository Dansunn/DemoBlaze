package com.aplikasihadir.definitions;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.MainPage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbsenKeluarDenganNotes {

    private WebDriver driver;
    private MainPage mainPage;

    public AbsenKeluarDenganNotes(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPage = new MainPage(driver);
    }

    @Given("user3 menekan tombol keluar pada history absensi")
    public void clickBtnKeluar() throws InterruptedException {
        mainPage.ScrollToBottom();
        mainPage.clickBtnKeluar();
    }

    @And("user3 mengisi {string} pada bagian notes pulang")
    public void fillNotesKeluar(String notes) throws InterruptedException {
        mainPage.fillNotesKeluar(notes);
    }

    @When("user3 menekan tombol absen keluar")
    public void clickBtnAbsenKeluar() throws InterruptedException {
        mainPage.clickBtnAbsenKeluar();
    }

    @Then("user3 berhasil melakukan absen keluar")
    public void verifyAbsenKeluar(){
        Assert.assertTrue(mainPage.isBtnKeluarNotDisplayed(), "Tombol Keluar masih tampil !!");
    }
}
