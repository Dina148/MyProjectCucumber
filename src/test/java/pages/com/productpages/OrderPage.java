package pages.com.productpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class OrderPage {

    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Order")
    public WebElement orderButton;

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameField;
    @FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetField;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityField;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateField;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipField;

    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visa;
    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement masterCard;
    @FindBy(id="ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement americanExpress;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDate;

    @FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

    @FindBy(xpath = "//div[@class='buttons_process']/strong")
    public WebElement message;

    @FindBy(linkText = "View all orders")
    public WebElement allOrdersButton;

    @FindBy(xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td")
    public List<WebElement> productInfo;


    public void clickOrder(){
        orderButton.click();
    }

    public void selectByText(String text){
        BrowserUtils.selectByText(productName, text);
    }

    public void sendQuantity(String quantityNumber){
        quantity.sendKeys(quantityNumber);
    }

    public void sendProductInfo(String productName, String quantity){
            selectByText(productName);
            sendQuantity(quantity);
    }

    public void sendAddressInfo(String customerName, String street, String city, String state, String zipcode){
        customerNameField.sendKeys(customerName);
        streetField.sendKeys(street);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipField.sendKeys(zipcode);
    }

    public void selectCard(String cardType){
        cardType=cardType.toLowerCase();

        switch (cardType){
            case "visa":
                visa.click();
                break;
            case "mastercard":
                masterCard.click();
                break;
            case "american express":
                americanExpress.click();
                break;
            default:
                System.out.println("Card name is not correct. Please change card name");
                break;
        }

    }

    public void sendPaymentInfo(String cardType, String cardNumber, String expireDate){
        selectCard(cardType);
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
    }

    public void clickProcess(){
        processButton.click();
    }

    public String getMessageText(){
        return  message.getText().trim();
    }

    public void clickAllOrders(){
        allOrdersButton.click();
    }


}
