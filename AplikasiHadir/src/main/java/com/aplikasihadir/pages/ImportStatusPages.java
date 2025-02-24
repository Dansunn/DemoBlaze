package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportStatusPages {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'sidebar__item')]/p[contains(text(), 'Import')]")
    private WebElement dropdownImport;

    @FindBy(xpath = "//p[contains(text(),'Import Status Aktif')]")
    private WebElement dropdownStatusAktif;

    @FindBy(xpath = "//input[@id='selfie']")
    private WebElement inputFileExcel;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSuccess MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedSuccess MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth css-yebgwc']")
    private WebElement btnDownloadTemplate;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-fullWidth css-5lyhfd']")
    private WebElement btnImport;

    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    private WebElement txtBerhasil;

    @FindBy(xpath = "//div[@class=\"MuiSnackbarContent-message css-1w0ym84\"]")
    private WebElement txtGagalImport;

    public ImportStatusPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickDropdownStatusAktif() throws InterruptedException {
        dropdownStatusAktif.click();
        Thread.sleep(2000);
    }

    public void clickDropdownImport() throws InterruptedException {
        dropdownImport.click();
        Thread.sleep(2000);
    }

    public void setInputFileExcel() throws InterruptedException {
        inputFileExcel.sendKeys("C:\\Users\\dansu\\Downloads\\DATA_STATUS_USER.xlsx");
        Thread.sleep(1000);
    }

    public void setInputFileExcelSalah() throws InterruptedException {
        inputFileExcel.sendKeys("C:\\Users\\dansu\\Downloads\\MainSolanoize.xaml");
        Thread.sleep(1000);
    }

    public void clickBtnImport() throws InterruptedException {
        btnImport.click();
        Thread.sleep(1000);
    }

    public void clickBtnTemplate() throws InterruptedException {
        btnDownloadTemplate.click();
        Thread.sleep(1000);
    }

    public String getTextBerhasil(){
        return txtBerhasil.getText();
    }

    public String getTextGagalImport(){
        return txtGagalImport.getText();
    }
}
