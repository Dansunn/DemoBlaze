package com.belajartestng.authentication;

import com.belajartestng.drivers.DriverSingleton;
import com.belajartestng.drivers.utilities.BrowserType;
import com.belajartestng.pages.auth.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductTest {

    private ProductPage productPage;
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
    }

    @Test
    public void testAddProduct() throws InterruptedException {
        productPage = new ProductPage(driver);
        productPage.clickLinkProducts();
        productPage.clickBtnAddProduct();
        productPage.fillFieldTitle("Betadine 50ml");
        productPage.pilihKategori("Kesehatan");
        productPage.inputPrice("12000");
        productPage.inputStock("526");
        productPage.clickBtnSaveAddAnother();
    }
}
