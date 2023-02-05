package ru.levlup.at.homework4.pages;

import static ru.levlup.at.homework4.pages.StartEmailPage.enterBtn;
import static ru.levlup.at.homework4.utils.PropReader.getLogin;
import static ru.levlup.at.homework4.utils.PropReader.getPassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levlup.at.homework4.browser.BrowserStarter;
import java.io.IOException;

public class AuthorizationPage extends BrowserStarter {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    private static final String LOGIN_NAME = "Тест Тестовый";

    @FindBy (css = ".AuthLoginInputToggle-wrapper>div:nth-child(2)")
    private WebElement phoneBtn;

    @FindBy (css = ".AuthLoginInputToggle-wrapper>div:nth-child(1)")
    private WebElement postBtn;

    @FindBy (css = "#passp-field-login")
    private WebElement loginField;

    @FindBy (css = ".Button2_type_submit")
    private WebElement enterSubmitBtn;

    @FindBy (css = "#passp-field-passwd")
    private WebElement passwordField;

    public void authorization() throws IOException {
        wait.until(ExpectedConditions.elementToBeClickable(enterBtn)).click();
        if (wait.until(ExpectedConditions.elementToBeClickable(phoneBtn)).isSelected()) {
            wait.until(ExpectedConditions.elementToBeClickable(postBtn)).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(loginField)).sendKeys(getLogin());
        enterSubmitBtn.click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(getPassword());
        enterSubmitBtn.click();
    }

    public static String getLoginName() {
        return LOGIN_NAME;
    }

}
