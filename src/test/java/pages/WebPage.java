package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static helper.Utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebPage {

    String globalUser = "fauzan";
    String globalPass = "fauzan123";
    By btn_signup = By.id("signin2");
    By input_uname = By.id("sign-username");
    By input_pass = By.id("sign-password");
    By btn_sign = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
    By btnLoginMenu = By.id("login2");
    By unameLogin = By.id("loginusername");
    By passLogin = By.id("loginpassword");
    By btn_login = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
    By btn_logout = By.cssSelector("a#logout2");
    By btn_about = By.xpath("//*[@id=\"navbarExample\"]/ul/li[3]/a");
    By btn_play = By.xpath("//*[@id=\"example-video\"]/button");
    By btn_contact = By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a");
    By input_cEmail = By.id("recipient-email");
    By input_cName = By.id("recipient-name");
    By txtMessage = By.id("message-text");
    By txtWelcome = By.xpath("//*[@id=\"nameofuser\"]");
    By productLink = By.xpath("//*//*[@id=\"tbodyid\"]/div[1]/div/a/img");
    By btnAddToChart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    By btnChart = By.id("cartur");
    By productChart = By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]");
    By btnOrder = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    By nameOrder = By.xpath("//*[@id=\"name\"]");
    By countryOrder = By.id("country");
    By cityOrder = By.id("city");
    By cardOrder = By.id("card");
    By monthOrder = By.id("month");
    By yearOrder = By.id("year");
    By btnPurchase = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
    By formOrder = By.xpath("//*[@id=\"orderModal\"]/div/div/div[2]");
    By msgOrder = By.xpath("/html/body/div[10]");
    By txtOrder = By.xpath(   "/html/body/div[10]/h2");

    By btn_sendMessage = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");

    public void tunggu(){
        try {
            Thread.sleep(5000); // Wait for 5 seconds (You can adjust this according to your video length)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void goToStorePage(){
        driver.get("https://www.demoblaze.com/");
    }

    public void clickBtnSignUp(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_signup));
        driver.findElement(btn_signup).click();
    }

    public void inputUname(String uname){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(input_uname));

        driver.findElement(input_uname).sendKeys(uname);
    }

    public void inputPass(String pass){
        driver.findElement(input_pass).sendKeys(pass);
    }
    public void clickBtnSign(){
        driver.findElement(btn_sign).click();
    }

    public void validateMassage(String message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        tunggu();
        String alertText = driver.switchTo().alert().getText();

        assertTrue(alertText.contains(message));

        driver.switchTo().alert().accept();

    }

    public void clickBtnAbout(){
        driver.findElement(btn_about).click();
    }

    public void clickBtnPlay(){
        driver.findElement(btn_play).click();
    }
    public void validateIsVideoPlayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//video")));

        // Wait for a few more seconds to ensure video starts playing
        tunggu();

        // Check if the video is playing
        WebElement videoElement = driver.findElement(By.xpath("//video"));
        boolean isVideoPlaying = (Boolean) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return arguments[0].paused === false;", videoElement);
        assertTrue(isVideoPlaying, "Video is not playing - Validation failed!");

    }
    public void clickBtnContact() {
        driver.findElement(btn_contact).click();
    }
    public void inputContactEmail(String cEmail) {
        driver.findElement(input_cEmail).sendKeys(cEmail);

    }

    public void inputContactName(String cName) {
        driver.findElement(input_cName).sendKeys(cName);
    }

    public void inputMessage(String message) {
        driver.findElement(txtMessage).sendKeys(message);
    }

    public void clickBtnSendMessage() {
        driver.findElement(btn_sendMessage).click();
    }

    public void clickBtnMenuLogin() {
        driver.findElement(btnLoginMenu).click();
    }

    public void inputUnameLogin(String uName) {
        driver.findElement(unameLogin).sendKeys(uName);
    }

    public void inputPassLogin(String pass) {
        driver.findElement(passLogin).sendKeys(pass);
    }

    public void clickBtnLogin() {
        driver.findElement(btn_login).click();
    }

    public void validateLogin(String message) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtWelcome));

        tunggu();
        WebElement loggedInUser = driver.findElement(By.id("nameofuser"));
        String loggedInUsername = loggedInUser.getText();
        assertEquals(message, loggedInUsername);

        WebElement logoutLink = driver.findElement(By.id("logout2"));
        assertTrue(logoutLink.isDisplayed());
    }
    public void clickBtnLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_logout));

        driver.findElement(btn_logout).click();
    }

    public void validateLogout(String logoutMenu) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_signup));

        String txtLogout = driver.findElement(btn_signup).getText();
        assertTrue(txtLogout.contains(logoutMenu));
    }

    public void orderProductItem() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productLink));

        tunggu();

        driver.findElement(productLink).click();
    }

    public void addToChart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAddToChart));

        driver.findElement(btnAddToChart).click();
    }

    public void cartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnChart));

        driver.findElement(btnChart).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productChart));
        tunggu();

        WebElement productElement = driver.findElement(productChart);
        assertTrue(productElement.isDisplayed());

/*
        String productTxt = productElement.getText();

        assertEquals("Samsung galaxy s6", productTxt)*/;

    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnOrder));

        driver.findElement(btnOrder).click();
    }

    public void inputNameOrder(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(formOrder));

        driver.findElement(nameOrder).sendKeys(name);
    }

    public void inputCountryOrder(String country) {
        driver.findElement(countryOrder).sendKeys(country);
    }

    public void inputCityOrder(String city) {
        driver.findElement(cityOrder).sendKeys(city);
    }

    public void InputCcOrder(String cc) {
        driver.findElement(cardOrder).sendKeys(cc);

    }

    public void inputMonth(String month) {
        driver.findElement(monthOrder).sendKeys(month);
    }

    public void inputYearOrder(String year) {
        driver.findElement(yearOrder).sendKeys(year);
    }

    public void clickBtnOrder() {
        driver.findElement(btnPurchase).click();
    }

    public void validateOrder() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(msgOrder));

    String txtOrderGetText = driver.findElement(txtOrder).getText();
    assertEquals("Thank you for your purchase!",txtOrderGetText);

    }

    public void goToCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnChart));

        tunggu();

        driver.findElement(btnChart).click();
    }

    public void userHaseBeebLogin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLoginMenu));

        driver.findElement(btnLoginMenu).click();

        driver.findElement(unameLogin).sendKeys(globalUser);
        tunggu();
        driver.findElement(passLogin).sendKeys(globalPass);

        driver.findElement(btn_login).click();


    }


}
