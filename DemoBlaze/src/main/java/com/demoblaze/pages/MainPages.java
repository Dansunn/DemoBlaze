package com.demoblaze.pages;

import com.aventstack.extentreports.gson.ThrowableTypeAdapter;
import com.demoblaze.DriverSingleton;
import io.cucumber.java.zh_cn.假如;
import jdk.tools.jmod.Main;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.regex.Pattern;

public class MainPages {

    private WebDriver driver;

    @FindBy(xpath = "//a[@id='login2']")
    private WebElement menuLogin;

    @FindBy(xpath = "//a[@id='signin2']")
    private WebElement menuSignup;

    @FindBy(xpath = "//li[contains(.,'Home')]")
    private WebElement menuHome;

    @FindBy(xpath = "//input[@id='loginusername']")
    private WebElement fieldUsername;

    @FindBy(xpath = "//input[@id='loginpassword']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")
    private WebElement btnClose;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    private WebElement btnLogin;

    @FindBy(xpath = "//input[@id='sign-username']")
    private WebElement signupUsername;

    @FindBy(xpath = "//input[@id='sign-password']")
    private WebElement signupPassword;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    private WebElement btnSignup;

    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
    private WebElement btnCloseSU;

    @FindBy(xpath = "//a[.='Log out']")
    private WebElement btnLogout;

    @FindBy(xpath = "//a[.='Add to cart']")
    private WebElement btnAddToCart;

    @FindBy(xpath = "//a[.='Cart']")
    private WebElement menuCart;

    @FindBy(xpath = "//button[.='Place Order']")
    private WebElement btnOrder;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameCO;

    @FindBy(xpath = "//input[@id='country']")
    private WebElement countryCO;

    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityCO;

    @FindBy(xpath = "//input[@id='card']")
    private WebElement creditcardCO;

    @FindBy(xpath = "//input[@id='month']")
    private WebElement monthCO;

    @FindBy(xpath = "//input[@id='year']")
    private WebElement yearCO;

    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']")
    private WebElement popupSuccessCO;

    @FindBy(xpath = "//button[.='Purchase']")
    private WebElement btnPurchase;

    @FindBy(xpath = "//a[.='Laptops']")
    private WebElement catLaptop;

    @FindBy(xpath = "//input[@id='recipient-email']")
    private WebElement contactEmail;

    @FindBy(xpath = "//input[@id='recipient-name']")
    private WebElement contactName;

    @FindBy(xpath = "//textarea[@id='message-text']")
    private WebElement messageContact;

    @FindBy(xpath = "//a[.='Contact']")
    private WebElement menuContact;

    @FindBy(xpath = "//button[.='Send message']")
    private WebElement btnSendMessage;

    @FindBy(xpath = "//button[.='Next']")
    private WebElement btnNextPage;

    @FindBy(xpath = "//button[.='Previous']")
    private WebElement btnPreviousPage;

    public MainPages(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMenuLogin() throws InterruptedException {
        menuLogin.click();
        Thread.sleep(3000);
    }

    public void clickMenuSignup() throws InterruptedException {
        menuSignup.click();
        Thread.sleep(3000);
    }

    public void clickMenuHome() throws InterruptedException {
        menuHome.click();
        Thread.sleep(1000);
    }

    public void clickBtnLogin() throws InterruptedException {
        btnLogin.click();
        Thread.sleep(1000);
    }

    public void clickBtnClose() throws InterruptedException {
        btnClose.click();
        Thread.sleep(1000);
    }

    public void fillUsername(String username) throws InterruptedException {
        fieldUsername.sendKeys(username);
        Thread.sleep(1000);
    }

    public void fillPassword(String password) throws InterruptedException {
        fieldPassword.sendKeys(password);
        Thread.sleep(1000);
    }

    public void clearUsernameandPassword(){
        fieldUsername.clear();
        fieldPassword.clear();
    }

    public void fillUsernameSignup(String usernameSU) throws InterruptedException {
        signupUsername.sendKeys(usernameSU);
        Thread.sleep(1000);
    }

    public void fillPasswordSignup(String passwordSU) throws InterruptedException {
        signupPassword.sendKeys(passwordSU);
        Thread.sleep(1000);
    }

    public void clickBtnSignup() throws InterruptedException {
        btnSignup.click();
        Thread.sleep(1000);
    }

    public void clickBtncloseSU() throws InterruptedException {
        btnCloseSU.click();
        Thread.sleep(1000);
    }
    public String getTxtWelcome(String nama){
        WebElement txtWelcome = driver.findElement(By.xpath("//li[contains(.,'" + nama + "')]"));
        return txtWelcome.getText();
    }

    public void clickBtnLogout() throws InterruptedException {
        btnLogout.click();
        Thread.sleep(2000);
    }

    public boolean isWelcomeNotDisplayed(){
        return driver.findElements(By.xpath("//li[contains(.,'Welcome')]")).isEmpty();
    }

    public void clickAddToCart() throws InterruptedException {
        btnAddToCart.click();
        Thread.sleep(2000);
    }

    public void clickMenuCart() throws InterruptedException {
        menuCart.click();
        Thread.sleep(2000);
    }

    public void clickBtnOrder() throws InterruptedException {
        btnOrder.click();
        Thread.sleep(2000);
    }

    public void fillCO(){
        nameCO.sendKeys("John");
        countryCO.sendKeys("India");
        cityCO.sendKeys("Ngawi");
        creditcardCO.sendKeys("456789321");
        monthCO.sendKeys("02");
        yearCO.sendKeys("2036");
    }

    public void fillNotAllCO(){
        countryCO.sendKeys("India");
        cityCO.sendKeys("Ngawi");
        monthCO.sendKeys("02");
        yearCO.sendKeys("2036");
    }

    public void clearCO(){
        nameCO.clear();
        countryCO.clear();
        cityCO.clear();
        creditcardCO.clear();
        monthCO.clear();
        yearCO.clear();
    }

    public boolean popupSuccessisDisplayed(){
        return popupSuccessCO.isDisplayed();
    }

    public void clickBtnPurchase() throws InterruptedException {
        btnPurchase.click();
        Thread.sleep(1000);
    }

    public void clickCatLaptop() throws InterruptedException {
        catLaptop.click();
        Thread.sleep(1000);
    }

    public boolean catLaptop1isDisplayed(){
       WebElement laptop1 = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
       return laptop1.isDisplayed();
    }

    public boolean catLaptop2isDisplayed(){
        WebElement laptop2 = driver.findElement(By.xpath("//a[.='MacBook Pro']"));
        return laptop2.isDisplayed();
    }

    public boolean isProductCart1Displayed(){
        WebElement productCart1 = driver.findElement(By.xpath("//td[.='Iphone 6 32gb']"));
        return productCart1.isDisplayed();
    }

    public boolean isProductCart2Displayed(){
        WebElement productCart2 = driver.findElement(By.xpath("//td[.='Nexus 6']"));
        return productCart2.isDisplayed();
    }

    public boolean isProductCart3Displayed(){
        WebElement productCart3 = driver.findElement(By.xpath("//td[.='HTC One M9']"));
        return productCart3.isDisplayed();
    }

    public boolean isNexus6NotDisplayed(){
        return driver.findElements(By.xpath("//td[.='Nexus 6']")).isEmpty();
    }

    public void clickMenuContact() throws InterruptedException {
        menuContact.click();
        Thread.sleep(2000);
    }

    public void fillContactForm(String name, String email, String message) throws InterruptedException {
        contactEmail.sendKeys(name);
        Thread.sleep(1000);
        contactName.sendKeys(email);
        Thread.sleep(1000);
        messageContact.sendKeys(message);
        Thread.sleep(1000);
    }

    public void clickBtnSendMessage() throws InterruptedException {
        btnSendMessage.click();
        Thread.sleep(2000);
    }

    public void notFillContactForm() throws InterruptedException {
        contactEmail.sendKeys("");
        contactName.sendKeys("");
        messageContact.sendKeys("");
        Thread.sleep(2000);
    }

    public int getTotalCartPrice() {
        WebElement totalPriceElement = driver.findElement(By.id("totalp"));
        String totalPriceText = totalPriceElement.getText();
        return totalPriceText.isEmpty() ? 0 : Integer.parseInt(totalPriceText);
    }

    public void deleteFirstProduct(){
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[text()='Delete']"));
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
        }
    }

    public void clickNextPage() throws InterruptedException {
        btnNextPage.click();
        Thread.sleep(2000);
    }

    public void clickPreviousPage() throws InterruptedException {
        btnPreviousPage.click();
        Thread.sleep(2000);
    }

    public Boolean product1NextPageisDisplayed(){
        WebElement product1Next = driver.findElement(By.xpath("//a[.='Apple monitor 24']"));
        return product1Next.isDisplayed();
    }

    public Boolean product2NextPageisDisplayed(){
        WebElement product2Next = driver.findElement(By.xpath("//a[.='MacBook Pro']"));
        return product2Next.isDisplayed();
    }

    public Boolean product1PreviousPageisDisplayed(){
        WebElement product1Previous = driver.findElement(By.xpath("//a[.='Sony vaio i5']"));
        return product1Previous.isDisplayed();
    }

    public Boolean product2PreviousPageisDisplayed(){
        WebElement product2Previous = driver.findElement(By.xpath("//a[.='Nexus 6']"));
        return product2Previous.isDisplayed();
    }
}
