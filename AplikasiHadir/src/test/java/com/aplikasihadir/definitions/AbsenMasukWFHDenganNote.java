package com.aplikasihadir.definitions;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AbsenMasukWFHDenganNote {

    private WebDriver driver;
    private MainPage mainPage;

    public AbsenMasukWFHDenganNote(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPage = new MainPage(driver);
    }

    @Given("user4 memulai proses absen masuk")
    public void clickAbsenMasuk() throws InterruptedException {
        mainPage.clickBtnAbsenMasuk();
    }

    @And("user4 menekan tombol kamera")
    public void clickBtnKamera() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("xpath_tombol_kamera")));
        mainPage.clickBtnKamera();
    }

    @And("user4 memilih tipe absen {string}")
    public void pilihTipeAbsen(String tipeAbsen) throws InterruptedException {
        mainPage.pilihTipeAbsen(tipeAbsen);
    }

    @And("user4 mengisi {string} pada bagian notes")
    public void fillNotes(String notes) throws InterruptedException {
        mainPage.fillNotes(notes);
    }

    @When("user4 menekan absen masuk")
    public void clickBtnAbsenSetelahNote() throws InterruptedException {
        mainPage.clickBtnAbsenMasukSetelahNotes();
    }

    @And("user4 melakukan scroll halaman ke bawah")
    public void ScrollToTop() throws InterruptedException {
        mainPage.ScrollToBottom();
    }

    @Then("user4 berhasil absen dengan pesan {string}")
    public void verifyAbsenMasuk(String expected) throws InterruptedException {
        String actual = mainPage.getTxtBerhasilAbsen();
        Assert.assertEquals(expected, actual);
    }
}
