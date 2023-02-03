package ru.levlup.at.homework3.pages;

import static ru.levlup.at.homework3.browser.BrowserActions.click;
import static ru.levlup.at.homework3.browser.BrowserActions.input;
import static ru.levlup.at.homework3.pages.AuthorizationPage.LOGIN;
import static ru.levlup.at.homework3.pages.MainPage.NEW_LETTER_BTN;

import org.openqa.selenium.By;

public class LetterPage {

    public static final By ADDRESS_FIELD = By.cssSelector("#compose-field-1");
    public static final String ADDRESS = LOGIN + "@yandex.ru";
    public static final By THEME_FIELD = By.cssSelector("#compose-field-subject-4");
    public static final String THEME = "Тест";
    public static final String THEME2 = "Важно";
    public static final By BODY_FIELD = By.cssSelector(".cke_enable_context_menu");
    public static final String BODY = "Hello!";
    public static final By CLOSE_LETTER_BTN = By.cssSelector(".composeReact__headerButtons>div>button:nth-child(3)");
    public static final By SEND_LETTER_BTN = By.cssSelector("div.composeReact__footer>div>div>div:nth-child(1)>button");

    public static void createLetter() {
        click(NEW_LETTER_BTN);
        input(ADDRESS_FIELD, ADDRESS);
        input(THEME_FIELD, THEME);
        input(BODY_FIELD, BODY);
    }

    public static void createLetter2() {
        click(NEW_LETTER_BTN);
        input(ADDRESS_FIELD, ADDRESS);
        input(THEME_FIELD, THEME2);
        input(BODY_FIELD, BODY);
    }}
