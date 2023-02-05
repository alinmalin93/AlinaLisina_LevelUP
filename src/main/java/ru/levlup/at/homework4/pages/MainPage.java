package ru.levlup.at.homework4.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levlup.at.homework4.browser.BrowserStarter;

public class MainPage extends BrowserStarter {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div.legouser>a>span.user-account__name")
    private WebElement authorizationCheckElem;

    @FindBy(css = ".ns-view-compose-buttons-box>div>div>div>a")
    protected static WebElement newLetterBtn;

    @FindBy(xpath = "//div[contains(@aria-label, 'Входящие')]")
    private WebElement incomingBtn;

    @FindBy(xpath = "//div[contains(@aria-label, 'Черновики')]")
    private WebElement draftBtn;

    @FindBy(xpath = "//div[contains(@aria-label, 'Отправленные')]")
    private WebElement sendBtn;

    @FindBy(css = "div.legouser>a.user-account")
    private WebElement userAccBtn;

    @FindBy(css = ".menu__group>li:nth-child(6)")
    private WebElement logoutBtn;

    @FindBy(css = ".qa-LeftColumn-UserFolderNodeContent>div")
    private WebElement openTestFolderBtn;

    @FindBy(css = "div.ns-view-toolbar-buttons>div:nth-child(1)>div:nth-child(1)>label>span")
    private WebElement checkboxIncoming;

    @FindBy(css = "div.ns-view-container-desc>div:nth-child(5)")
    private WebElement deleteBtn;

    @FindBy(xpath = "//div[contains(@aria-label, 'Удалённые')]")
    private WebElement deletedBtn;

    @FindBy(xpath = "//button[contains(@aria-label, 'Проверить')]")
    private WebElement refreshBtn;

    public String getTextAutorizationVerify() {
        return wait.until(ExpectedConditions.visibilityOf(authorizationCheckElem)).getAttribute("textContent");
    }

    public void goToSendLettersPage() {
        wait.until(ExpectedConditions.elementToBeClickable(sendBtn)).click();
    }

    public void goToIncomingLettersPage() {
        wait.until(ExpectedConditions.elementToBeClickable(incomingBtn)).click();
    }

    public void goToDraftPage() {
        wait.until(ExpectedConditions.elementToBeClickable(draftBtn)).click();
    }

    public void goToTestFolder() {
        wait.until(ExpectedConditions.elementToBeClickable(openTestFolderBtn)).click();
    }

    public void chooseCheckBox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxIncoming)).click();
    }

    public void clickDeleteBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
    }

    public void doToDeletedPage() {
        wait.until(ExpectedConditions.elementToBeClickable(deletedBtn)).click();
    }

    public void clickRefreshBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(refreshBtn)).click();
    }

    public void logOut() {
        userAccBtn.click();
        logoutBtn.click();
    }

}
