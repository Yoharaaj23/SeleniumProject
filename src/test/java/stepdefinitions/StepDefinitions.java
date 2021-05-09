package stepdefinitions;

import com.test.yoharaaj.pages.HomePage;
import com.test.yoharaaj.pages.LoginPage;
import com.test.yoharaaj.pages.OrderPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class StepDefinitions {
    public static WebDriver driver;

    @Before
    public static WebDriver setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
        return driver;
    }

    @After
    public static void tearDown() throws InterruptedException {
        driver.quit();
    }

    @Given("I am on the retail homepage")
    public void onHomePage() {
        HomePage homePage = new HomePage(driver);
        assertTrue("Expecting the Retail Website logo to be visible", homePage.isLogoVisible());
    }

    @And("click Sign")
    public void clickSign() {
        HomePage homePage = new HomePage(driver);
        assertTrue("Expecting Sign to be successful", homePage.clickSign());
    }

    @And("Login to My Account")
    public void doLogin() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Expecting Login to be successful", loginPage.signIn());
    }

    @When("select MyPersonalInformation and update firstname to {string}")
    public void updateFirstname(String firstname) {
        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.isMyAccountVisible()) {
            loginPage.clickMyPersonalInfo();
            loginPage.updateFirstName(firstname);
        } else {
            fail("Account Page is not visible");
        }
    }
    @Then("update is success")
    public void updateSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        assertTrue("Expecting Update is success", loginPage.isUpdateSuccess());
    }
    @And("I select T-SHIRTS section")
        public void selectTshirtSection(){
            OrderPage orderPage = new OrderPage(driver);
            orderPage.clickTshirtSection();
            assertTrue("Expecting T-shirt section to be visible", orderPage.isTshirtSectionVisible());
        }
    @And("add the first tshirt to cart")
    public void addToCart(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.addFirstItemToCart();
        assertTrue("Expecting T-shirt to be added to cart successfully", orderPage.isItemAdded());
    }
    @And("proceed to checkout")
    public void orderCheckout(){
        OrderPage orderPage = new OrderPage(driver);
       orderPage.clickSummaryCheckout();
    }
    @And("verify the item price {string} in summary page")
    public void verifyItemPrice(String itemPrice){
        OrderPage orderPage = new OrderPage(driver);
        assertTrue("Expecting Item price is valid", orderPage.verifyItemPrice(itemPrice));
    }
    @And("proceed to Address section")
    public void addressection(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.proceedToAddress();
    }
    @And("proceed to Shipping section and accept Terms of service")
    public void shippingSection(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.proceedToShipping();
    }
    @And("proceed to Payment section")
    public void paymentSection(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.proceedToPayment();
    }
    @And("click Pay by bank wire and confirm the order")
    public void confirmOrder(){
        OrderPage orderPage = new OrderPage(driver);
        orderPage.confirmOrder();
    }
    @Then("order is successful")
    public void orderComplete(){
        OrderPage orderPage = new OrderPage(driver);
        assertTrue("Expecting Order to be completed", orderPage.isOrderComplete());
    }
    @Then("navigate to order history and verify the order")
    public void verifyOrderHistory(){
        OrderPage orderPage = new OrderPage(driver);
        assertTrue("Expecting the Order Reference is valid", orderPage.verifyOrderHistory());
    }

}