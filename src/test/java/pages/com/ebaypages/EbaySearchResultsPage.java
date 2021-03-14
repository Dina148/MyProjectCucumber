package pages.com.ebaypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class EbaySearchResultsPage {

    public EbaySearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[@class='s-item__title']")
    public List<WebElement> listOfLinks;

    @FindBy(xpath = "//ol[@class='pagination__items']//li")
    public List<WebElement> pages;




}
