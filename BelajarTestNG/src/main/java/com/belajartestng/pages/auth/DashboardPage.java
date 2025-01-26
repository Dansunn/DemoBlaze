package com.belajartestng.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//h1[normalize-space()='Welcome to Demo SQA Testing Portal']")
    private WebElement welcomeHeadingElement;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public String getTextWelcomeHeading() {
        waitForWelcomeHeading();
        return welcomeHeadingElement.getText();
    }

    public void waitForWelcomeHeading(){
        By locator = By.xpath("//h1[normalize-space()='Welcome to Demo SQA Testing Portal']");
    }
}
