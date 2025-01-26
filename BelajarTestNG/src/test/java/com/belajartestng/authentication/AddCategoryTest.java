package com.belajartestng.authentication;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.drivers.utilities.BrowserType;
import com.belajartestng.pages.auth.CatPage;
import com.belajartestng.pages.auth.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddCategoryTest {
    private CatPage catPage;
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        catPage = new CatPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void testGagalAddCategory() throws InterruptedException {
        catPage.clickLinkCategory();
        catPage.clickBtnAddCategory();
        catPage.fillFieldNameCat(" ");
        catPage.clickBtnSaveCat();

        String actual = catPage.getTxtError();
        String expected = "Please correct the error below.";

        if (actual.equals(expected)) {
            System.out.println("Sudah Benar");
        } else {
            System.out.println("Terdapat Kesalahan");
            Assert.fail("Perbandingan gagal: actual tidak sama dengan expected");
        }

        Assert.assertTrue(actual.equals(expected));
        driver.navigate().refresh();
    }

    @Test (priority = 1)
    public void testAddCategory() throws InterruptedException {
      catPage.clickLinkCategory();
      catPage.clickBtnAddCategory();
      catPage.fillFieldNameCat("Kesehatan");
      catPage.clickBtnSaveCat();
    }

}
