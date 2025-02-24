package com.aplikasihadir.definitions;

import com.aplikasihadir.DriverSingleton;
import com.aplikasihadir.drivers.utils.BrowserType;
import com.aplikasihadir.pages.ImportStatusPages;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ImportStatusDefinition {

    private WebDriver driver;
    private ImportStatusPages importStatusPages;

    public ImportStatusDefinition(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        importStatusPages = new ImportStatusPages(driver);
    }

    @Given("Pengguna menekan tombol menu Import di bagian kiri menu")
    public void clickMenuImport() throws InterruptedException {
        importStatusPages.clickDropdownImport();
    }

    @And("Pengguna menekan tombol submenu Import Status Aktif")
    public void clickSubMenuStatusAktif() throws InterruptedException {
        importStatusPages.clickDropdownStatusAktif();
    }

    @When("Pengguna menekan tombol choose file dan memilih file excel yang diinginkan")
    public void clickBtnChooseFile() throws InterruptedException {
        importStatusPages.setInputFileExcel();
    }

    @And("Pengguna menekan tombol import")
    public void clickBtnImport() throws InterruptedException {
        importStatusPages.clickBtnImport();
    }

    @Then("Muncul notifikasi {string}")
    public void verifyImportExcel(String expected){
        String actual = importStatusPages.getTextBerhasil();
        Assert.assertEquals(expected, actual);

    }
}
