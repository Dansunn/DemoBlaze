package com.aplikasihadir.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-ctijcz']")
    private WebElement btnAbsenMasuk;

    @FindBy(xpath = "//input[@name=\"notes\"]")
    private WebElement fieldNotes;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement btnAbsenMasukSetelahNotes;

    @FindBy(xpath = "//div[contains(text(), 'Anda berhasil melakukan absen hari ini')]")
    private WebElement txtBerhasilAbsen;

    @FindBy(xpath = "//p[contains(.,'Keluar')]")
    private WebElement btnKeluar;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnAbsenKeluar;

    @FindBy(xpath = "//textarea[@name='notes']")
    private WebElement fieldNotesKeluar;


    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        PageFactory.initElements(driver,this);
    }

    public void pilihTipeAbsen(String tipeAbsen) throws InterruptedException {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='combobox']")));
            dropdown.click();

            WebElement options = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '" + tipeAbsen + "')]")));
            options.click();
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Gagal Memilih Kategori : " + e.getMessage());
        }
        Thread.sleep(1000);
    }

    public void clickBtnKamera() throws InterruptedException {
//        WebElement btnKamera = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".feather-camera")));
//        WebElement btnKamera = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.MuiDialog-root.MuiModal-root.css-126xj0f > div.MuiDialog-container.MuiDialog-scrollPaper.css-ekeie0 > div > div > div > button")));
        WebDriverWait waitLoader = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean x = waitLoader.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[1]")));
        if (x) {
//            Thread.sleep(3000);
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("document.querySelector('.feather-camera').click()");
        }

//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(btnKamera)).click(); // Coba klik biasa
//        } catch (ElementClickInterceptedException e) {
//            System.out.println("ElementClickInterceptedException terjadi, mencoba klik dengan JavaScript...");
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("arguments[0].click();", btnKamera); // Klik paksa dengan JavaScript
//        }

        Thread.sleep(1000);
    }

    public void clickBtnAbsenMasuk() throws InterruptedException {
        Thread.sleep(2000);
        btnAbsenMasuk.click();
        Thread.sleep(8000);
    }

    public void fillNotes(String notes) throws InterruptedException {
        fieldNotes.sendKeys(notes);
        Thread.sleep(1000);
    }

    public void clickBtnAbsenMasukSetelahNotes() throws InterruptedException {
        btnAbsenMasukSetelahNotes.click();
        Thread.sleep(1000);
    }

    public String getTxtBerhasilAbsen() throws InterruptedException {
        Thread.sleep(1500);
        return txtBerhasilAbsen.getText();
    }

    public void clickBtnKeluar() throws InterruptedException {
        btnKeluar.click();
        Thread.sleep(1000);
    }

    public void clickBtnAbsenKeluar() throws InterruptedException {
        btnAbsenKeluar.click();
        Thread.sleep(1000);
    }

    public void fillNotesKeluar(String notes) throws InterruptedException {
        fieldNotesKeluar.sendKeys(notes);
        Thread.sleep(1000);
    }

    public String getTxtTanggalAbsen(String tanggal) throws InterruptedException {
        Thread.sleep(1000);
        WebElement txtTanggalAbsen = driver.findElement(By.xpath("//p[contains(.,'" + tanggal +"')]"));
        return txtTanggalAbsen.getText();
    }

    public void ScrollToBottom()throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy({top: 1000})");
        Thread.sleep(1000);
    }

    public boolean isBtnKeluarNotDisplayed(){
        return driver.findElements(By.xpath("//p[contains(.,'Keluar')]")).isEmpty();
    }
}
