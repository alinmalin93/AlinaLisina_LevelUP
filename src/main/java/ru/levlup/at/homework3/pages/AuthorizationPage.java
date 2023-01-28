package ru.levlup.at.homework3.pages;

import static ru.levlup.at.homework3.browser.BrowserActions.click;
import static ru.levlup.at.homework3.browser.BrowserActions.input;
import static ru.levlup.at.homework3.browser.BrowserActions.isSelected;
import static ru.levlup.at.homework3.pages.StartEmailPage.ENTER_BTN;

import org.openqa.selenium.By;

public class AuthorizationPage {

    public static final By PHONE_BTN = By.cssSelector(".AuthLoginInputToggle-wrapper>div:nth-child(2)");
    public static final By POST_BTN = By.cssSelector(".AuthLoginInputToggle-wrapper>div:nth-child(1)");
    public static final By LOGIN_FIELD = By.cssSelector("#passp-field-login");
    public static final String LOGIN = "testoviyt3sttest";
    public static final String LOGIN_NAME = "Тест Тестовый";
    public static final By ENTER_SUBMIT_BTN = By.cssSelector(".Button2_type_submit");
    public static final By PASSWORD_FIELD = By.cssSelector("#passp-field-passwd");
    public static final String PASSWORD = "Qwerty123@!";

    public static void authorization() {
        click(ENTER_BTN);
        if (isSelected(PHONE_BTN)) {
            click(POST_BTN);
        }
        input(LOGIN_FIELD, LOGIN);
        click(ENTER_SUBMIT_BTN);
        input(PASSWORD_FIELD, PASSWORD);
        click(ENTER_SUBMIT_BTN);
    }

}
