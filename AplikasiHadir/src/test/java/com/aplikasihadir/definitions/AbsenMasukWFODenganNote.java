package com.aplikasihadir.definitions;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbsenMasukWFODenganNote {

    private WebDriver driver;
    private MainPage mainPage;

    public AbsenMasukWFODenganNote(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPage = new MainPage(driver);
    }

    @Given("user3 memulai proses absen masuk")
    public void clickAbsenMasuk() throws InterruptedException {
        mainPage.clickBtnAbsenMasuk();
    }

    @And("user3 menekan tombol kamera")
    public void clickBtnKamera() throws InterruptedException {
        mainPage.clickBtnKamera();
    }

    @And("user3 memilih tipe absen {string}")
    public void pilihTipeAbsen(String tipeAbsen) throws InterruptedException {
        mainPage.pilihTipeAbsen(tipeAbsen);
    }

    @And("user3 mengisi {string} pada bagian notes")
    public void fillNotes(String notes) throws InterruptedException {
        mainPage.fillNotes(notes);
    }

    @When("user3 menekan absen masuk")
    public void clickBtnAbsenSetelahNote() throws InterruptedException {
        mainPage.clickBtnAbsenMasukSetelahNotes();
    }
    @And("user3 melakukan scroll halaman ke bawah")
    public void ScrollToTop() throws InterruptedException {
        mainPage.ScrollToBottom();
    }

    @Then("user3 berhasil absen dengan pesan {string}")
    public void verifyAbsenMasuk(String expected) throws InterruptedException {
        String actual = mainPage.getTxtTanggalAbsen(expected);
        Assert.assertEquals(expected, actual);
    }
}
