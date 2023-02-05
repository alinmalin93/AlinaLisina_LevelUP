package ru.levlup.at.homework4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levlup.at.homework4.browser.BrowserStarter;

import static ru.levlup.at.homework4.pages.LetterPage.THEME;
import static ru.levlup.at.homework4.pages.LetterPage.THEME2;

public class DraftPage extends BrowserStarter {
    public DraftPage(WebDriver driver) {
        super(driver);
    }

    public static final String EMPTY_BOX_MESSAGE = "В папке «Черновики» нет писем";

    @FindBy(xpath = "//span[@title='testoviyt3sttest@yandex.ru']")
    private WebElement draftAddress;

    @FindBy(css = ".mail-MessageSnippet-Item_body>div>span>span:nth-child(2)>span")
    private WebElement draftBody;

    private final By draftTheme = By.xpath("//span[contains(@title, '" + THEME + "')]");

    private final By draftTheme2 = By.xpath("//span[contains(@title, '" + THEME2 + "')]");

    @FindBy(css = "div>a.mail-MessageSnippet>div")
    private WebElement letterBtn;

    @FindBy(css = ".ns-view-messages-empty>div>h1>span")
    private WebElement emptyBox;

    @FindBy(css = ".ComposeDoneScreen-Actions>a")
    private WebElement backToIncomingBtn;

    public String getDraftAddressText() {
        return wait.until(ExpectedConditions.visibilityOf(draftAddress)).getAttribute("textContent");
    }

    public String getDraftThemeText() {
        return wait.until(ExpectedConditions.elementToBeClickable(draftTheme)).getAttribute("textContent");
    }

    public String getDraftTheme2Text() {
        return wait.until(ExpectedConditions.elementToBeClickable(draftTheme2)).getAttribute("textContent");
    }

    public String getDraftBodyText() {
        return wait.until(ExpectedConditions.visibilityOf(draftBody)).getAttribute("textContent");
    }

    public String getEmptyBoxMessage() {
        return wait.until(ExpectedConditions.visibilityOf(emptyBox)).getAttribute("textContent");
    }

    public void openLetter() {
        wait.until(ExpectedConditions.elementToBeClickable(letterBtn)).click();
    }

    public void backToIncoming() {
        wait.until(ExpectedConditions.elementToBeClickable(backToIncomingBtn)).click();
    }
}
