package ru.levelp.at.testhomework3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.levlup.at.homework3.browser.BrowserActions.click;
import static ru.levlup.at.homework3.browser.BrowserActions.getText;
import static ru.levlup.at.homework3.browser.BrowserStarter.browserClose;
import static ru.levlup.at.homework3.browser.BrowserStarter.browserSetUp;
import static ru.levlup.at.homework3.pages.AuthorizationPage.LOGIN;
import static ru.levlup.at.homework3.pages.AuthorizationPage.LOGIN_NAME;
import static ru.levlup.at.homework3.pages.AuthorizationPage.authorization;
import static ru.levlup.at.homework3.pages.DraftPage.BACK_TO_INCOMING;
import static ru.levlup.at.homework3.pages.LetterPage.BODY;
import static ru.levlup.at.homework3.pages.LetterPage.SEND_LETTER_BTN;
import static ru.levlup.at.homework3.pages.LetterPage.THEME;
import static ru.levlup.at.homework3.pages.LetterPage.createLetter;
import static ru.levlup.at.homework3.pages.MainPage.AUTHORIZATION_CHECK_ELEM;
import static ru.levlup.at.homework3.pages.MainPage.OPEN_TEST_FOLDER;
import static ru.levlup.at.homework3.pages.MainPage.logOut;
import static ru.levlup.at.homework3.pages.SendLetterPage.SEND_ADDRESS;
import static ru.levlup.at.homework3.pages.SendLetterPage.SEND_BODY;
import static ru.levlup.at.homework3.pages.SendLetterPage.SEND_THEME;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SecondEmailTest {

    @BeforeEach
    void setUp() {
        browserSetUp();
    }

    @AfterEach
    void tearDown() {
        browserClose();
    }

    @Test
    void speedyGonsalesTest2() {
        authorization(); // авторизируемся
        assertEquals(LOGIN, getText(AUTHORIZATION_CHECK_ELEM)); // проверяем авторизацию
        createLetter(); // создаем письмо
        click(SEND_LETTER_BTN); // отправляем письмо
        click(BACK_TO_INCOMING); // открываем Входящие
        click(OPEN_TEST_FOLDER); // переходим в папку Тест
        assertEquals(LOGIN_NAME, getText(SEND_ADDRESS)); // проверяем наличие письма в Черновиках по отправителю
        assertEquals(THEME, getText(SEND_THEME)); // проверяем наличие письма в Черновиках по теме
        assertEquals(BODY, getText(SEND_BODY)); // проверяем наличие письма в Черновиках по телу
        logOut();
    }
}
