package pages.com.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {



    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(id="Email")
    public WebElement username;

    @FindBy(id="Password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    public void login(String username, String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        signInButton.click();
    }



}
