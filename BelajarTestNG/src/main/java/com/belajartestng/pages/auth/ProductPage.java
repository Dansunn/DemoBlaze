package com.belajartestng.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;


    @FindBy(xpath = "//*[@id=\"products-product\"]/a")
    WebElement linkProducts;

    @FindBy(xpath = "//*[@id=\"content-main\"]/ul/li/a")
    WebElement btnAddProduct;

    @FindBy(xpath = "//input[@name='title']")
    WebElement fieldTitle;

    @FindBy(xpath = "//*[@id=\"id_category\"]")
    WebElement selectCategory;

    @FindBy(xpath = "//input[@name='price']")
    WebElement inputPrice;

    @FindBy(xpath = "//input[@name='stock']")
    WebElement inputStock;



    @FindBy(xpath = "//*[@id=\"product_form\"]/div/div/input[2]")
    WebElement btnSaveAddAnother;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickLinkProducts() throws InterruptedException {
        linkProducts.click();
        Thread.sleep(1500);
    }

    public void clickBtnAddProduct() throws InterruptedException {
        btnAddProduct.click();
        Thread.sleep(1500);
    }

    public void fillFieldTitle(String namaProduk) throws InterruptedException {
        fieldTitle.sendKeys(namaProduk);
        Thread.sleep(1500);
    }

    public void pilihKategori(String namaKategori) throws InterruptedException {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectCategory));

            Select dropdown = new Select(selectCategory);
            dropdown.selectByVisibleText(namaKategori);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Gagal memilih kategori: " + e.getMessage());
        }
        Thread.sleep(1500);
    }

    public void inputPrice(String harga) throws InterruptedException {
        inputPrice.clear();
        Thread.sleep(1000);
        inputPrice.sendKeys(harga);
        Thread.sleep(1500);
    }

    public void inputStock(String stok) throws InterruptedException {
        inputStock.clear();
        Thread.sleep(1000);
        inputStock.sendKeys(stok);
        Thread.sleep(1500);
    }

    public void clickBtnSaveAddAnother() throws InterruptedException {
        btnSaveAddAnother.click();
        Thread.sleep(1500);
    }


}
