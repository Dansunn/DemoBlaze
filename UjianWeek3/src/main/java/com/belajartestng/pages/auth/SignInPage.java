package com.belajartestng.pages.auth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private WebDriverException wait;

    @FindBy(id = "id_username")
    WebElement fieldUsername;;

    @FindBy(id = "id_password")
    WebElement fieldPW;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"content\"]/p")
    WebElement txtErrorLogin;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillUsername(String Username){
        fieldUsername.sendKeys(Username);
    }

    public void fillPW(String Password){
        fieldPW.sendKeys(Password);
    }

    public void clickBtnLogin(){
        btnLogin.click();
    }

    public void loginActivity(String Username, String Password) throws InterruptedException {
        fillUsername(Username);
        Thread.sleep(1500);
        fillPW(Password);
        Thread.sleep(1500);
        clickBtnLogin();
        Thread.sleep(1500);
    }

    public void clearFieldUsername() throws InterruptedException {
        fieldUsername.clear();
        Thread.sleep(1000);
    }

    public String getTxtErrorLogin(){
        waitTxtErrorLogin();
        return txtErrorLogin.getText();
    }

    public void waitTxtErrorLogin(){
        By locator = By.xpath("//*[@id=\"content\"]/p");
    }
}
