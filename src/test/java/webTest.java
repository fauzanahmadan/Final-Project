//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//
//public class webTest {
//
//    @Test
//    public void sauceDemoTest() throws InterruptedException {
//        WebDriver driver = WebDriverManager.chromedriver().create();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//        driver.get("https://www.saucedemo.com/");
//        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
//        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
//    }
//
//    @Test
//    public void fluentWait() {
//        WebDriver driver = WebDriverManager.chromedriver().create();
//        driver.get("https://www.saucedemo.com/");
//
//        FluentWait<WebDriver> wait = new FluentWait<>(driver);
//        wait.withTimeout(Duration.ofSeconds(10));
//        wait.pollingEvery(Duration.ofMillis(100));
//        wait.ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#user-name")));
//
//        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
//        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
//    }
//    @Test
//    public void loginTest() throws InterruptedException {
//        WebDriver driver = WebDriverManager.chromedriver().create();
//
//        driver.get("https://www.saucedemo.com/");
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#user-name")));
//        driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
//
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]")));
//        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
//
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
//        driver.findElement(By.id("login-button")).click();
//    }
//
//
//    @Test
//    public void navigationMethodTest() throws InterruptedException{
//        WebDriver driver = WebDriverManager.chromedriver().create();
//        driver.navigate().to("https://www.saucedemo.com/");
//        driver.navigate().refresh();
//        driver.navigate().to("https://www.jayjay.co");
//        driver.navigate().back();
//        driver.navigate().forward();
//
//        String tittle = driver.getTitle();
//        String currentUrl= driver.getCurrentUrl();
//        System.out.println("Tittle pada halaman web :" + tittle);
//        System.out.println("Url saat ini pada halaman web : " + currentUrl);
//    }
//}
