package com.belajartestng.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CatPage {

    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"products-category\"]/a")
    WebElement linkCategory;

    @FindBy(xpath = "//*[@id=\"content-main\"]/ul/li/a")
    WebElement btnAddCategory;

    @FindBy(xpath = "//*[@id=\"id_name\"]")
    WebElement fieldNameCategory;

    @FindBy(xpath = "//*[@id=\"category_form\"]/div/div/input[1]")
    WebElement btnSaveCategory;

    @FindBy(xpath = "//*[@id=\"category_form\"]/div/p")
    WebElement txtError;

    public CatPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickLinkCategory() throws InterruptedException {
        linkCategory.click();
        Thread.sleep(1500);
    }

    public void clickBtnAddCategory() throws InterruptedException {
        btnAddCategory.click();
        Thread.sleep(1500);
    }

    public void fillFieldNameCat(String namaCat) throws InterruptedException {
        fieldNameCategory.sendKeys(namaCat);
        Thread.sleep(1500);
    }

    public void clickBtnSaveCat() throws InterruptedException {
        btnSaveCategory.click();
        Thread.sleep(1500);
    }

    public void waitForTxtError(){
        By locator = By.xpath("//*[@id=\"category_form\"]/div/p");
    }

    public String getTxtError(){
        waitForTxtError();
        return txtError.getText();
    }

}
