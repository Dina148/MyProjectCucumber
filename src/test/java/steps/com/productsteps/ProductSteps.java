package steps.com.productsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.com.productpages.OrderPage;
import pages.com.productpages.ProductLoginPage;
import utils.ConfigReader;
import utils.Driver;

import java.util.List;

public class ProductSteps {

    WebDriver driver;
    ProductLoginPage loginPage;
    OrderPage orderPage;

    @Given("the user navigates product website home page")
    public void the_user_navigates_product_website_home_page() {
        driver= Driver.getDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
        loginPage=new ProductLoginPage(driver);
        loginPage.login(ConfigReader.getProperty("productsUsername"), ConfigReader.getProperty("productsPassword"));

    }
    @When("the user enters the product info {string} and {string}")
    public void the_user_enters_the_product_info_and(String productName, String quantity) {

        orderPage=new OrderPage(driver);
        orderPage.clickOrder();
        orderPage.sendProductInfo(productName, quantity);


    }
    @When("the user enters the address info {string} , {string} , {string} , {string} , {string}")
    public void the_user_enters_the_address_info(String customerName, String street, String city, String state, String zipcode) {

        orderPage.sendAddressInfo(customerName, street, city, state, zipcode);
    }
    @When("the user enters the card info {string} , {string}, {string}")
    public void the_user_enters_the_card_info(String cardType, String cardNumber, String expireDate) {
     orderPage.sendPaymentInfo(cardType, cardNumber, expireDate);
     orderPage.clickProcess();
    }
    @When("the user validate success message")
    public void the_user_validate_success_message() {

        String actualMessage=orderPage.getMessageText();
        Assert.assertEquals("New order has been successfully added.", actualMessage);
    }

    @Then("the user validate product details {string}, {string} , {string} , {string} , {string} , {string} , {string}, {string} , {string}, {string}")
    public void the_user_validate_product_details(String productName, String quantity, String name, String street, String city, String state, String zipcode, String cardType, String cardNumber, String expireDate) {

        orderPage.clickAllOrders();
        List<WebElement> details=orderPage.productInfo;

        Assert.assertEquals(details.get(1).getText().trim(), name);
        Assert.assertEquals(details.get(2).getText().trim(), productName);
        Assert.assertEquals(details.get(3).getText().trim(), quantity);
        Assert.assertEquals(details.get(5).getText().trim(), street);
        Assert.assertEquals(details.get(6).getText().trim(), city);
        Assert.assertEquals(details.get(7).getText().trim(), state);
        Assert.assertEquals(details.get(8).getText().trim(), zipcode);
        Assert.assertEquals(details.get(9).getText().trim(), cardType);
        Assert.assertEquals(details.get(10).getText().trim(), cardNumber);
        Assert.assertEquals(details.get(11).getText().trim(), expireDate);

    }

}
