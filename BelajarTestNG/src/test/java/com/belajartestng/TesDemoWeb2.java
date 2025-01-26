package com.belajartestng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TesDemoWeb2 {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private final String Id = "Dansunn";
    private final String Password = "Zxcasdqwe123";

    @BeforeTest
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver(options);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("http://localhost:8000/admin");
    }

    @Test
    public void testLogin() {
        WebElement fieldUsername = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_username")));
        WebElement fieldPassword = webDriver.findElement(By.id("id_password"));
        WebElement btnLogin = webDriver.findElement(By.cssSelector("#login-form input[type='submit']"));

        fieldUsername.sendKeys(Id);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        fieldPassword.sendKeys(Password);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        btnLogin.click();

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1"))).getText();
        Assert.assertEquals(actual, expected, "Login verification failed.");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testAddUser() throws InterruptedException {
        WebElement btnAddUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/admin/auth/user/add/']")));
        btnAddUser.click();

        WebElement formUsername = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_username")));
        WebElement formPassword = webDriver.findElement(By.id("id_password1"));
        WebElement formRePassword = webDriver.findElement(By.id("id_password2"));
        WebElement btnSave = webDriver.findElement(By.cssSelector("#user_form input[type='submit']"));

        formUsername.sendKeys("Prometheus");
        Thread.sleep(2000);
        formPassword.sendKeys("Natalia1511!");
        Thread.sleep(2000);
        formRePassword.sendKeys("Natalia1511!");
        Thread.sleep(2000);
        btnSave.click();
        Thread.sleep(2000);

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
        Assert.assertTrue(successMessage.getText().contains("was added successfully"), "User addition failed.");
    }
}

