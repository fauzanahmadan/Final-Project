package stepDef;

import helper.Utility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.WebPage;

import java.time.Duration;

public class WebStep {

    WebPage webPage;

    public WebStep(){
        this.webPage = new WebPage();
    }
    @Given("user go to Product Store page")
    public void userGoToProductStorePage() {
        webPage.goToStorePage();
    }

    @And("user click menu Sign up")
    public void userClickMenuSignUp() {
        webPage.clickBtnSignUp();
    }

    @When("user input sign up username {string}")
    public void userInputSignUpUsername(String uname) {
        webPage.inputUname(uname);
    }
    @And("user input sign up password {string}")
    public void userInputSignUpPassword(String pass) {
        webPage.inputPass(pass);
    }
    @Then("validation display message {string}")
    public void validationDisplayMessage(String message) {
        webPage.validateMassage(message);
    }

    @And("user click sign up button")
    public void userClickSignUpButton() {
        webPage.clickBtnSign();
    }

    @And("user click menu About Us")
    public void userClickMenuAboutUs() {
        webPage.clickBtnAbout();
    }

    @When("user click button video")
    public void userClickButtonVideo() {
        webPage.clickBtnPlay();
    }

    @Then("Video played successfully")
    public void videoPlayedSuccessfully() {
        webPage.validateIsVideoPlayed();
    }

    @And("user click menu Contact")
    public void userClickMenuContact() {
        webPage.clickBtnContact();
    }

    @When("user input Contact Email {string}")
    public void userInputContactEmail(String cEmail) {
        webPage.inputContactEmail(cEmail);
    }

    @And("user input Contact Name {string}")
    public void userInputContactName(String cName) {
        webPage.inputContactName(cName);
    }

    @And("user input Message {string}")
    public void userInputMessage(String message) {
        webPage.inputMessage(message);
    }

    @And("user click button Send Message")
    public void userClickButtonSendMessage() {
        webPage.clickBtnSendMessage();
    }

    @And("user click menu Log in")
    public void userClickMenuLogIn() {
        webPage.clickBtnMenuLogin();
    }

    @When("user input username {string}")
    public void userInputUsername(String uName) {
        webPage.inputUnameLogin(uName);
    }
    @And("user input password {string}")
    public void userInputPassword(String pass) {
        webPage.inputPassLogin(pass);
    }
    @And("user click login button")
    public void userClickLoginButton() {
        webPage.clickBtnLogin();
    }
    @Then("User login successfully with welcome message {string}")
    public void userLoginSuccessfullyWithWelcomeMessage(String message) {
        webPage.validateLogin(message);
    }
    @When("User click menu Log out")
    public void userClickMenuLogOut() {
        webPage.clickBtnLogout();
    }
    @Then("User Log out Successfully and display menu {string}")
    public void userLogOutSuccessfullyAndDisplayMenu(String logoutMenu) {
        webPage.validateLogout(logoutMenu);
    }

    @When("user order product item")
    public void userOrderProductItem() {
        webPage.orderProductItem();
    }

    @And("User click Add to chart")
    public void userClickAddToChart() {
        webPage.addToChart();
    }

    @And("validation the Cart Page")
    public void userShouldBeAbleSeeProductOrderedInTheCartPage() {
        webPage.cartPage();
    }

    @When("user click button Place Order")
    public void userClickButtonPlaceOrder() {
        webPage.placeOrder();
    }

    @And("user input Name {string}")
    public void userInputName(String name) {
        webPage.inputNameOrder(name);
    }

    @And("user input Country {string}")
    public void userInputCountry(String country) {
        webPage.inputCountryOrder(country);
    }

    @And("user input City {string}")
    public void userInputCity(String city) {
        webPage.inputCityOrder(city);

    }

    @And("user input Credit Card {string}")
    public void userInputCreditCard(String cc) {
        webPage.InputCcOrder(cc);
    }

    @And("user input Moth {string}")
    public void userInputMoth(String month) {
        webPage.inputMonth(month);
    }

    @And("user input Year {string}")
    public void userInputYear(String year) {
        webPage.inputYearOrder(year);
    }

    @And("user click button Purchase")
    public void userClickButtonPurchase() {
        webPage.clickBtnOrder();
    }

    @Then("Order process successfully")
    public void orderProcessSuccessfully() {
        webPage.validateOrder();
    }

    @And("user go to cart page")
    public void userGoToCartPage() {
        webPage.goToCartPage();
    }

    @And("user has been log in")
    public void userHasBeenLogIn() {
        webPage.userHaseBeebLogin();
    }
}
