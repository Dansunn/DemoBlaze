package com.aplikasihadir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutMobilePages {

    private WebDriver driver;

    @FindBy(xpath = "//button[contains(@class, \"MuiButtonBase-root\")]/span[contains(@style, \"box-sizing\")]")
    private WebElement btnSideMenu;

    @FindBy(xpath = "//button[contains(.,'Logout')]")
    private WebElement btnLogout;

    public LogoutMobilePages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickBtnSideMenu() throws InterruptedException {
        Thread.sleep(1000);
        btnSideMenu.click();
        Thread.sleep(3000);
    }

    public void clickBtnLogout() throws InterruptedException {
        btnLogout.click();
        Thread.sleep(1000);
    }
}
