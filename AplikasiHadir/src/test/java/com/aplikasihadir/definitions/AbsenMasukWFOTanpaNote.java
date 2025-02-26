package com.aplikasihadir.definitions;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbsenMasukWFOTanpaNote {

    private WebDriver driver;
    private MainPage mainPage;

    public  AbsenMasukWFOTanpaNote(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        mainPage = new MainPage(driver);
    }

    @Given("user1 memulai proses absen masuk")
    public void clickAbsenMasuk() throws InterruptedException {
        mainPage.clickBtnAbsenMasuk();
    }

    @And("user1 menekan tombol kamera")
    public void clickBtnKamera() throws InterruptedException {
        mainPage.clickBtnKamera();
    }

    @And("user1 memilih tipe absen {string}")
    public void pilihTipeAbsen(String tipeAbsen) throws InterruptedException {
        mainPage.pilihTipeAbsen(tipeAbsen);
    }

    @When("user1 menekan absen masuk")
    public void clickBtnAbsenSetelahNote() throws InterruptedException {
        mainPage.clickBtnAbsenMasukSetelahNotes();
    }

    @And("user1 melakukan scroll halaman ke bawah")
    public void scrollToBottom() throws InterruptedException {
        Thread.sleep(1000);
        mainPage.ScrollToBottom();
    }

    @Then("user1 berhasil absen dengan pesan {string}")
    public void verifyAbsenMasuk(String expected) throws InterruptedException {
        String actual = mainPage.getTxtTanggalAbsen(expected);
        Assert.assertEquals(expected, actual);
    }
}
