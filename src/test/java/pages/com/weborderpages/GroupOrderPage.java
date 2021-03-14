package pages.com.weborderpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GroupOrderPage {

    public GroupOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="InviteNote")
    public WebElement inviteNote;

    @FindBy(name = "InviteList")
    public WebElement inviteList;

    @FindBy(id="createGroupOrder")
    public WebElement createGroup;

    @FindBy(className = "topBannerHeader")
    public WebElement viewGroupOrderHeader;

    @FindBy(xpath = "//label[.='Total Participants:']/following-sibling::div")
    public WebElement participants;

    public void sendInviteeNote(String note){
        inviteNote.sendKeys(note);
    }

    public void sendInviteList(String list){
        inviteList.sendKeys(list);
    }

    public void sendInvitees(List<String> emails){
        String emailList="";
        for(String email : emails){
           emailList+=email+",";
        }
        emailList=emailList.substring(0,emailList.length()-1);
        inviteList.sendKeys(emailList);
    }

    public void clickCreateGroup(){
        createGroup.click();
    }

    public int getParticipantNumber(){
       return Integer.parseInt(participants.getText().trim());
    }





}
