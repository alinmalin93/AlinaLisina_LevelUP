package ru.levlup.at.homework4.pages;

import static ru.levlup.at.homework4.pages.MainPage.newLetterBtn;
import static ru.levlup.at.homework4.utils.PropReader.getAddress;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levlup.at.homework4.browser.BrowserStarter;

public class LetterPage extends BrowserStarter {

    public LetterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "#compose-field-1")
    private WebElement addressField;

    @FindBy(css = "#compose-field-subject-4")
    private WebElement themeField;

    @FindBy(css = ".cke_enable_context_menu")
    private WebElement bodyField;

    @FindBy(css = ".composeReact__headerButtons>div>button:nth-child(3)")
    private WebElement closeLetterBtn;

    @FindBy(css = "div.composeReact__footer>div>div>div:nth-child(1)>button")
    private WebElement sendLetterBtn;

    public static final String THEME = "Тест";
    public static final String THEME2 = "Важно";
    public static final String BODY = "Hello!";

    public void closeLetter() {
        closeLetterBtn.click();
    }

    public void createLetter() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(newLetterBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addressField)).sendKeys(getAddress());
        wait.until(ExpectedConditions.elementToBeClickable(themeField)).sendKeys(THEME);
        wait.until(ExpectedConditions.elementToBeClickable(bodyField)).sendKeys(BODY);
    }

    public void createLetter2() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(newLetterBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(addressField)).sendKeys(getAddress());
        wait.until(ExpectedConditions.elementToBeClickable(themeField)).sendKeys(THEME2);
        wait.until(ExpectedConditions.elementToBeClickable(bodyField)).sendKeys(BODY);
    }

    public void sendLetter() {
        sendLetterBtn.click();
    }
}
