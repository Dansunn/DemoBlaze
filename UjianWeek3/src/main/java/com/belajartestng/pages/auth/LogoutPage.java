package com.belajartestng.pages.auth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {

    private WebDriverWait wait;
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"logout-form\"]/button")
    WebElement btnLogOut;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

    public void clickBtnLogout() throws InterruptedException {
        btnLogOut.click();
        Thread.sleep(1000);
        driver.quit();
    }
}
