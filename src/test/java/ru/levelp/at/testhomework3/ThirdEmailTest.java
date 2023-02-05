package ru.levelp.at.testhomework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.levlup.at.homework3.browser.BrowserActions.*;
import static ru.levlup.at.homework3.pages.AuthorizationPage.*;
import static ru.levlup.at.homework3.pages.DraftPage.*;
import static ru.levlup.at.homework3.pages.LetterPage.*;
import static ru.levlup.at.homework3.pages.MainPage.*;
import static ru.levlup.at.homework3.pages.SendLetterPage.*;

public class ThirdEmailTest {



    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        browserSetUp();
    }

    @AfterEach
    void tearDown() {
        browserClose();
    }

    @Test
    void speedyGonsalesTest3() {
        authorization(); // авторизируемся
        assertEquals(LOGIN, getText(AUTHORIZATION_CHECK_ELEM)); // проверяем авторизацию
        createLetter2(); // создаем письмо
        click(SEND_LETTER_BTN); // отправляем письмо
        click(BACK_TO_INCOMING); // открываем Входящие
        refresh();
        assertEquals(LOGIN_NAME, getText(SEND_ADDRESS)); // проверяем наличие письма во Входящих по отправителю
        assertEquals(THEME2, getText(SEND_THEME2)); // проверяем наличие письма во Входящих по теме
        assertEquals(BODY, getText(SEND_BODY)); // проверяем наличие письма во Входящих по телу
        click(CHECKBOX_IN_INCOMING);
        click(DELETE_BTN);
        click(DELETED_BTN);
        assertEquals(LOGIN_NAME, getText(SEND_ADDRESS)); // проверяем наличие письма в Корзине по отправителю
        assertEquals(THEME2, getText(SEND_THEME2)); // проверяем наличие письма в Корзине по теме
        assertEquals(BODY, getText(SEND_BODY)); // проверяем наличие письма в Корзине по телу
        logOut();
    }
}
