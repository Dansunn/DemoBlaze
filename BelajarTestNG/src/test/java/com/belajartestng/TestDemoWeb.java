package com.belajartestng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestDemoWeb {
    private WebDriver webDriver;
    private WebDriverWait wait;
    private ChromeOptions options;
    String Id = "Dansunn";
    String Password = "Zxcasdqwe123";

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        webDriver.get("http://localhost:8000/admin");
    }

    @Test
    public void testGagalLogin() throws InterruptedException {
        WebElement fieldUsername = webDriver.findElement(By.id("id_username"));
        WebElement fieldPassword = webDriver.findElement(By.id("id_password"));
        WebElement btnLogin = webDriver.findElement(By.cssSelector("#login-form input[type='submit']"));
        fieldUsername.sendKeys("Darren");
        Thread.sleep(1000);
        fieldPassword.sendKeys("Jelek Banget");
        Thread.sleep(1000);
        btnLogin.click();
        Thread.sleep(1000);
        fieldUsername = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_username")));
        fieldUsername.clear();

//        String expected = "Welcome to Demo SQA Testing Portal";
//        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1"))).getText();
//        Assert.assertEquals(actual, expected, "Login verification failed.");
    }

    @Test
    public void testLogin() throws InterruptedException {
        WebElement fieldUsername = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_username")));
        WebElement fieldPassword = webDriver.findElement(By.id("id_password"));
        WebElement btnLogin = webDriver.findElement(By.cssSelector("#login-form input[type='submit']"));
        fieldUsername.sendKeys(Id);
        Thread.sleep(1000);
        fieldPassword.sendKeys(Password);
        Thread.sleep(1000);
        btnLogin.click();

        String expected = "Welcome to Demo SQA Testing Portal";
        String actual = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/h1"))).getText();
        Assert.assertEquals(actual, expected, "Login verification failed.");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testAddUsers() throws InterruptedException {
        WebElement btnAddUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/admin/auth/user/add/']")));
        btnAddUser.click();

        WebElement formUsername = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_username")));
        WebElement formPassword = webDriver.findElement(By.id("id_password1"));
        WebElement formRePassword = webDriver.findElement(By.id("id_password2"));
        WebElement btnSaveAddAnother = webDriver.findElement(By.xpath("//*[@id=\"user_form\"]/div/div/input[2]"));

        formUsername.sendKeys("Ajojing");
        Thread.sleep(1000);
        formPassword.sendKeys("Alaala123");
        Thread.sleep(1000);
        formRePassword.sendKeys("Alaala123");
        Thread.sleep(1000);
        btnSaveAddAnother.click();
        Thread.sleep(1000);

        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
        Assert.assertTrue(successMessage.getText().contains("was added successfully"), "User addition failed.");
    }

    @Test(dependsOnMethods = {"testAddUsers"})
    public void testAddUsersNamaPasswordSama() throws InterruptedException {
        // Tunggu elemen tersedia di halaman baru
        WebElement formUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_username")));
        WebElement formPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_password1")));
        WebElement formRePassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_password2")));
        WebElement btnSaveAddAnother = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"user_form\"]/div/div/input[2]")));

        // Hapus data sebelumnya dan masukkan data baru
        formUsername.clear();
        formUsername.sendKeys("Patrick");
        Thread.sleep(1000);
        formPassword.clear();
        formPassword.sendKeys("ThisIsPatrick");
        Thread.sleep(1000);
        formRePassword.clear();
        formRePassword.sendKeys("ThisIsPatrick");
        Thread.sleep(1000);
        btnSaveAddAnother.click();
        Thread.sleep(1000);
    }

    @Test (dependsOnMethods = {"testAddUsersNamaPasswordSama"})
    public void testLogout() throws InterruptedException {
        WebElement btnLogout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"logout-form\"]/button")));
        btnLogout.click();
        Thread.sleep(1000);
    }
}


