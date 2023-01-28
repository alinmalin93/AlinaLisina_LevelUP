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
import static ru.levlup.at.homework3.pages.DraftPage.DRAFT_ADDRESS;
import static ru.levlup.at.homework3.pages.DraftPage.EMPTY_BOX;
import static ru.levlup.at.homework3.pages.DraftPage.EMPTY_BOX_MESSAGE;
import static ru.levlup.at.homework3.pages.DraftPage.LETTER_BTN;
import static ru.levlup.at.homework3.pages.LetterPage.CLOSE_LETTER_BTN;
import static ru.levlup.at.homework3.pages.LetterPage.SEND_LETTER_BTN;
import static ru.levlup.at.homework3.pages.LetterPage.createLetter;
import static ru.levlup.at.homework3.pages.MainPage.AUTHORIZATION_CHECK_ELEM;
import static ru.levlup.at.homework3.pages.MainPage.DRAFT_BTN;
import static ru.levlup.at.homework3.pages.MainPage.SEND_BTN;
import static ru.levlup.at.homework3.pages.MainPage.logOut;
import static ru.levlup.at.homework3.pages.SendLetterPage.SEND_ADDRESS;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmailTest {

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        browserSetUp();
    }

    @AfterEach
    void tearDown() throws InterruptedException {
        browserClose();
    }

    @Test
    void speedyGonsalesTest1() {
        authorization(); // авторизируемся
        assertEquals(LOGIN, getText(AUTHORIZATION_CHECK_ELEM)); // проверяем автоизацию
        createLetter(); // создаем письмо
        click(CLOSE_LETTER_BTN); // закрываем письмо
        click(DRAFT_BTN); // переходим в Черновики
        assertEquals(LOGIN_NAME, getText(DRAFT_ADDRESS)); // проверяем наличие письма в Черновиках
        click(LETTER_BTN); // открываем письмо
        click(SEND_LETTER_BTN); // отправляем письмо
        click(BACK_TO_INCOMING); // переходим во входящие
        click(DRAFT_BTN); // переходим в Черновики
        assertEquals(EMPTY_BOX_MESSAGE, getText(EMPTY_BOX)); // проверяем отсутствие писем в Черновиках
        click(SEND_BTN); // переходим в Отправленные
        assertEquals(LOGIN_NAME, getText(SEND_ADDRESS)); // проверяем наличие письма в Отправленных
        logOut(); // разлогиниваемся
    }

    @Test
    void speedyGonsalesTest2() {

    }


}
