package ru.levlup.at.homework4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levlup.at.homework4.browser.BrowserStarter;

public class DraftPage extends BrowserStarter {
    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public static final String EMPTY_BOX_MESSAGE = "В папке «Черновики» нет писем";

    @FindBy(xpath = "//span[@title='testoviyt3sttest@yandex.ru']")
    private WebElement draftAddress;

    @FindBy(css = ".mail-MessageSnippet-Item_body>div>span>span>span:nth-child(1)>span")
    private WebElement draftTheme;

    @FindBy(xpath = ".mail-MessageSnippet-Item_body>div>span>span:nth-child(2)>span")
    private WebElement draftBody;

    @FindBy(css = "div>a.mail-MessageSnippet>div")
    private WebElement letterBtn;

    @FindBy(css = ".ns-view-messages-empty>div>h1>span")
    private WebElement emptyBox;

    @FindBy(css = ".ComposeDoneScreen-Actions>a")
    private WebElement backToIncomingBtn;

    public String getDraftAddressText() {
        return draftAddress.getAttribute("textContent");
    }

    public String getEmptyBoxMessage() {
        return emptyBox.getAttribute("textContent");
    }

    public void openLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(letterBtn)).click();
    }

    public void backToIncoming() {
        wait.until(ExpectedConditions.elementToBeClickable(backToIncomingBtn)).click();
    }
}
