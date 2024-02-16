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

    By btn_sendMessage = By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]");

    public void goToStorePage(){
        driver.get("https://www.demoblaze.com/");
    }

    public void clickBtnSignUp(){
        driver.findElement(btn_signup).click();
    }

    public void inputUname(String uname){
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
        try {
            Thread.sleep(5000); // Wait for 5 seconds (You can adjust this according to your video length)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        WebElement welcome = driver.findElement(By.id("logout2"));
        String welcomeTxt = welcome.getText();

        assertEquals(message, welcomeTxt);
    }
    public void clickBtnLogout() {
        driver.findElement(btn_logout).click();
    }

    public void validateLogout(String logoutMenu) {
        String txtLogout = driver.findElement(btn_signup).getText();
        assertTrue(txtLogout.contains(logoutMenu));
    }
}
