package ru.levlup.at.homework4.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.levlup.at.homework4.browser.BrowserStarter;

public class MainPage extends BrowserStarter {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div.legouser>a>span.user-account__name")
    private WebElement authorizationCheckElem;

    @FindBy(css = ".ns-view-compose-buttons-box>div>div>div>a")
    protected static WebElement newLetterBtn;

    @FindBy(css = ".qa-LeftColumn>div>div:nth-child(11)")
    private WebElement draftBtn;

    @FindBy(css = ".qa-LeftColumn>div>div:nth-child(7)")
    private WebElement sendBtn;

    @FindBy(css = "div.legouser>a.user-account")
    private WebElement userAccBtn;

    @FindBy(css = ".menu__group>li:nth-child(6)")
    private WebElement logoutBtn;

    @FindBy(css = ".qa-LeftColumn-UserFolderNodeContent>div")
    private WebElement openTestFolder;

    @FindBy(css = "#nb-checkbox_0")
    private WebElement checkkboxInIncoming;

    public String getTextAutorizationVerify() {
        return authorizationCheckElem.getAttribute("textContent");
    }

    public void goToSendLettersPage() {
        sendBtn.click();
    }

    public void goToDraftPage() {
        draftBtn.click();
    }

    public void logOut() {
        userAccBtn.click();
        logoutBtn.click();
    }

}
