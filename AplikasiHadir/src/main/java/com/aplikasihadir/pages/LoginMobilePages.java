package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginMobilePages {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnMasuk;

    public LoginMobilePages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmail(String email) throws InterruptedException {
        fieldEmail.sendKeys(email);
        Thread.sleep(1000);
    }

    public void fillPassword(String password) throws InterruptedException {
        fieldPassword.sendKeys(password);
        Thread.sleep(1000);
    }

    public void clickBtnMasuk() throws InterruptedException {
        btnMasuk.click();
        Thread.sleep(1000);
    }
}
