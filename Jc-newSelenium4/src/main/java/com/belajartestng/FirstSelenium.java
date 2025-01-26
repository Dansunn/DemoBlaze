package com.belajartestng;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class FirstSelenium {
    static WebDriver webDriver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        webDriver.get("https://www.saucedemo.com/");
        loginGagal();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        login("standard_user", "secret_sauce");
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        WebElement txtProducts = webDriver.findElement(By.xpath("//span[@class='title']"));
        String actual = txtProducts.getText();
        String expected = "Products";
        contohValidasi(actual,expected);

        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        AddAllProductToCart();
        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        listProduct();

//        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        lihatProduk();
//        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        tambahProduk();
//        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        menuCart();
//        webDriver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
//        logout();

        webDriver.quit();


    }

    private static void loginGagal() throws InterruptedException {
        WebElement fieldUsername = webDriver.findElement(By.id("user-name"));
        WebElement fieldPassword = webDriver.findElement(By.id("password"));
        WebElement btnLogin = webDriver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        fieldUsername.sendKeys("sadsasd");
        Thread.sleep(1000);
        fieldPassword.sendKeys("sesauce");
        Thread.sleep(1000);
        btnLogin.click();
        Thread.sleep(2000);
    }

    private static void login(String Username, String Password) throws InterruptedException {
        WebElement fieldUsername = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        WebElement fieldPassword = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        WebElement btnLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login-button\"]")));

        fieldUsername.clear();
        fieldUsername.sendKeys(Username);
        Thread.sleep(1000);
        fieldPassword.clear();
        fieldPassword.sendKeys(Password);
        Thread.sleep(1000);
        btnLogin.click();
        Thread.sleep(2000);

        if (isLoginFailed(webDriver)){
            System.out.println("Kesalahan Password atau Username dengan Username : " + Username);
        }
        else {
            System.out.println("Login Berhasil dengan username : " + Username);
        }
    }

    private static void logout() throws InterruptedException {
        WebElement btnMenu = webDriver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]"));
        WebElement btnLogOut = webDriver.findElement(By.id("logout_sidebar_link"));
        btnMenu.click();
        Thread.sleep(1000);
        btnLogOut.click();
    }

    public static boolean isLoginFailed(WebDriver webDriver){
        try {
            WebElement errorMsg = webDriver.findElement(By.xpath("//h3[@data-test='error']"));
            return errorMsg.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public static void listProduct(){
        List<WebElement> listProduct =webDriver.findElements(By.xpath("//div[@class='inventory_item_name ']"));
        List<WebElement> listHarga = webDriver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
        double hargaTotal = 0;

        if(listProduct.isEmpty()){
            System.out.println("Tidak ditemukan produk apapun");
        }
        else {
            System.out.println("Produk ditemukan");
            for (WebElement element : listProduct){
                System.out.println("Produk ke " + (listProduct.indexOf(element)+1) +" : "+ element.getText());
            }
        }
        if(listHarga.isEmpty()){
            System.out.println("Harga produk tidak ditemukan");
        }
        else{
            for(WebElement element : listHarga){
                String harga = element.getText();
                double hargaConv = Double.parseDouble(harga.replace("$", ""));
                System.out.println("Produk Ke " + (listHarga.indexOf(element)+1) + " memiliki harga : " + hargaConv);
                hargaTotal += hargaConv;
            }
            System.out.println("Total Harga = " + hargaTotal);
        }
    }

    public static void AddAllProductToCart() throws InterruptedException {
        List<WebElement> btnAddProduct= webDriver.findElements(By.xpath(("//button[contains(@class, 'btn_inventory')]")));

        if (btnAddProduct.isEmpty()){
            System.out.println("Button Tidak Ditemukan");
        }
        else{
            for (WebElement element : btnAddProduct){
                element.click();
                Thread.sleep(1000);
            }
        }
    }

    private static void lihatProduk() throws InterruptedException {
        WebElement product1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        // Klik produk pertama
        System.out.println("Klik produk pertama");
        product1.click();
        Thread.sleep(1000);
        WebElement btnBack = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#back-to-products")));
        System.out.println("Kembali ke halaman produk");
        btnBack.click();
        Thread.sleep(1000);

        System.out.println("Temukan ulang produk kedua");
        WebElement product2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item_0_title_link\"]/div")));
        System.out.println("Klik produk kedua");
        product2.click();
        Thread.sleep(1000);

        // Temukan ulang tombol back
        btnBack = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#back-to-products")));
        System.out.println("Kembali ke halaman produk");
        btnBack.click();
        Thread.sleep(1000);
    }

    public static void tambahProduk() throws InterruptedException {
        WebElement product1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item_4_title_link\"]/div")));
        System.out.println("Klik produk pertama");
        product1.click();
        Thread.sleep(1500);

        WebElement btnAddToCart = webDriver.findElement(By.xpath("//*[@id=\"add-to-cart\"]"));
        System.out.println("Add Product 1");
        btnAddToCart.click();
        Thread.sleep(1000);
    }

    public static void menuCart() throws InterruptedException {
        WebElement btnCart = webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
        btnCart.click();
        Thread.sleep(1000);
        WebElement btnContinueShopping = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"continue-shopping\"]")));
        btnContinueShopping.click();
        Thread.sleep(1000);
    }

    public static void contohValidasi(String actual, String expected){
        if(actual.equals(expected)){
            System.out.println("Sesuai ekspektasi");
        }
        else{
            System.out.println("Tidak sesuai ekspektasi");
        }
    }
}

